/*
 * DetalhesFiiParser.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import static org.joda.time.format.DateTimeFormat.forPattern;

import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiEmissaoParser {

  private final Document doc;

  public FiiEmissaoParser(Document doc) {
    this.doc = doc;
  }

  public FiiEmissao get() {
    return new Construtor().novaInstancia();
  }

  private class Construtor implements FiiEmissao.Construtor {

    private final Element div;

    public Construtor() {
      this.div = doc.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_divCotas");
    }

    @Override
    public FiiEmissao novaInstancia() {
      return new FiiEmissaoPojo(this);
    }

    @Override
    public LocalDate getData() {
      Element span;
      span = div.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_lblDataCota");

      String data = span.text();
      return forPattern("dd/MM/yyyy").parseLocalDate(data);
    }

    @Override
    public long getQuantidade() {
      Element span;
      span = div.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_lblValorCota");

      String qtd = span.text();
      qtd = qtd.replaceAll("\\.", "");
      return Long.parseLong(qtd);
    }

  }

}