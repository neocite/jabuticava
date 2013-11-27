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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.Construtor;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ConstrutorDeLancamentoMM implements LancamentoMM.Construtor, Construtor<LancamentoMM> {

  private final int numero;
  private final LocalDate data;
  private double valorCredito;
  private double valorDebito;
  private final List<SubLancamento> lancamentos = newArrayList();

  ConstrutorDeLancamentoMM(int numero, LocalDate data) {
    this.numero = numero;
    this.data = data;
  }

  @Override
  public LancamentoMM novaInstancia() {
    Preconditions.checkArgument(valorCredito == valorDebito,
        "Diferença contábil: valores de débito e crédito não são iguais.");
    return LancamentoMM.of(this);
  }

  public ConstrutorDeLancamentoMM add(SubLancamento lancamento) {
    valorCredito += lancamento.getValorCredito();
    valorDebito += lancamento.getValorDebito();
    lancamentos.add(lancamento);
    return this;
  }

  public ConstrutorDeLancamentoMM addAll(Iterable<? extends SubLancamento.CMatic> cmatics) {
    for (SubLancamento.CMatic cmatic : cmatics) {
      SubLancamento lancamento = SubLancamento.of(cmatic);
      add(lancamento);
    }
    return this;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public double getValor() {
    return valorCredito;
  }

  @Override
  public List<SubLancamento> getLancamentos() {
    return ImmutableList.copyOf(lancamentos);
  }

}