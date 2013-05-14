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

import static br.com.objectos.way.barcode.BarWidth.N;
import static br.com.objectos.way.barcode.BarWidth.W;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import br.com.objectos.way.barcode.BarWidth;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class JoinerTest {

  public void should_join() {
    Pair pair38 = Pair.pairOf(3, 8);
    Pair pair52 = Pair.pairOf(5, 2);

    List<BarWidth> proof_38;
    proof_38 = ImmutableList.of(W(), W(), W(), N(), N(), N(), N(), W(), N(), N());
    List<BarWidth> proof_52;
    proof_52 = ImmutableList.of(W(), N(), N(), W(), W(), N(), N(), N(), N(), W());

    List<BarWidth> proof;
    proof = ImmutableList.<BarWidth> builder()
        .addAll(proof_38)
        .addAll(proof_52)
        .build();

    List<Pair> pairs = ImmutableList.of(pair38, pair52);
    List<BarWidth> res = Joiner.join(pairs);

    assertThat(res.size(), equalTo(20));
    assertThat(res, equalTo(proof));
  }

}