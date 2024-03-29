/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.cnab;

import static br.com.objectos.way.cnab.WayCnab.lote;
import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.objectos.comuns.io.FixedLine;
import br.com.objectos.way.cnab.remessa.InstrucaoSet;
import br.com.objectos.way.cnab.remessa.InstrucaoTipo;
import br.com.objectos.way.cnab.remessa.InstrucaoTipoVazio;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum Banco implements InstrucaoSet, OcorrenciaSpecSet {

  BRADESCO(237, Bradesco.banco, Bradesco.ocorrenciaParser) {
    @Override
    RemessaBuilder newRemessaBuilder() {
      return new BradescoRemessaBuilder(this);
    }

    @Override
    public List<InstrucaoTipo> getInstrucoes() {
      return BradescoInstrucao.values();
    }

    @Override
    public InstrucaoTipo getInstrucao(int codigo) {
      return BradescoInstrucao.get(codigo);
    }
  },

  ITAU(341, Itau.banco, Itau.ocorrenciaParser) {
    @Override
    String getNumeroCobranca(Lote lote) {
      String numero = lote.get(Itau.lote().nossoNumero());
      Integer dac = lote.get(Itau.lote().dacNossoNumero2());
      return String.format("%s%d", numero, dac.intValue());
    }

    @Override
    RemessaBuilder newRemessaBuilder() {
      return new ItauRemessaBuilder(this);
    }

    @Override
    public List<InstrucaoTipo> getInstrucoes() {
      return ItauInstrucao.values();
    }

    @Override
    public InstrucaoTipo getInstrucao(int codigo) {
      return ItauInstrucao.get(codigo);
    }
  },

  OUTROS(999, WayCnab.banco, new CnabOcorrenciaParser()) {
    @Override
    RemessaBuilder newRemessaBuilder() {
      return null;
    }

    @Override
    public List<InstrucaoTipo> getInstrucoes() {
      return ImmutableList.of();
    }

    @Override
    public InstrucaoTipo getInstrucao(int codigo) {
      return InstrucaoTipoVazio.get();
    }
  };

  private static final Map<Integer, Banco> codigoMap = newHashMap();

  static {
    for (Banco banco : Banco.values()) {
      int codigo = banco.getCodigo();
      codigoMap.put(codigo, banco);
    }
  }

  private final int codigo;

  private final Modelo modelo;

  private final OcorrenciaParser ocorrenciaParser;

  private final Map<String, OcorrenciaSpec> ocorrenciaSpecMap;

  private final List<OcorrenciaSpec> ocorrenciaSpecs;

  private final List<OcorrenciaEvento> ocorrenciaEventos;

  private Banco(int codigo, Modelo modelo, OcorrenciaParser ocorrenciaParser) {
    this.codigo = codigo;
    this.modelo = modelo;
    this.ocorrenciaParser = ocorrenciaParser;
    this.ocorrenciaSpecMap = ocorrenciaParser.toSpecMap();

    Collection<OcorrenciaSpec> values = ocorrenciaSpecMap.values();
    this.ocorrenciaSpecs = ImmutableList.copyOf(values);

    List<List<OcorrenciaEvento>> eventos = transform(ocorrenciaSpecs, new ToOcorrenciaEvento());
    Iterable<OcorrenciaEvento> eventosIter = Iterables.concat(eventos);
    this.ocorrenciaEventos = ImmutableList.copyOf(eventosIter);
  }

  public static Banco valueOf(int codigo) {
    Banco banco = OUTROS;

    if (codigoMap.containsKey(codigo)) {
      banco = codigoMap.get(codigo);
    }

    return banco;
  }

  public int getCodigo() {
    return codigo;
  }

  public Modelo getModelo() {
    return modelo;
  }

  @Override
  public List<OcorrenciaSpec> getOcorrenciaSpecs() {
    return ocorrenciaSpecs;
  }

  @Override
  public OcorrenciaSpec getOcorrenciaSpec(String codigo) {
    return ocorrenciaSpecMap.get(codigo);
  }

  @Override
  public List<OcorrenciaEvento> getOcorrenciaEventos() {
    return ocorrenciaEventos;
  }

  @Override
  public OcorrenciaEvento getOcorrenciaEvento(String codigo, String motivo) {
    OcorrenciaEvento evento = null;

    OcorrenciaSpec spec = getOcorrenciaSpec(codigo);
    if (spec != null) {
      evento = spec.getEvento(motivo);
    }

    return evento;
  }

  String getNumeroCobranca(Lote lote) {
    return lote.get(lote().nossoNumero());
  }

  abstract RemessaBuilder newRemessaBuilder();

  Object parseOcorrencia(FixedLine line) {
    return ocorrenciaParser.apply(line);
  }

  private static class ToOcorrenciaEvento implements
      Function<OcorrenciaSpec, List<OcorrenciaEvento>> {
    @Override
    public List<OcorrenciaEvento> apply(OcorrenciaSpec input) {
      return input.getEventos();
    }
  }

}