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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeListagemParser {

  private ListagemParser parser;

  private final int i0 = 0;
  private final int i1 = 1;
  private final int in = 81 - 3;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.LISTAGEM;
    parser = new ListagemParser(doc);
  }

  public void deve_retornar_todos_os_links() {
    List<BdrLink> res = parser.get();
    assertThat(res.size(), equalTo(81));

    List<String> links = transform(res, new ToLink());
    assertThat(
        links.get(i0),
        equalTo("http://fake/ResumoEmpresaPrincipal.aspx?codigoCvm=50504&bdr="));
    assertThat(
        links.get(i1),
        equalTo("http://fake/ResumoEmpresaPrincipal.aspx?codigoCvm=50512&bdr="));
    assertThat(
        links.get(in),
        equalTo("http://fake/ResumoEmpresaPrincipal.aspx?codigoCvm=50130&bdr="));

    List<String> categorias = transform(res, new ToCategoria());
    assertThat(categorias.get(i0), equalTo("DRN"));
    assertThat(categorias.get(i1), equalTo("DRN"));
    assertThat(categorias.get(in), equalTo("DRN"));
  }

  private class ToLink implements Function<BdrLink, String> {
    @Override
    public String apply(BdrLink input) {
      return input.getHref();
    }
  }

  private class ToCategoria implements Function<BdrLink, String> {
    @Override
    public String apply(BdrLink input) {
      return input.getCategoria();
    }
  }

}