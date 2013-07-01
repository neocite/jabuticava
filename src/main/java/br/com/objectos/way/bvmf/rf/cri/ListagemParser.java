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

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
class ListagemParser {

  private final Document doc;

  public ListagemParser(Document doc) {
    this.doc = doc;
  }

  public List<CriLink> get() {
    Elements anchors = doc.select("#DivMiolo a");

    List<CriLink> links = Lists.transform(anchors, new ToCriLink());

    return ImmutableList.copyOf(links);

  }

  private class ToCriLink implements Function<Element, CriLink> {

    @Override
    public CriLink apply(Element input) {
      return new Construtor(input).novaInstancia();
    }

  }

  private class Construtor implements CriLink.Construtor {

    private final Element a;

    public Construtor(Element a) {
      this.a = a;
    }

    @Override
    public CriLink novaInstancia() {
      return new CriLinkPojo(this);
    }

    @Override
    public String getCodigo() {
      return a.text();
    }

    @Override
    public String getHref() {
      return a.attr("abs:href");
    }

  }

}