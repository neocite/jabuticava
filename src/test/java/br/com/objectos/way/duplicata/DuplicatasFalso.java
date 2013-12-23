/*
 * DuplicatasFalso.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.IOException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.base.Throwables;
import com.google.common.io.Resources;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class DuplicatasFalso {

  private DuplicatasFalso() {
  }

  public static String toString(String resourceName) {
    try {
      URL url = Resources.getResource(DuplicatasFalso.class, resourceName);
      return Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      throw Throwables.propagate(e);
    }
  }

}