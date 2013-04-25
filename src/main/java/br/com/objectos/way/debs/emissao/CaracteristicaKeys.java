/*
 * CaracteristicaKeys.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.ColumnKey;
import br.com.objectos.way.io.LineKey;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
interface CaracteristicaKeys {

  ColumnKey<LocalDate> DATA_VENCIMENTO = ColumnKey.of(LocalDate.class, "dataVencimento");

  LineKey<String> codigo();

  LineKey<String> empresa();

  LineKey<String> serie();

  LineKey<Integer> emissao();

  LineKey<CaracteristicaSituacao> situacao();

  LineKey<String> codigoIsin();

  LineKey<LocalDate> dataEmissao();

  LineKey<LocalDate> dataVencimento();

  LineKey<Long> quantidadeEmitida();

  LineKey<Long> quantidadeMercado();

}