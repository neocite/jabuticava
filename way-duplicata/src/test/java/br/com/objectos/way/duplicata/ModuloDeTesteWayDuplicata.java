/*
 * ModuloDeTesteWayDuplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.google.inject.AbstractModule;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ModuloDeTesteWayDuplicata extends AbstractModule {

  @Override
  protected void configure() {
    bind(WayDuplicataConfig.class).to(WayDuplicataConfigTest.class);
  }

}