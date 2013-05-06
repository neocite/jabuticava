/*
 * MustacheFatura.java criado em 07/05/2013
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
class MustacheFatura {

  private final Fatura fatura;

  public MustacheFatura(Fatura fatura) {
    this.fatura = fatura;
  }

  public String getNumero() {
    return fatura.getNumero();
  }

  public ValorFinanceiro getValor() {
    return fatura.getValor();
  }

  public String getEmissao() {
    LocalDate emissao = fatura.getEmissao();
    return Duplicatas.toString(emissao);
  }

  public DuplicataTitulo getDuplicataTitulo() {
    return fatura.getDuplicataTitulo();
  }

}