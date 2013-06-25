/*
 * InformacoesRelacionadas.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface InformacoesRelacionadas {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<InformacoesRelacionadas> {

    String getAdicionais();

    double getPuDiario();

    String getParametroSecuritizacao();
  }

  String getAdicionais();

  double getPuDiario();

  String getParametroSecuritizacao();

}