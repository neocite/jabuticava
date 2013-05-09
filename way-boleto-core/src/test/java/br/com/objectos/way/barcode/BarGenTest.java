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
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class BarGenTest {

  private BarGen gen;

  @BeforeClass
  public void setUp() {
    gen = new BarGen();
  }

  public void should_generate_barcode_with_colors() {
    List<BarWidth> widths = ImmutableList.of(WIDE, NARROW);

    List<Bar> res = gen.of(widths);

    List<BarWidth> w = transform(res, new ToWidth());
    assertThat(w.size(), equalTo(2));
    assertThat(w.get(0), equalTo(WIDE));
    assertThat(w.get(1), equalTo(NARROW));

    List<BarColor> c = transform(res, new ToColor());
    assertThat(c.size(), equalTo(2));
    assertThat(c.get(0), equalTo(BLACK));
    assertThat(c.get(1), equalTo(WHITE));
  }

  public void should_generate_barcode_with_four_colors() {
    List<BarWidth> widths = ImmutableList.of(WIDE, NARROW, NARROW, WIDE);

    List<Bar> res = gen.of(widths);

    List<BarWidth> w = transform(res, new ToWidth());
    assertThat(w.size(), equalTo(4));
    assertThat(w.get(0), equalTo(WIDE));
    assertThat(w.get(1), equalTo(NARROW));
    assertThat(w.get(2), equalTo(NARROW));
    assertThat(w.get(3), equalTo(WIDE));

    List<BarColor> c = transform(res, new ToColor());
    assertThat(c.size(), equalTo(4));
    assertThat(c.get(0), equalTo(BLACK));
    assertThat(c.get(1), equalTo(WHITE));
    assertThat(c.get(2), equalTo(BLACK));
    assertThat(c.get(3), equalTo(WHITE));
  }

  private class ToWidth implements Function<Bar, BarWidth> {
    @Override
    public BarWidth apply(Bar input) {
      return input.getWidth();
    }
  }

  private class ToColor implements Function<Bar, BarColor> {
    @Override
    public BarColor apply(Bar input) {
      return input.getColor();
    }
  }

}