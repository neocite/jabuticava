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

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class HistoricoPadrao {

  interface CMatic {

    int getCodigo();

    String getComplemento();

  }

  private static final HistoricoPadrao VAZIO = hpOf("");

  private final int codigo;

  private final String complemento;

  public HistoricoPadrao(CMatic cmatic) {
    this.codigo = cmatic.getCodigo();
    String _complemento = cmatic.getComplemento();
    this.complemento = Strings.nullToEmpty(_complemento);
  }

  public HistoricoPadrao(int codigo, String complemento) {
    this.codigo = codigo;
    this.complemento = complemento;
  }

  static HistoricoPadrao of() {
    return VAZIO;
  }
  static HistoricoPadrao of(CMatic cmatic) {
    return new HistoricoPadrao(cmatic);
  }
  static HistoricoPadrao hpOf(int codigo, String complemento) {
    return new HistoricoPadrao(codigo, complemento);
  }
  static HistoricoPadrao hpOf(String complemento) {
    return new HistoricoPadrao(0, complemento);
  }

  String toLancamentoTxt() {
    return new StringBuilder()
        .append(codigoToLancamentoTxt())
        .append(toTxtPart("%-200s", complemento, 200))
        .toString();
  }

  private String codigoToLancamentoTxt() {
    String res = "     ";

    if (codigo != 0) {
      res = toTxtPart("%05d", codigo, 5);
    }

    return res;
  }

}