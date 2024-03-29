/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.cnab;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public interface ItauLote extends CnabLote {

  CnabKey<ItauLote, Integer> agencia();

  CnabKey<ItauLote, Integer> conta();

  CnabKey<ItauLote, Integer> dacConta();

  CnabKey<ItauLote, String> codigoDaCarteira();

  CnabKey<ItauLote, Integer> dacNossoNumero2();

  CnabKey<ItauLote, Integer> dacAgenciaCobradora();

  CnabKey<ItauLote, Integer> nossoNumero3();

  CnabKey<ItauLote, Integer> especie();

  CnabKey<ItauLote, String> boletoDDA();

  CnabKey<ItauLote, Integer> instrucaoCancelada();

  CnabKey<ItauLote, String> nomeDoSacado();

  CnabKey<ItauLote, String> erros();

  CnabKey<ItauLote, String> codigoDeLiquidacao();

}