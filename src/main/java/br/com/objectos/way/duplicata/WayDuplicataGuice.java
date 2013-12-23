/*
 * WayDuplicataGuice.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class WayDuplicataGuice implements WayDuplicata {

  private final DuplicataRender render;

  @Inject
  public WayDuplicataGuice(DuplicataRender render) {
    this.render = render;
  }

  @Override
  public HtmlOf htmlOf(Duplicata duplicata) {
    return new HtmlOfPojo(duplicata);
  }

  private class HtmlOfPojo implements HtmlOf {

    private final Duplicata duplicata;

    private Modo modo = Modo.HTML;

    public HtmlOfPojo(Duplicata duplicata) {
      this.duplicata = duplicata;
    }

    @Override
    public HtmlOf inlineCss() {
      modo = Modo.HTML_INLINE_CSS;
      return this;
    }

    @Override
    public HtmlOf page() {
      modo = Modo.HTML_PAGE;
      return this;
    }

    @Override
    public File toFile(File saida) throws IOException {
      String html = toString();
      Files.write(html, saida, Charsets.UTF_8);
      return saida;
    }

    @Override
    public String toString() {
      return modo.toString(render, duplicata);
    }

  }

}