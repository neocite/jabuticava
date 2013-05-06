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

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ContextsGuice implements Contexts {

  private final Styles styles;

  @Inject
  public ContextsGuice(Styles styles) {
    this.styles = styles;
  }

  @Override
  public Object of(Boleto boleto) {
    return new Context(boleto);
  }

  @Override
  public Object inlineCssOf(Boleto boleto) {
    String css = styles.css();
    return new ContextCss(boleto, css);
  }

  @Override
  public Object pageOf(Boleto boleto) {
    String css = styles.css();
    return new ContextCss(boleto, css);
  }

  static class Context {

    private final Boleto boleto;

    private final String linhaDigitavel;

    public Context(Boleto boleto) {
      this.boleto = boleto;
      this.linhaDigitavel = "";
    }

    public MustacheContaBancaria getContaBancaria() {
      BoletoContaBancaria val = boleto.getContaBancaria();
      return new MustacheContaBancaria(val);
    }

    public MustacheCedente getCedente() {
      BoletoCedente val = boleto.getCedente();
      return new MustacheCedente(val);
    }

    public MustacheSacado getSacado() {
      BoletoSacado val = boleto.getSacado();
      return new MustacheSacado(val);
    }

    public MustacheTitulo getTitulo() {
      BoletoTitulo val = boleto.getTitulo();
      return new MustacheTitulo(val);
    }

    public MustacheCobranca getCobranca() {
      BoletoCobranca val = boleto.getCobranca();
      return new MustacheCobranca(val);
    }

    public MustacheCarteira getCarteira() {
      BoletoContaBancaria val = boleto.getContaBancaria();
      return new MustacheCarteira(val);
    }

    public String getLinhaDigitavel() {
      return linhaDigitavel;
    }

  }

  static class ContextCss extends Context {

    private final String css;

    public ContextCss(Boleto boleto, String css) {
      super(boleto);
      this.css = css;
    }

    public String getCss() {
      return css;
    }

  }

}