/*
 * TesteDePlanoDeContaTxtGen.java criado em 07/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;


/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDePlanoDeContas {

  public void write() {
    ContaContabil cc0 = cc("1.1.1.03.00000", "BANCOS C/ APLICACOES", 0);
    ContaContabil cc1 = cc("1.1.1.03.00001", "Banco Bradesco S/A", 5);
    ContaContabil cc2 = cc("1.1.1.03.00002", "Banco Itau S/A", 6);

    PlanoDeContas pl = WayCMatic.planoDeContas()
        .add(cc0)
        .add(cc1)
        .add(cc2)
        .novaInstancia();
    List<String> res = pl.toLines();
    List<String> prova = Txts.toLines("/txt/plcontas.txt");

    assertThat(res, equalTo(prova));
  }

  private ContaContabil cc(String analitica, String descricao, int reduzida) {
    return new ConstrutorDeContaContabilFalso()
        .analitica(analitica)
        .descricao(descricao)
        .reduzida(reduzida)
        .novaInstancia();
  }

}