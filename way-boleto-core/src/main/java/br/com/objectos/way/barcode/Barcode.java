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

import static com.google.common.collect.Lists.transform;

import java.util.List;

import br.com.objectos.way.barcode.i25.InterleavedTwoFive;

import com.google.common.base.Functions;
import com.google.common.base.Joiner;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Barcode {

  private final List<Bar> bars;

  private Barcode(List<Bar> bars) {
    this.bars = bars;
  }

  public static IntArrayBuilder encode(int[] digits) {
    return new IntArrayBuilder(digits);
  }

  public List<Bar> getBars() {
    return bars;
  }

  @Override
  public String toString() {
    List<String> strs = transform(bars, Functions.toStringFunction());
    return Joiner.on("").join(strs);
  }

  public static class IntArrayBuilder {

    private final int[] digits;

    public IntArrayBuilder(int[] digits) {
      this.digits = digits;
    }

    public Barcode asInterleavedTwoFive() {
      List<Bar> bars = InterleavedTwoFive.barsOf(digits);
      return new Barcode(bars);
    }

  }

}