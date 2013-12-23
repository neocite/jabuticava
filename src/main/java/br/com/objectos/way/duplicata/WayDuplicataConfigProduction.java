/*
 * WayDuplicataConfigGuice.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.github.mustachejava.MustacheFactory;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class WayDuplicataConfigProduction implements WayDuplicataConfig {

  private final MustacheFactory mustacheFactory;

  public WayDuplicataConfigProduction() {
    this.mustacheFactory = Duplicatas.resourcesMf();
  }

  @Override
  public MustacheFactory getMustacheFactory() {
    return mustacheFactory;
  }

}