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
class MustacheTitulo {

  private final DuplicataTitulo titulo;

  public MustacheTitulo(DuplicataTitulo titulo) {
    this.titulo = titulo;
  }

  public String getNumero() {
    return titulo.getNumero();
  }

  public ValorFinanceiro getValor() {
    return titulo.getValor();
  }

  public String getVencimento() {
    LocalDate vencimento = titulo.getVencimento();
    return Duplicatas.toString(vencimento);
  }

}