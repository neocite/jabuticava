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

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Preconditions;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BdrParser {

  private final Document doc;
  private final BdrLink bdrLink;

  public BdrParser(Document doc, BdrLink bdrLink) {
    this.doc = doc;
    this.bdrLink = bdrLink;
  }

  public BdrStage get() {
    return new Construtor().novaInstancia();
  }

  private class Construtor implements BdrStage.Construtor {

    private final Element div;

    public Construtor() {
      this.div = doc.getElementById("colunaCentral");
    }

    @Override
    public BdrStage novaInstancia() {
      return new BdrStagePojo(this);
    }

    @Override
    public CategoriaTipo getCategoria() {
      return bdrLink.getCategoria();
    }

    @Override
    public String getCodigoDeNegocicao() {
      return parse(".tabelaSemBorda td", 5);
    }

    @Override
    public String getCodigoDeIsin() {
      return parse("#divCodigosOculto td", 3);
    }

    private String parse(String find, int indice) {
      Elements anchors = div.select(find);
      Preconditions.checkArgument(anchors.size() > indice);

      String res = "";
      if (anchors.size() > 0) {
        Element a = anchors.get(indice);
        res = a.text();
      }

      return res;
    }

  }

}