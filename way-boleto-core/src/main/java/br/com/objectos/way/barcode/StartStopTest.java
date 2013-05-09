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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class StartStopTest {

  private StartStop startStop;

  @BeforeClass
  public void setUp() {
    startStop = new StartStop();
  }

  public void should_generate_bar_with_start_and_stop_empty() {
    List<Bar> input = ImmutableList.of();

    List<Bar> proof = ImmutableList.<Bar> builder()
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())

        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .build();

    List<Bar> res = startStop.of(input);
    assertThat(res.size(), equalTo(6));
    assertThat(res, equalTo(proof));
  }

  public void should_generate_bar_with_start_and_stop() {
    List<Bar> input = ImmutableList.<Bar> builder()
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.blackWide())

        .build();

    List<Bar> proof = ImmutableList.<Bar> builder()
        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())

        .add(Bar.blackNarrow())
        .add(Bar.whiteNarrow())
        .add(Bar.blackWide())
        .add(Bar.blackWide())

        .add(Bar.blackWide())
        .add(Bar.whiteNarrow())
        .add(Bar.blackNarrow())
        .build();

    List<Bar> res = startStop.of(input);
    assertThat(res.size(), equalTo(6 + 4));
    assertThat(res, equalTo(proof));
  }

}