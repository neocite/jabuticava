/*
 * TesteDeDetalhesParser.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.comuns.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeFiiParser {

  private Fii fii;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.DETALHES;
    fii = new FiiParser(doc).get();
  }

  public void fii() {
    Fii res = fii;

    assertThat(res.getCodigo(), equalTo("FPAB11"));
    assertThat(res.getNome(), equalTo("FII A BRANCA"));
    assertThat(res.getCnpj(), equalTo(Cnpj.valueOf("03.251.720/0001-18")));
  }

  public void emissao() {
    FiiEmissao res = fii.getEmissao();

    assertThat(res.getData(), equalTo(new LocalDate(2006, 6, 30)));
    assertThat(res.getQuantidade(), equalTo(750000l));
  }

}