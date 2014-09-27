/*
 * TesteDeFundosListadosParser.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeListagemParser {

  private ListagemParser parser;

  private final int i0 = 0;
  private final int i1 = 1;
  private final int in = 106 - 1;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.LISTAGEM;
    parser = new ListagemParser(doc);
  }

  public void deve_retornar_todos_os_links() {
    List<FiiLink> res = parser.get();
    assertThat(res.size(), equalTo(106));

    List<String> cods = transform(res, new ToCodigo());
    assertThat(cods.get(i0), equalTo("FII A BRANCA"));
    assertThat(cods.get(i1), equalTo("FII ABC IMOB"));
    assertThat(cods.get(in), equalTo("FII XP MACAE"));

    List<String> hrefs = transform(res, new ToHref());
    assertThat(
        hrefs.get(i0),
        equalTo("http://fake/FundosListadosDetalhe.aspx?Sigla=FPAB&tipoFundo=Imobiliario&aba=abaPrincipal"));
    assertThat(
        hrefs.get(i1),
        equalTo("http://fake/FundosListadosDetalhe.aspx?Sigla=ABCP&tipoFundo=Imobiliario&aba=abaPrincipal"));
    assertThat(
        hrefs.get(in),
        equalTo("http://fake/FundosListadosDetalhe.aspx?Sigla=XPCM&tipoFundo=Imobiliario&aba=abaPrincipal"));
  }

  private class ToCodigo implements Function<FiiLink, String> {
    @Override
    public String apply(FiiLink input) {
      return input.getCodigo();
    }
  }

  private class ToHref implements Function<FiiLink, String> {
    @Override
    public String apply(FiiLink input) {
      return input.getHref();
    }
  }

}