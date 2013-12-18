/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.debs;

import org.joda.time.LocalDate;

import br.com.objectos.way.io.LineKey;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public interface CaracteristicaKeys {

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