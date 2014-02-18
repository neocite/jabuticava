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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeBdrParser {

  public void bdr() {
    BdrLink bdrLink = novoBdrLink();

    Document doc = HtmlsFalso.DETALHES;
    BdrStage res = new BdrParser(doc, bdrLink).get();

    assertThat(res.getCategoria(), equalTo(CategoriaTipo.DRN));
    assertThat(res.getCodigoDeNegocicao(), equalTo("MMMC34"));
    assertThat(res.getCodigoDeIsin(), equalTo("BRMMMCBDR000"));
  }

  public void bdr_com_colunas_vazias() {
    BdrLink bdrLink = novoBdrLink();

    Document doc = HtmlsFalso.DETALHES_COLUNAS_VAZIA;
    BdrStage res = new BdrParser(doc, bdrLink).get();

    assertThat(res.getCategoria(), equalTo(CategoriaTipo.DRN));
    assertThat(res.getCodigoDeNegocicao(), equalTo(""));
    assertThat(res.getCodigoDeIsin(), equalTo(""));
  }

  private BdrLink novoBdrLink() {
    return new ConstrutorDeBdrLinkFalso()
        .href("http://fake/ResumoEmpresaPrincipal.aspx?codigoCvm=12345")
        .categoria(CategoriaTipo.DRN)
        .novaInstancia();
  }

}