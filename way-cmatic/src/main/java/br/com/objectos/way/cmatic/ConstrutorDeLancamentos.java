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

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeLancamentos implements Lancamentos.CMatic, Construtor<Lancamentos> {

  private final String empresa;
  private final LocalDate ano;

  private final List<IsLancamento> lancamentos = newArrayList();

  ConstrutorDeLancamentos(String empresa, LocalDate ano) {
    this.empresa = empresa;
    this.ano = ano;
  }

  @Override
  public Lancamentos novaInstancia() {
    return Lancamentos.of(this);
  }

  public ConstrutorDeLancamentos add(IsLancamento lancamento) {
    lancamentos.add(lancamento);
    return this;
  }

  public ConstrutorDeLancamentos addAll(Iterable<? extends IsLancamento> lancamentos) {
    for (IsLancamento lancamento : lancamentos) {
      add(lancamento);
    }
    return this;
  }

  @Override
  public String getEmpresa() {
    return empresa;
  }

  @Override
  public LocalDate getAno() {
    return ano;
  }

  @Override
  public List<IsLancamento> getLancamentos() {
    return ImmutableList.copyOf(lancamentos);
  }

}