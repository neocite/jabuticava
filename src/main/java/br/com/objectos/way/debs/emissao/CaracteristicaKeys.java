/*
 * CaracteristicaKeys.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import org.joda.time.LocalDate;

import br.com.objectos.way.io.LineKey;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
interface CaracteristicaKeys {

  LineKey<String> codigo();

  LineKey<String> empresa();

  LineKey<String> serie();

  LineKey<Integer> emissao();

  LineKey<CaracteristicaSituacao> situacao();

  LineKey<String> codigoIsin();

  LineKey<LocalDate> dataEmissao();

  LineKey<LocalDate> dataVencimento();

  LineKey<String> motivoSaida();

  LineKey<LocalDate> dataSaida();

  LineKey<Long> quantidadeEmitida();

  LineKey<Long> artigo14();
  LineKey<Long> artigo24();

  LineKey<Long> quantidadeMercado();

  LineKey<Long> quantidadeTesouraria();

  LineKey<Long> quantidadeResgatada();

  LineKey<Long> quantidadeCancelada();

  LineKey<Long> quantidadeConvertida();
  LineKey<Long> quantidadeConvertidaFora();

  LineKey<Long> quantidadePermutada();
  LineKey<Long> quantidadePermutadaFora();

  LineKey<Double> valorNominalEmissao();
  LineKey<Double> valorNominalAtual();

  LineKey<String> indice();

}