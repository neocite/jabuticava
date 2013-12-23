/*
 * Styles.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.google.inject.ImplementedBy;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@ImplementedBy(StylesGuice.class)
public interface Styles {

  String css();

  String inline();

}