/*
 * TesteDeLancamentoContmaticGen.java criado em 09/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeLancamentoMM {

  public void multiplo_a_multiplo() {
    int numero = 243;
    LocalDate dt = new LocalDate(2013, 2, 24);

    SubLancamento sub01 = novoDeb(dt, 143, 6.24, "DESP SUST CART TIT 7671 1/1");
    SubLancamento sub02 = novoDeb(dt, 4, 27541.67, "CRED LIQ COBR ITAU");
    SubLancamento sub03 = novoCrd(dt, 3, 6.24, "DESP SUST CART DIVERSOS");
    SubLancamento sub04 = novoCrd(dt, 24, 3253.20, "LIQ P/ SAC TIT 007461A");
    SubLancamento sub05 = novoCrd(dt, 24, 24288.47, "LIQ P/ SAC TIT 007341C");

    LancamentoMM res = LancamentoMM.multiploMultiplo(numero, dt)
        .add(sub01)
        .add(sub02)
        .add(sub03)
        .add(sub04)
        .add(sub05)
        .novaInstancia();
    List<String> txt = res.toLines();
    List<String> prova = Txts.toLines("/txt/mm01.txt");

    assertThat(txt, equalTo(prova));
  }

  private SubLancamento novoCrd(LocalDate dt, int cc, double val, String hp) {
    return subLancamento(DebitoCredito.CREDITO, dt, cc, hp, val);
  }

  private SubLancamento novoDeb(LocalDate dt, int cc, double val, String hp) {
    return subLancamento(DebitoCredito.DEBITO, dt, cc, hp, val);
  }

  private SubLancamento subLancamento(
      DebitoCredito tipo, LocalDate dt, int cc, String hp, double val) {
    return new ConstrutorDeSubLancamentoFalso()
        .tipo(tipo)
        .conta(cc)
        .data(dt)
        .historicoPadrao(HistoricoPadrao.hpOf(hp))
        .valor(val)
        .novaInstancia();
  }

}