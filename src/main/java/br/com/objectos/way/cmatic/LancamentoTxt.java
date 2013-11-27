/*
 * LancamentoContmaticTxt.java criado em 21/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
abstract class LancamentoTxt {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<LancamentoTxt> {

    String getNome();

    LocalDate getData();

    String getConteudo();

  }

  public abstract String getNome();

  public abstract LocalDate getData();

  public abstract String getConteudo();

  @Override
  public String toString() {
    return getConteudo();
  }

}