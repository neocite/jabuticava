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
class HistoricoPadraoPojo extends HistoricoPadrao {

  private final int codigo;

  private final String complemento;

  public HistoricoPadraoPojo(Construtor construtor) {
    this.codigo = construtor.getCodigo();
    String _complemento = construtor.getComplemento();
    this.complemento = Strings.nullToEmpty(_complemento);
  }

  public HistoricoPadraoPojo(int codigo, String complemento) {
    this.codigo = codigo;
    this.complemento = complemento;
  }

  @Override
  String toLancamentoTxt() {
    return new StringBuilder()
        .append(codigoToLancamentoTxt())
        .append(toTxtPart("%-200s", complemento, 200))
        .toString();
  }

  @Override
  public int getCodigo() {
    return codigo;
  }

  @Override
  public String getComplemento() {
    return complemento;
  }

  private String codigoToLancamentoTxt() {
    String res = "     ";

    if (codigo != 0) {
      res = toTxtPart("%05d", codigo, 5);
    }

    return res;
  }

}