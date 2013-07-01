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
import static org.hamcrest.Matchers.equalTo;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.testng.annotations.Test;

import br.com.objectos.way.bvmf.rf.cri.CriMap;
import br.com.objectos.way.bvmf.rf.cri.CriMapGen;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
@Test
public class TesteDeCriMapGen {

  public void emissor() {
    Document doc = HtmlsFalso.DETALHES;
    Element table = doc.select("table").first();
    CriMap res = new CriMapGen(table).get();

    assertThat(res.getString("Status atual da emissão:"), equalTo("ATIVO"));
    assertThat(res.getString("Local de negociação:"), equalTo("Bovespa Fix"));
  }

}