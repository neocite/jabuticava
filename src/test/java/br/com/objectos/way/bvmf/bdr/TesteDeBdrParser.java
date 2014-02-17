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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeBdrParser {

  private Bdr bdr;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.DETALHES;
    bdr = new BdrParser(doc).get();
  }

  public void bdr() {
    Bdr res = bdr;

    assertThat(res.getCodigoDeNegocicao(), equalTo("MMMC34"));
    assertThat(res.getCodigoDeIsin(), equalTo("BRMMMCBDR000"));
  }

}