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

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class SubLancamento {

  public static interface CMatic {

    DebitoCredito getTipo();

    LocalDate getData();

    ContaReduzida getConta();

    double getValor();

    HistoricoPadrao getHistoricoPadrao();

    ContaCentroCusto getCentroCusto();

  }

  private int numero;
  private final LocalDate data;
  private final ContaReduzida conta;
  private final double valor;
  private final HistoricoPadrao historicoPadrao;
  private final ContaCentroCusto centroCusto;

  public SubLancamento(CMatic cmatic) {
    data = cmatic.getData();
    conta = cmatic.getConta();
    valor = cmatic.getValor();
    historicoPadrao = cmatic.getHistoricoPadrao();
    centroCusto = cmatic.getCentroCusto();
  }

  static SubLancamento of(CMatic cmatic) {
    DebitoCredito tipo = cmatic.getTipo();
    return tipo.subLancamentoDe(cmatic);
  }

  String toLancamentoTxt() {
    return new StringBuilder()
        .append(toTxtPart("%07d", numero, 7))
        .append(data.toString("dd/MM"))
        .append(debito())
        .append(credito())
        .append(toTxtPart("%-17.2f", valor, 17))
        .append(historicoPadrao.toLancamentoTxt())
        .append(ccdb().toLancamentoTxt())
        .append(ccdr().toLancamentoTxt())
        .toString();
  }

  SubLancamento comNumero(int numero) {
    this.numero = numero;
    return this;
  }

  String debito() {
    return "T      ";
  }

  String credito() {
    return "T      ";
  }

  ContaCentroCusto ccdb() {
    return ContaCentroCusto.of();
  }

  ContaCentroCusto ccdr() {
    return ContaCentroCusto.of();
  }

  String getConta() {
    return conta.toString();
  }

  double getValor() {
    return valor;
  }

  double getValorCredito() {
    return 0;
  }

  double getValorDebito() {
    return 0;
  }

  ContaCentroCusto getCentroCusto() {
    return centroCusto;
  }

}