/*
 * Copyright 2014 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.bvmf.bdr;

import static com.google.common.collect.Lists.transform;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ListagemParser {

  private final Document doc;

  public ListagemParser(Document doc) {
    this.doc = doc;
  }

  public List<BdrLink> get() {
    Elements anchors = doc.select("tbody");

    Elements trs = anchors.select("tr");

    List<BdrLink> links = transform(trs, new ToBdrLink());

    return ImmutableList.copyOf(links);
  }

  private class ToBdrLink implements Function<Element, BdrLink> {
    @Override
    public BdrLink apply(Element input) {
      return new Construtor(input).novaInstancia();
    }
  }

  private class Construtor implements BdrLink.Construtor {

    private final Element a;

    public Construtor(Element a) {
      this.a = a;
    }

    @Override
    public BdrLink novaInstancia() {
      return new BdrLinkPojo(this);
    }

    @Override
    public String getHref() {
      Element _href = a.select("a").first();
      String href = _href.attr("href");

      return doUrl(href);
    }

    private String doUrl(String href) {
      String url = "http://www.bmfbovespa.com.br/pt-br/mercados-internacionais/acoes/empresas/ExecutaAcaoConsultaInfoEmp.asp?CodCVM=";

      Pattern p = Pattern.compile("[?&]codigoCvm=(\\d+)");
      Matcher m = p.matcher(href);

      if (m.find()) {
        url = url + m.group(1);
      }
      return url;
    }

    @Override
    public BdrCategoria getCategoria() {
      Element td = a.select("td").get(1);
      String name = td.text();
      return BdrCategoria.valueOf(name);
    }

  }

}