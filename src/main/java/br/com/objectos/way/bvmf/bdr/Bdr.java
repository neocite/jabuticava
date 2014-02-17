/*
 * Bdr.java criado em 17/02/2014
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.bdr;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public interface Bdr {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Bdr> {

    String getCodigoDeNegocicao();

    String getCodigoDeIsin();

  }

  String getCodigoDeNegocicao();

  String getCodigoDeIsin();

}
