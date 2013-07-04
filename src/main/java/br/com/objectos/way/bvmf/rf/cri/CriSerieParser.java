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
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
class CriSerieParser implements CriSerie.Construtor {

  private final CriMap map;

  public CriSerieParser(CriMap map) {
    this.map = map;
  }

  @Override
  public CriSerie novaInstancia() {
    return new CriSeriePojo(this);
  }

  @Override
  public String getCodigoTitulo() {
    return map.getString("Código do Título:");
  }

  @Override
  public String getCodigoIsin() {
    return map.getString("Código ISIN:");
  }

  @Override
  public int getQuantidadeCri() {
    return map.getInt("Quantidade de CRIs:");
  }

  @Override
  public int getNumeroSerie() {
    return map.getInt("Número da Série:");
  }

  @Override
  public LocalDate getDataEmissao() {
    return map.getLocalDate("Data de Emissão:");
  }

  @Override
  public LocalDate getDataVencimento() {
    return map.getLocalDate("Data de Vencimento:");
  }

  @Override
  public double getVolumeSerie() {
    return map.getDouble("Volume da Série (R$):");
  }

  @Override
  public String getAtualizacaoMonetaria() {
    return map.getString("Atualização Monetária:");
  }

  @Override
  public String getGarantia() {
    return map.getString("Garantia:");
  }

  @Override
  public Optional<LocalDate> getProximaRepactuacao() {
    LocalDate dt = map.getLocalDate("Próxima Repactuação:");
    return Optional.fromNullable(dt);
  }

  @Override
  public Optional<LocalDate> getUltimaRepactuacao() {
    LocalDate dt = map.getLocalDate("Última Repactuação:");
    return Optional.fromNullable(dt);
  }

  @Override
  public String getAmortizacao() {
    return map.getString("Amortização:");
  }

  @Override
  public String getAgenteFiduciario() {
    return map.getString("Agente Fiduciário:");
  }

  @Override
  public boolean isEnquadraArtUm() {
    return map.getBoolean("Enquadra na Lei 12.431 - Artigo 1º:");
  }

  @Override
  public boolean isEnquadraArtDois() {
    return map.getBoolean("Enquadra na Lei 12.431 - Artigo 2º:");
  }

}