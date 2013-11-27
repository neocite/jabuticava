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

import br.com.objectos.way.base.Base10;

import com.google.common.base.Objects;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ContaAnalitica {

  private final long longValue;

  private final String toString;

  private ContaAnalitica(long longValue, String toString) {
    this.longValue = longValue;
    this.toString = toString;
  }

  public static ContaAnalitica parse(String cc) {
    String cleaned = cc.replaceAll("[^0-9]", "");
    int length = cleaned.length();
    long longValue = length > 0 ? Long.parseLong(cleaned) : 0l;
    String toString = length == 10 ? parseToString(cleaned, longValue) : cleaned;

    return new ContaAnalitica(longValue, toString);
  }

  private static String parseToString(String cleaned, long longValue) {
    int[] array = Base10.toArray(longValue);
    return new StringBuilder()
        .append(array[0])
        .append(".")
        .append(array[1])
        .append(".")
        .append(array[2])
        .append(".")
        .append(array[3])
        .append(array[4])
        .append(".")
        .append(array[5])
        .append(array[6])
        .append(array[7])
        .append(array[8])
        .append(array[9])
        .toString();
  }

  public long longValue() {
    return longValue;
  }

  @Override
  public String toString() {
    return toString;
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(longValue);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof ContaAnalitica) {
      final ContaAnalitica that = (ContaAnalitica) obj;
      return this.longValue == that.longValue;
    } else {
      return false;
    }
  }

}