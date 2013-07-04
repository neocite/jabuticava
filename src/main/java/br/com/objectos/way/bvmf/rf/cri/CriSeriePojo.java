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
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CriSeriePojo implements CriSerie {

  private final String codigoTitulo;
  private final String codigoIsin;
  private final int quantidadeCri;
  private final int numeroSerie;
  private final LocalDate dataEmissao;
  private final LocalDate dataVencimento;
  private final double volumeSerie;
  private final String atualizacaoMonetaria;
  private final String garantia;
  private final Optional<LocalDate> proximaRepactuacao;
  private final Optional<LocalDate> ultimaRepactuacao;
  private final String amortizacao;
  private final String agenteFiduciario;
  private final boolean enquadraArtUm;
  private final boolean enquadraArtDois;

  public CriSeriePojo(Construtor construtor) {
    codigoTitulo = construtor.getCodigoTitulo();
    codigoIsin = construtor.getCodigoIsin();
    quantidadeCri = construtor.getQuantidadeCri();
    numeroSerie = construtor.getNumeroSerie();
    dataEmissao = construtor.getDataEmissao();
    dataVencimento = construtor.getDataVencimento();
    volumeSerie = construtor.getVolumeSerie();
    atualizacaoMonetaria = construtor.getAtualizacaoMonetaria();
    garantia = construtor.getGarantia();
    proximaRepactuacao = construtor.getProximaRepactuacao();
    ultimaRepactuacao = construtor.getUltimaRepactuacao();
    amortizacao = construtor.getAmortizacao();
    agenteFiduciario = construtor.getAgenteFiduciario();
    enquadraArtUm = construtor.isEnquadraArtUm();
    enquadraArtDois = construtor.isEnquadraArtDois();
  }

  @Override
  public String getCodigoTitulo() {
    return codigoTitulo;
  }

  @Override
  public String getCodigoIsin() {
    return codigoIsin;
  }

  @Override
  public int getQuantidadeCri() {
    return quantidadeCri;
  }

  @Override
  public int getNumeroSerie() {
    return numeroSerie;
  }

  @Override
  public LocalDate getDataEmissao() {
    return dataEmissao;
  }

  @Override
  public LocalDate getDataVencimento() {
    return dataVencimento;
  }

  @Override
  public double getVolumeSerie() {
    return volumeSerie;
  }

  @Override
  public String getAtualizacaoMonetaria() {
    return atualizacaoMonetaria;
  }

  @Override
  public String getGarantia() {
    return garantia;
  }

  @Override
  public Optional<LocalDate> getProximaRepactuacao() {
    return proximaRepactuacao;
  }

  @Override
  public Optional<LocalDate> getUltimaRepactuacao() {
    return ultimaRepactuacao;
  }

  @Override
  public String getAmortizacao() {
    return amortizacao;
  }

  @Override
  public String getAgenteFiduciario() {
    return agenteFiduciario;
  }

  @Override
  public boolean isEnquadraArtUm() {
    return enquadraArtUm;
  }

  @Override
  public boolean isEnquadraArtDois() {
    return enquadraArtDois;
  }

}