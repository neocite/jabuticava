/*
 * MustacheTitulo.java criado em 07/05/2013
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
class ContextTitulo {

  private final DuplicataTitulo titulo;

  public ContextTitulo(DuplicataTitulo titulo) {
    this.titulo = titulo;
  }

  public String getNumero() {
    return titulo.getNumero();
  }

  public ContextValorFinanceiro getValor() {
    ValorFinanceiro valor = titulo.getValor();
    return new ContextValorFinanceiro(valor);
  }

  public String getVencimento() {
    LocalDate vencimento = titulo.getVencimento();
    return Duplicatas.toString(vencimento);
  }

}