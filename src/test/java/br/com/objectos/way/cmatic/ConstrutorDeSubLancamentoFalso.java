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

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.Construtor;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ConstrutorDeSubLancamentoFalso implements SubLancamento.Construtor, Construtor<SubLancamento> {

  private DebitoCredito tipo = DebitoCredito.CREDITO;
  private LocalDate data;
  private ContaReduzida conta;
  private double valor;
  private HistoricoPadrao historicoPadrao;
  private ContaCentroCusto centroCusto = ContaCentroCusto.of();

  @Override
  public SubLancamento novaInstancia() {
    return SubLancamento.of(this);
  }

  public ConstrutorDeSubLancamentoFalso tipo(DebitoCredito tipo) {
    this.tipo = tipo;
    return this;
  }

  public ConstrutorDeSubLancamentoFalso data(LocalDate data) {
    this.data = data;
    return this;
  }

  public ConstrutorDeSubLancamentoFalso conta(int conta) {
    this.conta = ContaReduzida.valueOf(conta);
    return this;
  }

  public ConstrutorDeSubLancamentoFalso valor(double valor) {
    this.valor = valor;
    return this;
  }

  public ConstrutorDeSubLancamentoFalso historicoPadrao(HistoricoPadrao historicoPadrao) {
    this.historicoPadrao = historicoPadrao;
    return this;
  }

  public ConstrutorDeSubLancamentoFalso centroCusto(ContaCentroCusto centroCusto) {
    this.centroCusto = centroCusto;
    return this;
  }

  @Override
  public DebitoCredito getTipo() {
    return tipo;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public ContaReduzida getConta() {
    return conta;
  }

  @Override
  public double getValor() {
    return valor;
  }

  @Override
  public HistoricoPadrao getHistoricoPadrao() {
    return historicoPadrao;
  }

  @Override
  public ContaCentroCusto getCentroCusto() {
    return centroCusto;
  }

}