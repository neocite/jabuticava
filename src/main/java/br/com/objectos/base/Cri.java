/*
 * Cri.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import br.com.objectos.comuns.base.Construtor;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface Cri {

  interface Contrutor extends Construtor<Cri> {

    Emissor getEmissor();

    CaracteristicaEmissao getCaracteristicaEmissao();

    CaracteristicaSerie getCaracteristicaSerie();

    Remuneracao getRemuneracao();

    InformacoesRelacionadas getInformacoesRelacionadas();
  }

  int getId();

  Emissor getEmissor();

  CaracteristicaEmissao getCaracteristicaEmissao();

  CaracteristicaSerie getCaracteristicaSerie();

  Remuneracao getRemuneracao();

  InformacoesRelacionadas getInformacoesRelacionadas();

}