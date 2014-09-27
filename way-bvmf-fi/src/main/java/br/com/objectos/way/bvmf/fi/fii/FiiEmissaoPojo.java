/*
 * FiiEmissaoPojo.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiEmissaoPojo implements FiiEmissao {

  private final LocalDate data;

  private final long quantidade;

  public FiiEmissaoPojo(Construtor construtor) {
    data = construtor.getData();
    quantidade = construtor.getQuantidade();
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public long getQuantidade() {
    return quantidade;
  }

}