/*
 * ConstrutorDeLancamentoContmatic.java criado em 27/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import br.com.objectos.comuns.base.Construtor;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
abstract class ConstrutorDeLancamentoSimples
    implements LancamentoSimples.Construtor, Construtor<LancamentoSimples> {

  @Override
  public final LancamentoSimples novaInstancia() {
    return LancamentoSimples.of(this);
  }

  @Override
  public ContaReduzida getDebito() {
    return ContaReduzida.of();
  }

  @Override
  public ContaReduzida getCredito() {
    return ContaReduzida.of();
  }

  @Override
  public HistoricoPadrao getHistoricoPadrao() {
    return HistoricoPadrao.of();
  }

  @Override
  public ContaCentroCusto getCcdb() {
    return ContaCentroCusto.of();
  }

  @Override
  public ContaCentroCusto getCcdr() {
    return ContaCentroCusto.of();
  }

}