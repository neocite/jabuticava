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

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
class CriMapGen {

  private final Element table;

  public CriMapGen(Element doc) {
    this.table = doc;
  }

  public CriMap get() {
    Elements trs = table.select("tr");

    Map<String, String> map = newHashMap();

    for (Element tr : trs) {
      Element key = tr.select("td").first();
      Element value = tr.select("td").last();

      String _key = key.text();
      String _value = value.text();

      map.put(_key, _value);
    }

    return new CriMap(map);
  }

}