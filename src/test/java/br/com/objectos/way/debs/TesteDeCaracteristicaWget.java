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
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import br.com.objectos.way.io.LineKey;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.ToStringVal;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test(groups = "manual")
public class TesteDeCaracteristicaWget {

  public void download() throws IOException {
    Caracteristica caracteristica = Caracteristica.wget();

    List<Record> regs = caracteristica.getRegistros();
    assertThat(regs.isEmpty(), is(false));

    LineKey<String> key = keys().codigo();
    List<String> res = transform(regs, new ToStringVal(key));
    for (String codigo : res) {
      System.out.println(codigo);
    }
  }

}