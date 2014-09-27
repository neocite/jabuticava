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

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CriTableMapGen {

  private final Document doc;

  public CriTableMapGen(Document doc) {
    this.doc = doc;
  }

  public CriTableMap get() {
    Map<String, CriMap> map = newHashMap();

    Element miolo = doc.getElementById("DivMiolo");
    Elements ps = miolo.select("p.txtSubtit");

    for (Element p : ps) {
      String key = p.text();
      Element table = p.nextElementSibling();
      CriMap value = new CriMapGen(table).get();
      map.put(key, value);
    }

    return new CriTableMap(map);
  }

}