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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
@Test
public class InterleavedTwoFiveTest {

  public void encode_digits() {
    int[] digits = { 2, 3, 7, 9, 5, 2, 5, 0, 0, 0, 0, 0, 0, 0, 3, 4, 0, 0, 0, 0, 1, 2, 3, 0, 6, 0, 0, 0, 0, 0, 0, 0, 1, 0, 5, 0, 0, 0, 1, 2, 3, 4, 5, 0 };

    List<Bar> proof = ImmutableList.<Bar> builder()
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteWide())
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())

        .build();

    Barcode res = Barcode.encode(digits).asInterleavedTwoFive();
    List<Bar> bars = res.getBars();

    assertThat(bars.size(), equalTo(44 * 5 + 7));

    String _b = res.toString();
    String _p = toString(proof);

    System.out.println("res: " + _b);
    System.out.println("pro: " + _p);

    assertThat(_b, equalTo(_p));
  }

  private String toString(List<Bar> bars) {
    List<String> strs = transform(bars, Functions.toStringFunction());
    return Joiner.on("").join(strs);
  }

}