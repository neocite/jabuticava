/*
 * TesteDeListagemDeBdr.java criado em 17/02/2014
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
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
    Document doc = HtmlsFalso.DETALHES;
    Bdr res = new BdrParser(doc).get();

    assertThat(res.getCodigoDeNegocicao(), equalTo("MMMC34"));
    assertThat(res.getCodigoDeIsin(), equalTo("BRMMMCBDR000"));
  }

  public void bdr_com_colunas_vazias() {
    Document doc = HtmlsFalso.DETALHES_COLUNAS_VAZIA;
    Bdr res = new BdrParser(doc).get();

    assertThat(res.getCodigoDeNegocicao(), equalTo(""));
    assertThat(res.getCodigoDeIsin(), equalTo(""));
  }

}