/*
 * ConstrutorDeLancamentoContmaticFalso.java criado em 18/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.Construtor;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ConstrutorDeLancamentoSimplesFalso
    implements LancamentoSimples.Construtor, Construtor<LancamentoSimples> {

  private int numero;
  private LocalDate data;
  private int debito;
  private int credito;
  private double valor;
  private HistoricoPadrao historicoPadrao;
  private String ccdb;
  private String ccdr;

  @Override
  public LancamentoSimples novaInstancia() {
    return LancamentoSimples.of(this);
  }

  public ConstrutorDeLancamentoSimplesFalso codigo(int numero) {
    this.numero = numero;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso data(LocalDate data) {
    this.data = data;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso debito(int debito) {
    this.debito = debito;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso credito(int credito) {
    this.credito = credito;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso valor(double valor) {
    this.valor = valor;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso historicoPadrao(int codigo, String complemento) {
    this.historicoPadrao = new ConstrutorDeHistoricoPadraoFalso()
        .codigo(codigo)
        .complemento(complemento)
        .novaInstancia();
    return this;
  }
  public ConstrutorDeLancamentoSimplesFalso historicoPadrao(String complemento) {
    return historicoPadrao(0, complemento);
  }

  public ConstrutorDeLancamentoSimplesFalso ccdb(String ccdb) {
    this.ccdb = ccdb;
    return this;
  }

  public ConstrutorDeLancamentoSimplesFalso ccdr(String ccdr) {
    this.ccdr = ccdr;
    return this;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public ContaReduzida getDebito() {
    return ContaReduzida.valueOf(debito);
  }

  @Override
  public ContaReduzida getCredito() {
    return ContaReduzida.valueOf(credito);
  }

  @Override
  public double getValor() {
    return valor;
  }

  @Override
  public HistoricoPadrao getHistoricoPadrao() {
    return historicoPadrao;
  }

  @Override
  public ContaCentroCusto getCcdb() {
    return ContaCentroCusto.parse(ccdb);
  }

  @Override
  public ContaCentroCusto getCcdr() {
    return ContaCentroCusto.parse(ccdr);
  }

}