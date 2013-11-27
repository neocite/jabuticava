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

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ContaCentroCusto {

  private static final ContaCentroCusto VAZIO = new ContaCentroCusto("");

  private final String toString;

  private ContaCentroCusto(String toString) {
    this.toString = toString;
  }

  public static ContaCentroCusto parse(String text) {
    String val = Strings.nullToEmpty(text);
    return new ContaCentroCusto(val);
  }

  public static ContaCentroCusto of() {
    return VAZIO;
  }

  @Override
  public String toString() {
    return toString;
  }

  String toLancamentoTxt() {
    return WayCMatic.toTxtPart("%-42s", toString, 42);
  }

}