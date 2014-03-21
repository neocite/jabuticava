/*
 * TesteDeNossoNumero.java criado em 21/03/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeNossoNumero {

  public void numero() {
    String numero = "1234";

    NossoNumero res = NossoNumero.parseString(numero);

    assertThat(res.longValue(), equalTo(123l));
    assertThat(res.getDigito(), equalTo('4'));
  }

  public void nao_numero_hifen() {
    String numero = "123-4";

    NossoNumero res = NossoNumero.parseString(numero);

    assertThat(res.longValue(), equalTo(123l));
    assertThat(res.getDigito(), equalTo('4'));
  }

  public void nao_numero_letra() {
    String numero = "40660000002P";

    NossoNumero res = NossoNumero.parseString(numero);

    assertThat(res.longValue(), equalTo(40660000002l));
    assertThat(res.getDigito(), equalTo('0'));
  }

  public void nao_numero() {
    String numero = "abc";

    NossoNumero res = NossoNumero.parseString(numero);

    assertThat(res.longValue(), equalTo(0l));
    assertThat(res.getDigito(), equalTo('\0'));
  }

  public void nao_numero_vazio() {
    String numero = "";

    NossoNumero res = NossoNumero.parseString(numero);

    assertThat(res.longValue(), equalTo(0l));
    assertThat(res.getDigito(), equalTo('\0'));
  }

}