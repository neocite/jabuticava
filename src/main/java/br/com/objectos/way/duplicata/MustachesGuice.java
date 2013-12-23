/*
 * MustachesGuice.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class MustachesGuice implements Mustaches {

  private final WayDuplicataConfig config;

  @Inject
  public MustachesGuice(WayDuplicataConfig config) {
    this.config = config;
  }

  @Override
  public Mustache getDuplicata() {
    MustacheFactory factory = config.getMustacheFactory();
    return factory.compile("duplicata.mustache");
  }

  @Override
  public Mustache getDuplicataPage() {
    MustacheFactory factory = config.getMustacheFactory();
    return factory.compile("duplicata-page.mustache");
  }

}