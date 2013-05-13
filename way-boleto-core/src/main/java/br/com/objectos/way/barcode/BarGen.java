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

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BarGen {

  public List<Bar> of(List<BarWidth> widths) {
    List<Bar> res = newArrayList();

    for (int i = 0; i < widths.size(); i++) {
      BarWidth barWidth = widths.get(i);
      BarColor color = i % 2 == 0 ? BarColor.BLACK : BarColor.WHITE;
      Bar bar = new Bar(barWidth, color);
      res.add(bar);
    }

    return res;
  }

}