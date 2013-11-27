/*
 * TesteDeContaContabilAnalitica.java criado em 07/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.testng.annotations.Test;

import br.com.objectos.way.cmatic.ContaAnalitica;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeContaAnalitica {

  public void equals_test() {
    EqualsVerifier
        .forClass(ContaAnalitica.class)
        .verify();
  }

  public void whatever() {
    ContaAnalitica res = ContaAnalitica.parse("abc");
    assertThat(res, hasToString(equalTo("")));
  }

  public void deve_retornar_cc_analitica_cc_nenhum() {
    ContaAnalitica res = ContaAnalitica.parse("3112000002");
    assertThat(res, hasToString(equalTo("3.1.1.20.00002")));
  }

  public void deve_retornar_cc_analitica() {
    ContaAnalitica res = ContaAnalitica.parse("1120100800");
    assertThat(res, hasToString(equalTo("1.1.2.01.00800")));
  }

  public void parse_com_clean() {
    ContaAnalitica res = ContaAnalitica.parse("1.1.2.01.00800");
    assertThat(res, hasToString(equalTo("1.1.2.01.00800")));
  }

  public void legado_deve_continuar_igual() {
    ContaAnalitica res = ContaAnalitica.parse("1121");
    assertThat(res, hasToString(equalTo("1121")));
  }

}