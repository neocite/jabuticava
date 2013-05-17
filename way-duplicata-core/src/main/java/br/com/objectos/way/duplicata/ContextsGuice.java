/*
 * ContextsGuice.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ContextsGuice implements Contexts {

  private final Styles styles;

  @Inject
  public ContextsGuice(Styles styles) {
    this.styles = styles;
  }

  @Override
  public Object of(Duplicata duplicata) {
    return new Context(duplicata);
  }

  @Override
  public Object inlineCssOf(Duplicata duplicata) {
    String css = styles.css();
    return new ContextCss(duplicata, css);
  }

  @Override
  public Object pageOf(Duplicata duplicata) {
    String css = styles.css();
    return new ContextCss(duplicata, css);
  }

  static class Context {

    private final Duplicata duplicata;

    public Context(Duplicata duplicata) {
      this.duplicata = duplicata;
    }

    public MustacheCedente getCedente() {
      DuplicataCedente val = duplicata.getCedente();
      return new MustacheCedente(val);
    }

    public MustacheFatura getFatura() {
      Fatura val = duplicata.getFatura();
      return new MustacheFatura(val);
    }

    public MustacheTitulo getTitulo() {
      Fatura fatura = duplicata.getFatura();
      DuplicataTitulo val = fatura.getDuplicataTitulo();
      return new MustacheTitulo(val);
    }

    public MustacheSacado getSacado() {
      DuplicataSacado val = duplicata.getSacado();
      return new MustacheSacado(val);
    }

  }

  static class ContextCss extends Context {

    private final String css;

    public ContextCss(Duplicata duplicata, String css) {
      super(duplicata);
      this.css = css;
    }

    public String getCss() {
      return css;
    }

  }

}