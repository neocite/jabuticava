/*
 * DuplicataTipo.java criado em 20/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum DuplicataTipo {

  MERCANTIL("Venda Mercantil"),

  SERVICO("Prestação de Serviços"),

  OU("Venda Mercantil ou Prestação de Serviços");

  private final String descricao;

  private DuplicataTipo(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}