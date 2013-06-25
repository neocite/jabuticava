/*
 * CriLinkPojo.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public class CriLinkPojo implements CriLink {

  private final String codigo;
  private final String href;

  public CriLinkPojo(Construtor construtor) {
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