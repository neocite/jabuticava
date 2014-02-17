/*
 * BdrPojo.java criado em 17/02/2014
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.bdr;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BdrPojo implements Bdr {

  private final String codigoDeNegocicao;
  private final String codigoDeIsin;

  public BdrPojo(Construtor construtor) {
    codigoDeNegocicao = construtor.getCodigoDeNegocicao();
    codigoDeIsin = construtor.getCodigoDeIsin();
  }

  @Override
  public String getCodigoDeNegocicao() {
    return codigoDeNegocicao;
  }

  @Override
  public String getCodigoDeIsin() {
    return codigoDeIsin;
  }

}