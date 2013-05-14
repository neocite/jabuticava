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
import static br.com.objectos.way.barcode.i25.Digits.encode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.com.objectos.way.barcode.BarWidth;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class DigitsTest {

  @DataProvider
  public Object[][] codes() {
    // http://www.polylabel.com/barcodes/types/intercode.php
    return new Object[][] {
      { 0, ImmutableList.of(NARROW, NARROW, WIDE, WIDE, NARROW) },
      { 1, ImmutableList.of(WIDE, NARROW, NARROW, NARROW, WIDE) },
      { 2, ImmutableList.of(NARROW, WIDE, NARROW, NARROW, WIDE) },
      { 3, ImmutableList.of(WIDE, WIDE, NARROW, NARROW, NARROW) },
      { 4, ImmutableList.of(NARROW, NARROW, WIDE, NARROW, WIDE) },
      { 5, ImmutableList.of(WIDE, NARROW, WIDE, NARROW, NARROW) },
      { 6, ImmutableList.of(NARROW, WIDE, WIDE, NARROW, NARROW) },
      { 7, ImmutableList.of(NARROW, NARROW, NARROW, WIDE, WIDE) },
      { 8, ImmutableList.of(WIDE, NARROW, NARROW, WIDE, NARROW) },
      { 9, ImmutableList.of(NARROW, WIDE, NARROW, WIDE, NARROW) },
    };
  }

  @Test(dataProvider = "codes")
  public void zero_to_nine(Integer val, List<BarWidth> proof) {
    List<BarWidth> res = encode(val.intValue());

    assertThat(res.size(), equalTo(5));
    assertThat(res, equalTo(proof));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void illegal_lt_zero() {
    encode(-1);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void illegal_gt_nine() {
    encode(10);
  }

}