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
import static com.google.common.collect.Lists.transform;

import java.util.List;

import org.joda.time.LocalDate;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class LancamentoMM implements IsLancamento {

  interface Construtor {

    int getNumero();

    LocalDate getData();

    double getValor();

    List<SubLancamento> getLancamentos();

  }

  private static final String HEADER_TRAILER = Strings.repeat(" ", 5 + 200 + 42 + 42);

  private final int numero;
  private final LocalDate data;
  private final double valor;
  private final List<SubLancamento> lancamentos;

  private LancamentoMM(Construtor construtor) {
    numero = construtor.getNumero();
    data = construtor.getData();
    valor = construtor.getValor();
    lancamentos = construtor.getLancamentos();
  }

  static ConstrutorDeLancamentoMM multiploMultiplo(int numero, LocalDate data) {
    return new ConstrutorDeLancamentoMM(numero, data);
  }

  static LancamentoMM of(Construtor construtor) {
    return new LancamentoMM(construtor);
  }

  @Override
  public String toTxt() {
    Iterable<String> parts = toLines0();
    return Joiner.on("\r\n").join(parts);
  }

  private Iterable<String> toLines0() {
    String _header = header();
    List<String> header = ImmutableList.of(_header);
    List<String> subs = transform(lancamentos, new SubToTxt());
    return Iterables.concat(header, subs);
  }

  private String header() {
    return new StringBuilder()
        .append(toTxtPart("%07d", numero, 7))
        .append(data.toString("dd/MM"))
        .append("M      ")
        .append("M      ")
        .append(toTxtPart("%-17.2f", valor, 17))
        .append(HEADER_TRAILER)
        .toString();
  }

  private class SubToTxt implements Function<SubLancamento, String> {
    @Override
    public String apply(SubLancamento input) {
      return input
          .comNumero(numero)
          .toLancamentoTxt();
    }
  }

}