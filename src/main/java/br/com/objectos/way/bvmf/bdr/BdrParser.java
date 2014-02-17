/*
 * BdrParser.java criado em 17/02/2014
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.bdr;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Preconditions;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BdrParser {

  private final Document doc;

  public BdrParser(Document doc) {
    this.doc = doc;
  }

  public Bdr get() {
    return new Construtor().novaInstancia();
  }

  private class Construtor implements Bdr.Construtor {

    private final Element div;

    public Construtor() {
      this.div = doc.getElementById("colunaCentral");
    }

    @Override
    public Bdr novaInstancia() {
      return new BdrPojo(this);
    }

    @Override
    public String getCodigoDeNegocicao() {
      return parse(".tabelaSemBorda td", 5);
    }

    @Override
    public String getCodigoDeIsin() {
      return parse("#divCodigosOculto td", 3);
    }

    private String parse(String find, int indice) {
      Elements anchors = div.select(find);
      Preconditions.checkArgument(anchors.size() > indice);

      String res = "";
      if (anchors.size() > 0) {
        Element a = anchors.get(indice);
        res = a.text();
      }

      return res.trim();
    }

  }

}