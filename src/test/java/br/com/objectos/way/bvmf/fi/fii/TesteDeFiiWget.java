/*
 * TesteDeFiiRobo.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.List;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
@Guice(modules = { ModuloDeTesteWayFii.class })
public class TesteDeFiiWget {

  @Inject
  private FiiWget wget;

  public void deve_receber_todos_os_fii() {
    List<Fii> res = wget.connect();

    assertThat(res.size(), greaterThan(106));
  }

}