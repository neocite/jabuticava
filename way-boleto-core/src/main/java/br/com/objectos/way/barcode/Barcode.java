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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Barcode {

  private final List<Bar> bars;

  private Barcode(List<Bar> bars) {
    this.bars = bars;
  }

  public static Barcode of(int[] barcodes) {
    List<Pair> pairs = Pair.pairOf(barcodes);
    List<BarWidth> widths = new PairGen().pair(pairs);
    List<Bar> bars = new BarGen().of(widths);
    List<Bar> _bars = new StartStop().of(bars);
    return new Barcode(_bars);
  }

  public List<Bar> getBars() {
    return bars;
  }

}