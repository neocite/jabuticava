/*
 * Htmls.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class HtmlsFalso {

  public static final Document LISTAGEM = html("/fii/FundosListados.html");

  public static final Document DETALHES = html("/fii/FundosListadosDetalhe.html");

  private HtmlsFalso() {
  }

  private static Document html(String resourceName) {
    try {
      URL url = Resources.getResource(HtmlsFalso.class, resourceName);
      String html = Resources.toString(url, Charsets.UTF_8);
      return Jsoup.parse(html, "http://fake");
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

}