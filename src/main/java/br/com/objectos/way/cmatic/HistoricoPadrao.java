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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public abstract class HistoricoPadrao {

  private static final HistoricoPadrao VAZIO = hpOf("");

  public static interface Construtor
      extends br.com.objectos.comuns.base.Construtor<HistoricoPadrao> {

    int getCodigo();

    String getComplemento();

  }

  public static HistoricoPadrao of() {
    return VAZIO;
  }
  public static HistoricoPadrao of(Construtor construtor) {
    return new HistoricoPadraoPojo(construtor);
  }
  public static HistoricoPadrao hpOf(int codigo, String complemento) {
    return new HistoricoPadraoPojo(codigo, complemento);
  }
  public static HistoricoPadrao hpOf(String complemento) {
    return new HistoricoPadraoPojo(0, complemento);
  }

  abstract String toLancamentoTxt();

  abstract int getCodigo();

  abstract String getComplemento();

}