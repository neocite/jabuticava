/*
 * TesteDeLancamento.java criado em 27/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLancamento {

  public void to_txt() {
    LancamentoSimples trx = new ConstrutorDeLancamentoSimplesFalso()
        .codigo(1)
        .data(new LocalDate(2013, 1, 2))
        .debito(149)
        .credito(64)
        .valor(420d)
        .historicoPadrao("N/COMPRA CF REC 5285")
        .novaInstancia();

    String res = trx.toTxt();

    assertThat(res, equalTo(Txts.toString("/txt/trx01.txt")));
  }

}