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
package br.com.objectos.way.boleto;

import br.com.objectos.way.barcode.Bar;
import br.com.objectos.way.barcode.BarColor;
import br.com.objectos.way.barcode.BarWidth;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class MustacheBarra {

  private final Bar bar;

  public MustacheBarra(Bar bar) {
    this.bar = bar;
  }

  public String getStyleClass() {
    BarColor color = bar.getColor();
    String colorName = color.name();

    BarWidth width = bar.getWidth();
    String widthName = width.name();

    return String.format("bc-%s bc-%s", colorName.toLowerCase(), widthName.toLowerCase());
  }

}