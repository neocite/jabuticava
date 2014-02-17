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

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class HtmlsFalso {

  public static final Document LISTAGEM = html("/bdr/BdrListagem.html");
  public static final Document DETALHES = html("/bdr/BrdsListadosDetalhes.html");
  public static final Document DETALHES_COLUNAS_VAZIA = html("/bdr/BrdsListadosDetalhes_Coluna_Vazia.html");

  private HtmlsFalso() {
  }

  private static Document html(String resourceName) {
    try {
      URL url = Resources.getResource(HtmlsFalso.class, resourceName);
      String html = Resources.toString(url, Charsets.ISO_8859_1);
      return Jsoup.parse(html, "http://fake");
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

}