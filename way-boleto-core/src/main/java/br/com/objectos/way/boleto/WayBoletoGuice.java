/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.boleto;

import java.io.File;
import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class WayBoletoGuice implements WayBoleto {

  private final BoletoRender render;

  @Inject
  public WayBoletoGuice(BoletoRender render) {
    this.render = render;
  }

  @Override
  public HtmlOf htmlOf(Boleto boleto) {
    return new HtmlOfPojo(boleto);
  }

  private class HtmlOfPojo implements HtmlOf {

    private final Boleto boleto;

    private Modo modo = Modo.HTML;

    public HtmlOfPojo(Boleto boleto) {
      this.boleto = boleto;
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
      return modo.toString(render, boleto);
    }

  }

}