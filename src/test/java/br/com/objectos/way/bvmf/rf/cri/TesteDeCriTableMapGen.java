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
package br.com.objectos.way.bvmf.rf.cri;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.way.bvmf.rf.cri.CriTableMap;
import br.com.objectos.way.bvmf.rf.cri.CriTableMapGen;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeCriTableMapGen {

  private CriTableMapGen gen;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.DETALHES;
    gen = new CriTableMapGen(doc);
  }

  public void mapear_key_value() {
    CriTableMap res = gen.get();

    assertThat(res.get("Emissor"), notNullValue());
    assertThat(res.get("Características da Emissão"), notNullValue());
    assertThat(res.get("Características da Série"), notNullValue());
    assertThat(res.get("Remuneração"), notNullValue());
    assertThat(res.get("Informações relacionadas"), notNullValue());
  }

}