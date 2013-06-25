/*
 * ListagemParser.java criado em 25/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public class ListagemParser {

  private final Document doc;

  public ListagemParser(Document doc) {
    this.doc = doc;
  }

  public List<CriLink> get() {
    Elements anchors = doc
        .select("#DivMiolo a");

    List<CriLink> links = Lists.transform(anchors, new ToCriLink());

    return ImmutableList.copyOf(links);

  }

  private class ToCriLink implements Function<Element, CriLink> {

    @Override
    public CriLink apply(Element input) {
      return new Construtor(input).novaInstancia();
    }

  }

  private class Construtor implements CriLink.Construtor {

    private final Element a;

    public Construtor(Element a) {
      this.a = a;
    }

    @Override
    public CriLink novaInstancia() {
      return new CriLinkPojo(this);
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