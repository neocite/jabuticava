/*
 * HtmlsFalso.java criado em 25/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
class HtmlsFalso {

  public static final Document LISTAGEM = html("/cri/CriListagem.html");

  public static final Document DETALHES = html("/cri/CriDetalhes.html");

  private HtmlsFalso() {
  }

  private static Document html(String resourceName) {
    try {
      URL url = Resources.getResource(HtmlsFalso.class, resourceName);
      String html = Resources.toString(url, Charsets.UTF_8);
      return Jsoup.parse(html, "http://fake/rendafixa/cri");
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

}