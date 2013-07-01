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
package br.com.objectos.way.bvmf.rf.cri;

import org.joda.time.LocalDate;

import com.google.common.base.Optional;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface CaracteristicaSerie {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<CaracteristicaSerie> {

    String getCodigoTitulo();

    String getCodigoIsin();

    int getQuantidadeCri();

    int getNumeroSerie();

    LocalDate getDataEmissao();

    LocalDate getDataVencimento();

    double getVolumeSerie();

    String getAtualizacaoMonetaria();

    String getGarantia();

    Optional<LocalDate> getProximaRepactuacao();

    Optional<LocalDate> getUltimaRepactuacao();

    String getAmortizacao();

    String getAgenteFiduciario();

    boolean isEnquadraArtUm();

    boolean isEnquadraArtDois();
  }

  String getCodigoTitulo();

  String getCodigoIsin();

  int getQuantidadeCri();

  int getNumeroSerie();

  LocalDate getDataEmissao();

  LocalDate getDataVencimento();

  double getVolumeSerie();

  String getAtualizacaoMonetaria();

  String getGarantia();

  Optional<LocalDate> getProximaRepactuacao();

  Optional<LocalDate> getUltimaRepactuacao();

  String getAmortizacao();

  String getAgenteFiduciario();

  boolean isEnquadraArtUm();

  boolean isEnquadraArtDois();

}