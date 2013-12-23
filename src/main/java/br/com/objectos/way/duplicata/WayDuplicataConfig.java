/*
 * WayDuplicataConfig.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.github.mustachejava.MustacheFactory;
import com.google.inject.ImplementedBy;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@ImplementedBy(WayDuplicataConfigProduction.class)
public interface WayDuplicataConfig {

  MustacheFactory getMustacheFactory();

}