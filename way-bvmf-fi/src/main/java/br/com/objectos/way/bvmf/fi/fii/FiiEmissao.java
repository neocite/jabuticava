/*
 * FiiEmissao.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public interface FiiEmissao {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<FiiEmissao> {

    LocalDate getData();

    long getQuantidade();

  }

  LocalDate getData();

  long getQuantidade();

}