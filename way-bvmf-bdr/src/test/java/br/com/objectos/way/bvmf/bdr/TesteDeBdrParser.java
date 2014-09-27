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

import static br.com.objectos.way.bvmf.bdr.BdrCategoria.DR3;
import static br.com.objectos.way.bvmf.bdr.BdrCategoria.DRN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeBdrParser {

  public void bdr() {
    BdrLink bdrLink = novoBdrLink(DRN);

    Document doc = HtmlsFalso.DETALHES;
    List<Bdr> bdrs = new BdrParser(doc, bdrLink).get();
    assertThat(bdrs.size(), equalTo(1));

    Bdr res = bdrs.get(0);
    assertThat(res.getCodigoDeNegocicao(), equalTo("MMMC34"));
    assertThat(res.getCodigoIsin(), equalTo("BRMMMCBDR000"));
    assertThat(res.getCategoria(), equalTo(BdrCategoria.DRN));
  }

  public void bdr_com_colunas_vazias() {
    BdrLink bdrLink = novoBdrLink(DRN);

    Document doc = HtmlsFalso.DETALHES_COLUNAS_VAZIA;
    List<Bdr> bdrs = new BdrParser(doc, bdrLink).get();
    assertThat(bdrs.size(), equalTo(1));

    Bdr res = bdrs.get(0);
    assertThat(res.getCodigoDeNegocicao(), equalTo(""));
    assertThat(res.getCodigoIsin(), equalTo(""));
    assertThat(res.getCategoria(), equalTo(BdrCategoria.DRN));
  }

  public void bdr_com_mais_de_um_codigo_negociao_isin() {
    BdrLink bdrLink = novoBdrLink(DR3);

    Document doc = HtmlsFalso.DETALHES_COLUNAS_CODIGOS;
    List<Bdr> bdrs = new BdrParser(doc, bdrLink).get();
    assertThat(bdrs.size(), equalTo(3));

    Bdr bdr0 = bdrs.get(0);
    assertThat(bdr0.getCodigoDeNegocicao(), equalTo("BBTG11"));
    assertThat(bdr0.getCodigoIsin(), equalTo("BRBBTGBDR002"));
    assertThat(bdr0.getCategoria(), equalTo(BdrCategoria.DR3));

    Bdr bdr1 = bdrs.get(1);
    assertThat(bdr1.getCodigoDeNegocicao(), equalTo("BBTG35"));
    assertThat(bdr1.getCodigoIsin(), equalTo("BRBBTGBDR010"));
    assertThat(bdr1.getCategoria(), equalTo(BdrCategoria.DR3));

    Bdr bdr2 = bdrs.get(2);
    assertThat(bdr2.getCodigoDeNegocicao(), equalTo("BBTG36"));
    assertThat(bdr2.getCodigoIsin(), equalTo("BRBBTGUNT007"));
    assertThat(bdr2.getCategoria(), equalTo(BdrCategoria.DR3));
  }

  private BdrLink novoBdrLink(BdrCategoria tipo) {
    return new ConstrutorDeBdrLinkFalso()
        .href("http://fake/ResumoEmpresaPrincipal.aspx?codigoCvm=12345")
        .categoria(tipo)
        .novaInstancia();
  }

}