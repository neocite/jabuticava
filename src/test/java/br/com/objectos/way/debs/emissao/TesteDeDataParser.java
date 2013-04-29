/*
 * TesteDeDataParser.java criado em 29/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeDataParser {

  public void data() {
    File file = CaracteristicasFalso.CARACTERISTICAS_20130424;

    LocalDate res = new DataParser(file).get();

    assertThat(res, equalTo(new LocalDate(2013, 4, 24)));
  }

}