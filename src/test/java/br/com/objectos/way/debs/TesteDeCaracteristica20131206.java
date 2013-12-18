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
package br.com.objectos.way.debs;

import static br.com.objectos.way.debs.Caracteristica.keys;
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.way.io.LineKey;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.ToIntegerVal;
import br.com.objectos.way.io.ToStringVal;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeCaracteristica20131206 {

  private Caracteristica snd;
  private List<Record> regs;

  private final int i0 = 4 - 4;
  private final int i1 = 5 - 4;
  private final int i2 = 7 - 4;

  @BeforeClass
  public void prepararRegistros() {
    String text = CaracteristicasFalso.CARACTERISTICAS_20131206;
    snd = Caracteristica.parseString(text);
    regs = snd.getRegistros();
  }

  public void serie() {
    LineKey<String> key = keys().serie();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("UNI"));
    assertThat(res.get(i1), equalTo("UNI"));
    assertThat(res.get(i2), equalTo("001"));
  }

  public void emissao() {
    LineKey<Integer> key = keys().emissao();
    List<Integer> res = transform(regs, new ToIntegerVal(key));

    assertThat(res.get(i0), equalTo(1));
    assertThat(res.get(i1), equalTo(2));
    assertThat(res.get(i2), equalTo(5));
  }

}