/*
 * MustacheValor.java criado em 21/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;
import br.com.objectos.way.base.br.PorExtenso;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ContextValorFinanceiro {

  private static final PorExtenso REAIS = PorExtenso
      .novoDecimal()
      .comCasas(2)
      .unidades("real", "reais")
      .e("centavo", "centavos");

  private final ValorFinanceiro valor;

  public ContextValorFinanceiro(ValorFinanceiro valor) {
    this.valor = valor;
  }

  public String getText() {
    return valor.toString();
  }

  public String getExtenso() {
    double val = valor.doubleValue();
    return REAIS.toString(val);
  }

}