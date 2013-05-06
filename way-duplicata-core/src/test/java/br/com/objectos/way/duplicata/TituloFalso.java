/*
 * DuplicataTituloFalso.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class TituloFalso implements DuplicataTitulo {

  @Override
  public String getNumero() {
    return "123 A";
  }

  @Override
  public ValorFinanceiro getValor() {
    return new ValorFinanceiroImpl(500.00);
  }

  @Override
  public LocalDate getVencimento() {
    return new LocalDate(2013, 2, 4);
  }

}