/*
 * Emissor.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface Emissor {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Emissor> {

    int getEmissor();

    String getStatusDaEmissao();

    String getLocalNegociacao();

    String getNome();

  }

  int getEmissor();

  String getStatusDaEmissao();

  String getLocalNegociacao();

  String getNome();

}