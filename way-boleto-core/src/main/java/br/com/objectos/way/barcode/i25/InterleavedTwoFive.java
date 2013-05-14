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
package br.com.objectos.way.barcode.i25;

import java.util.List;

import br.com.objectos.way.barcode.Bar;
import br.com.objectos.way.barcode.BarWidth;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class InterleavedTwoFive {

  private InterleavedTwoFive() {
  }

  public static List<Bar> barsOf(int[] digits) {
    List<Pair> pairs = Pair.pairOf(digits);
    List<BarWidth> widths = Joiner.join(pairs);
    List<Bar> bars = Encoder.of(widths);
    return StartStop.decorate(bars);
  }

}