/*
 * CaracteristicaEmissao.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface CaracteristicaEmissao {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<CaracteristicaEmissao> {

    int getNumero();

    Emissor getEmissor();

    double getVolumeTotalEmissao();

    int getQuantidadeCri();

    int getQuantidadeSeriesEmitidas();

  }

  int getNumero();

  Emissor getEmissor();

  double getVolumeTotalEmissao();

  int getQuantidadeCri();

  int getQuantidadeSeriesEmitidas();

}