/*
 * FundosListadosParser.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import static com.google.common.collect.Lists.transform;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ListagemParser {

  private final Document doc;

  public ListagemParser(Document doc) {
    this.doc = doc;
  }

  public List<FiiLink> get() {
    Elements anchors = doc.select("#ctl00_contentPlaceHolderConteudo_divResultado a");

    List<FiiLink> links = transform(anchors, new ToFundoLink());

    return ImmutableList.copyOf(links);
  }

  private class ToFundoLink implements Function<Element, FiiLink> {
    @Override
    public FiiLink apply(Element input) {
      return new Construtor(input).novaInstancia();
    }
  }

  private class Construtor implements FiiLink.Construtor {

    private final Element a;

    public Construtor(Element a) {
      this.a = a;
    }

    @Override
    public FiiLink novaInstancia() {
      return new FiiLinkPojo(this);
    }

    @Override
    public String getCodigo() {
      return a.text();
    }

    @Override
    public String getHref() {
      return a.attr("abs:href");
    }

  }

}