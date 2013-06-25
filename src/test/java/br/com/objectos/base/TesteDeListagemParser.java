/*
 * TesteDeListagemParser.java criado em 25/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
@Test
public class TesteDeListagemParser {

  private ListagemParser parser;

  private final int i0 = 0;
  private final int i1 = 1;
  private final int in = 142 - 3;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.LISTAGEM;
    parser = new ListagemParser(doc);
  }

  public void deve_retornar_todos_os_links() {
    List<CriLink> res = parser.get();
    assertThat(res.size(), equalTo(142));

    List<String> cods = transform(res, new ToCodigo());
    assertThat(cods.get(i0), equalTo("AETA-C10"));
    assertThat(cods.get(i1), equalTo("AETA-C11"));
    assertThat(cods.get(in), equalTo("WTPI-C02"));

    List<String> hrefs = transform(res, new ToHref());
    assertThat(
        hrefs.get(i0),
        equals("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=AETA&CodEsp=C10&CodTit=3&NumEmi=1&NumSeri=10&Art1=N&Art2=N"));
    assertThat(
        hrefs.get(i1),
        equals("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=AETA&CodEsp=C11&CodTit=3&NumEmi=1&NumSeri=1&Art1=N&Art2=N"));
    assertThat(
        hrefs.get(in),
        equals("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=WTPI&CodEsp=C02&CodTit=3&NumEmi=2&NumSeri=1&Art1=N&Art2=N"));
  }

  private class ToCodigo implements Function<CriLink, String> {

    @Override
    public String apply(CriLink input) {
      return input.getCodigo();
    }

  }

  private class ToHref implements Function<CriLink, String> {

    @Override
    public String apply(CriLink input) {
      return input.getHref();
    }

  }

}
