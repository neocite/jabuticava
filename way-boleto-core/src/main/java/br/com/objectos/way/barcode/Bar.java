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

  private static final Bar WHITE_NARROW = new Bar(WHITE, NARROW);
  private static final Bar WHITE_WIDE = new Bar(WHITE, WIDE);

  private static final Bar BLACK_NARROW = new Bar(BLACK, NARROW);
  private static final Bar BLACK_WIDE = new Bar(BLACK, WIDE);

  private final BarColor color;
  private final BarWidth width;

  private Bar(BarColor color, BarWidth width) {
    this.color = color;
    this.width = width;
  }

  public static Bar of(BarColor color, BarWidth width) {
    return new Bar(color, width);
  }

  public static Bar whiteNarrow() {
    return WHITE_NARROW;
  }

  public static Bar blackNarrow() {
    return BLACK_NARROW;
  }

  public static Bar whiteWide() {
    return WHITE_WIDE;
  }

  public static Bar blackWide() {
    return BLACK_WIDE;
  }

  public BarWidth getWidth() {
    return width;
  }

  public BarColor getColor() {
    return color;
  }

  @Override
  public String toString() {
    String symbol = BLACK.equals(color) ? "x" : " ";
    return WIDE.equals(width) ? symbol + symbol : symbol;
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