/*
 * FaturaFalsa.java criado em 07/05/2013
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
public class FaturaFalsa implements Fatura {

  @Override
  public String getNumero() {
    return "122";
  }

  @Override
  public ValorFinanceiro getValor() {
    return new ValorFinanceiroImpl(1000.00);
  }

  @Override
  public LocalDate getEmissao() {
    return new LocalDate(2012, 2, 1);
  }

  @Override
  public DuplicataTitulo getDuplicataTitulo() {
    return new TituloFalso();
  }

}