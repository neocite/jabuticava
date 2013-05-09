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

import static br.com.objectos.way.barcode.BarWidth.NARROW;
import static br.com.objectos.way.barcode.BarWidth.WIDE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author "edenir.anschau@objectos.com.br (Edenir Norberto Anschau)"
 */
@Test
public class PairTest {

  public void deve_gerar_codigo_num_38() {
    // String number = "38";
    int[] par = {
      3,
      8 };

    List<BarWidth> proof;
    proof = ImmutableList.<BarWidth> builder()
        .add(WIDE)
        .add(WIDE)
        .add(WIDE)
        .add(NARROW)
        .add(NARROW)
        .add(NARROW)
        .add(NARROW)
        .add(WIDE)
        .add(NARROW)
        .add(NARROW)
        
        
        .build();

    Pair res = Pair.pairOf(par);
    List<BarWidth> widths = res.getWidths();

    assertThat(widths.size(), equalTo(10));
    assertThat(widths, equalTo(proof));
  }

}