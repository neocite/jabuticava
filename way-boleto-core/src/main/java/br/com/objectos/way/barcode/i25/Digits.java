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

import static br.com.objectos.way.barcode.BarWidth.NARROW;
import static br.com.objectos.way.barcode.BarWidth.WIDE;
import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import br.com.objectos.way.barcode.BarWidth;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class Digits {

  @SuppressWarnings("unchecked")
  private static final List<BarWidth>[] numbers = new List[] {
    ImmutableList.of(NARROW, NARROW, WIDE, WIDE, NARROW),
    ImmutableList.of(WIDE, NARROW, NARROW, NARROW, WIDE),
    ImmutableList.of(NARROW, WIDE, NARROW, NARROW, WIDE),
    ImmutableList.of(WIDE, WIDE, NARROW, NARROW, NARROW),
    ImmutableList.of(NARROW, NARROW, WIDE, NARROW, WIDE),
    ImmutableList.of(WIDE, NARROW, WIDE, NARROW, NARROW),
    ImmutableList.of(NARROW, WIDE, WIDE, NARROW, NARROW),
    ImmutableList.of(NARROW, NARROW, NARROW, WIDE, WIDE),
    ImmutableList.of(WIDE, NARROW, NARROW, WIDE, NARROW),
    ImmutableList.of(NARROW, WIDE, NARROW, WIDE, NARROW) };

  private Digits() {
  }

  public static List<BarWidth> encode(int val) {
    checkArgument(val >= 0 && val < 10, "Value must be in the interval [0,9]");
    return numbers[val];
  }

}