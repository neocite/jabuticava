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

import com.google.common.base.Objects;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ContaReduzida {

  private static final ContaReduzida VAZIA = new ContaReduzida(0);

  private final int intValue;

  private ContaReduzida(int intValue) {
    this.intValue = intValue;
  }

  public static ContaReduzida of() {
    return VAZIA;
  }

  public static ContaReduzida valueOf(int val) {
    return new ContaReduzida(val);
  }

  public boolean isZero() {
    return intValue == 0;
  }

  public int get() {
    return intValue;
  }

  public int intValue() {
    return intValue;
  }

  String toLancamentoTxt() {
    String res = "       ";

    if (!isZero()) {
      res = String.format("%07d", intValue);
    }

    return res;
  }

  @Override
  public String toString() {
    String res = "";

    if (!isZero()) {
      res = String.format("%07d", intValue);
    }

    return res;
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(intValue);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof ContaReduzida) {
      final ContaReduzida that = (ContaReduzida) obj;
      return this.intValue == that.intValue;
    } else {
      return false;
    }
  }

}