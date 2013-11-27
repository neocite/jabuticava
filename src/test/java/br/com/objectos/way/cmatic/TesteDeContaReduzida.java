/*
 * TesteDeContaReduzida.java criado em 26/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.testng.annotations.Test;

import br.com.objectos.way.cmatic.ContaReduzida;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeContaReduzida {

  public void equals_test() {
    EqualsVerifier
        .forClass(ContaReduzida.class)
        .verify();
  }

}