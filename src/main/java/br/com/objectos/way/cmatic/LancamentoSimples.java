/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.cmatic;

import static br.com.objectos.way.cmatic.WayCMatic.toTxtPart;

import java.util.List;

import org.joda.time.LocalDate;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class LancamentoSimples implements IsLancamento {

  public static interface Construtor {

    int getNumero();

    LocalDate getData();

    ContaReduzida getDebito();

    ContaReduzida getCredito();

    double getValor();

    HistoricoPadrao getHistoricoPadrao();

    ContaCentroCusto getCcdb();
    ContaCentroCusto getCcdr();

  }

  private final int numero;
  private final LocalDate data;
  private final ContaReduzida debito;
  private final ContaReduzida credito;
  private final double valor;
  private final HistoricoPadrao historicoPadrao;
  private final ContaCentroCusto ccdb;
  private final ContaCentroCusto ccdr;

  private LancamentoSimples(Construtor construtor) {
    numero = construtor.getNumero();
    data = construtor.getData();
    debito = construtor.getDebito();
    credito = construtor.getCredito();
    valor = construtor.getValor();
    historicoPadrao = construtor.getHistoricoPadrao();
    ccdb = construtor.getCcdb();
    ccdr = construtor.getCcdr();
  }

  public static LancamentoSimples of(Construtor construtor) {
    return new LancamentoSimples(construtor);
  }

  @Override
  public List<String> toLog() {
    return ImmutableList.of();
  }

  @Override
  public String toTxt() {
    return new StringBuilder()
        .append(toTxtPart("%07d", numero, 7))
        .append(data.toString("dd/MM"))
        .append(debito)
        .append(credito)
        .append(toTxtPart("%-17.2f", valor, 17))
        .append(historicoPadrao.toLancamentoTxt())
        .append(ccdb.toLancamentoTxt())
        .append(ccdr.toLancamentoTxt())
        .toString();
  }

}