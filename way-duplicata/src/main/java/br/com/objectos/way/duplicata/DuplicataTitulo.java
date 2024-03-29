/*
 * DuplicataTitulo.java criado em 07/05/2013
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
public interface DuplicataTitulo {

  String getNumero();

  ValorFinanceiro getValor();

  LocalDate getVencimento();

}