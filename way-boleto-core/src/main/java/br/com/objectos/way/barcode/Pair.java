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

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class Pair {

  private final List<BarWidth> widths;

  private Pair(List<BarWidth> pair) {
    this.widths = pair;
  }

  public static Pair pairOf(int[] par) {
    List<BarWidth> ref1 = BarcodeType.INTERLEAVED_2_5.encode(par[0]);
    List<BarWidth> ref2 = BarcodeType.INTERLEAVED_2_5.encode(par[1]);

    BarWidth[] barWdths = new BarWidth[10];
    barWdths[0] = ref1.get(0);
    barWdths[1] = ref2.get(0);
    barWdths[2] = ref1.get(1);
    barWdths[3] = ref2.get(1);
    barWdths[4] = ref1.get(2);
    barWdths[5] = ref2.get(2);
    barWdths[6] = ref1.get(3);
    barWdths[7] = ref2.get(3);
    barWdths[8] = ref1.get(4);
    barWdths[9] = ref2.get(4);

    List<BarWidth> list = ImmutableList.copyOf(barWdths);

    return new Pair(list);
  }

  public List<BarWidth> getWidths() {
    return widths;
  }

}