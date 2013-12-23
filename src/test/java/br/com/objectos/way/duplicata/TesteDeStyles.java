/*
 * Snippet.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
@Guice(modules = { ModuloDeTesteWayDuplicata.class })
public class TesteDeStyles {

  @Inject
  private Styles styles;

  public void inline() {
    String res = styles.inline();

    assertThat(res, startsWith("<style type=\"text/css\">"));
  }

}