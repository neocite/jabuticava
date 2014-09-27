/*
 * ConstrutorDeFiiEmissaoFalso.java criado em 02/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeFiiEmissaoFalso implements FiiEmissao.Construtor {

  private LocalDate data;

  private long quantidade;

  @Override
  public FiiEmissao novaInstancia() {
    return new FiiEmissaoPojo(this);
  }

  public ConstrutorDeFiiEmissaoFalso data(LocalDate data) {
    this.data = data;
    return this;
  }

  public ConstrutorDeFiiEmissaoFalso quantidade(long quantidade) {
    this.quantidade = quantidade;
    return this;
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