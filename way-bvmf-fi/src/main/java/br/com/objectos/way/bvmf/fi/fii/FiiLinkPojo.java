/*
 * FundoLinkPojo.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiLinkPojo implements FiiLink {

  private final String codigo;
  private final String href;

  public FiiLinkPojo(Construtor construtor) {
    codigo = construtor.getCodigo();
    href = construtor.getHref();
  }

  @Override
  public String getCodigo() {
    return codigo;
  }

  @Override
  public String getHref() {
    return href;
  }

}