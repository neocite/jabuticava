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
package br.com.objectos.way.barcode;

import static br.com.objectos.way.barcode.BarColor.BLACK;
import static br.com.objectos.way.barcode.BarColor.WHITE;
import static br.com.objectos.way.barcode.BarWidth.NARROW;
import static br.com.objectos.way.barcode.BarWidth.WIDE;

import com.google.common.base.Objects;

/**
 * @author "edenir.anschau@objectos.com.br (Edenir Norberto Anschau)"
 */
public class Bar {

  private final BarWidth width;
  private final BarColor color;

  Bar(BarWidth width, BarColor color) {
    this.width = width;
    this.color = color;
  }

  public static Bar whiteNarrow() {
    return new Bar(NARROW, WHITE);
  }

  public static Bar blackNarrow() {
    return new Bar(NARROW, BLACK);
  }

  public static Bar whiteWide() {
    return new Bar(WIDE, WHITE);
  }

  public static Bar blackWide() {
    return new Bar(WIDE, BLACK);
  }

  public BarWidth getWidth() {
    return width;
  }

  public BarColor getColor() {
    return color;
  }

  @Override
  public String toString() {
    String l = BarColor.BLACK.equals(color) ? "x" : " ";

    if (BarWidth.WIDE.equals(width)) {
      return l + l;
    } else {
      return l;
    }
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(width, color);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof Bar) {
      final Bar that = (Bar) obj;
      return Objects.equal(this.width, that.width)
          && Objects.equal(this.color, that.color);
    } else {
      return false;
    }
  }

}