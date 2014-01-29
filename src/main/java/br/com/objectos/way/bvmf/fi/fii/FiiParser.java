/*
 * DetalhesParser.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.objectos.way.base.br.Cnpj;
import br.com.objectos.way.base.br.ExcecaoDeCnpjInvalido;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiParser {

  private final Document doc;

  public FiiParser(Document doc) {
    this.doc = doc;
  }

  public Fii get() {
    return new Construtor().novaInstancia();
  }

  private class Construtor implements Fii.Construtor {

    private final Element div;

    public Construtor() {
      this.div = doc.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_divDados");
    }

    @Override
    public Fii novaInstancia() {
      return new FiiPojo(this);
    }

    @Override
    public String getCodigo() {
      String res = "";

      Elements anchors = div.select("span.Dado a");
      if (anchors.size() > 0) {
        Element a = anchors.get(0);
        res = a.text();
      }

      return res.trim();
    }

    @Override
    public String getNome() {
      Element span;
      span = div.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_lblNomeFundo");

      return span.text();
    }

    @Override
    public Cnpj getCnpj() {
      try {
        Element span;
        span = div.getElementById("ctl00_contentPlaceHolderConteudo_ucFundoDetalhes_lblCNPJ");

        String cnpj = span.text();
        return Cnpj.valueOf(cnpj);
      } catch (ExcecaoDeCnpjInvalido e) {
        return null;
      }
    }

    @Override
    public FiiEmissao getEmissao() {
      return new FiiEmissaoParser(doc).get();
    }

  }

}