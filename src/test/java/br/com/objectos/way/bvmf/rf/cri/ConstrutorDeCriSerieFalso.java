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
public class ConstrutorDeCriSerieFalso implements CriSerie.Construtor {

  private String codigoTitulo;
  private String codigoIsin;
  private int quantidadeCri;
  private int numeroSerie;
  private LocalDate dataEmissao;
  private LocalDate dataVencimento;
  private double volumeSerie;
  private String atualizacaoMonetaria;
  private String garantia;
  private Optional<LocalDate> proximaRepactuacao;
  private Optional<LocalDate> ultimaRepactuacao;
  private String amortizacao;
  private String agenteFiduciario;
  private boolean enquadraArtUm;
  private boolean enquadraArtDois;

  @Override
  public CriSerie novaInstancia() {
    return new CriSeriePojo(this);
  }

  public ConstrutorDeCriSerieFalso codigoTitulo(String codigoTitulo) {
    this.codigoTitulo = codigoTitulo;
    return this;
  }

  public ConstrutorDeCriSerieFalso codigoIsin(String codigoIsin) {
    this.codigoIsin = codigoIsin;
    return this;
  }

  public ConstrutorDeCriSerieFalso quantidadeCri(int quantidadeCri) {
    this.quantidadeCri = quantidadeCri;
    return this;
  }

  public ConstrutorDeCriSerieFalso numeroSerie(int numeroSerie) {
    this.numeroSerie = numeroSerie;
    return this;
  }

  public ConstrutorDeCriSerieFalso dataEmissao(LocalDate dataEmissao) {
    this.dataEmissao = dataEmissao;
    return this;
  }

  public ConstrutorDeCriSerieFalso dataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
    return this;
  }

  public ConstrutorDeCriSerieFalso volumeSerie(double volumeSerie) {
    this.volumeSerie = volumeSerie;
    return this;
  }

  public ConstrutorDeCriSerieFalso atualizacaoMonetaria(String atualizacaoMonetaria) {
    this.atualizacaoMonetaria = atualizacaoMonetaria;
    return this;
  }

  public ConstrutorDeCriSerieFalso garantia(String garantia) {
    this.garantia = garantia;
    return this;
  }

  public ConstrutorDeCriSerieFalso proximaRepactuacao(Optional<LocalDate> proximaRepactuacao) {
    this.proximaRepactuacao = proximaRepactuacao;
    return this;
  }

  public ConstrutorDeCriSerieFalso ultimaRepactuacao(Optional<LocalDate> ultimaRepactuacao) {
    this.ultimaRepactuacao = ultimaRepactuacao;
    return this;
  }

  public ConstrutorDeCriSerieFalso amortizacao(String amortizacao) {
    this.amortizacao = amortizacao;
    return this;
  }

  public ConstrutorDeCriSerieFalso agenteFiduciario(String agenteFiduciario) {
    this.agenteFiduciario = agenteFiduciario;
    return this;
  }

  public ConstrutorDeCriSerieFalso enquadraArtUm(boolean enquadraArtUm) {
    this.enquadraArtUm = enquadraArtUm;
    return this;
  }

  public ConstrutorDeCriSerieFalso enquadraArtDois(boolean enquadraArtDois) {
    this.enquadraArtDois = enquadraArtDois;
    return this;
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