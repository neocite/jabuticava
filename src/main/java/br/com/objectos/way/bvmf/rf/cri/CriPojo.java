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

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
class CriPojo implements Cri {

  private final CriEmissor emissor;

  private final CriEmissao emissao;

  private final CriSerie serie;

  private final CriRemuneracao remuneracao;

  private final CriInformacoes informacoesRelacionadas;

  public CriPojo(Contrutor construtor) {
    this.emissor = construtor.getEmissor();
    this.emissao = construtor.getEmissao();
    this.serie = construtor.getSerie();
    this.remuneracao = construtor.getRemuneracao();
    this.informacoesRelacionadas = construtor.getInformacoes();
  }

  @Override
  public CriEmissor getEmissor() {
    return emissor;
  }

  @Override
  public CriEmissao getEmissao() {
    return emissao;
  }

  @Override
  public CriSerie getSerie() {
    return serie;
  }

  @Override
  public CriRemuneracao getRemuneracao() {
    return remuneracao;
  }

  @Override
  public CriInformacoes getInformacoes() {
    return informacoesRelacionadas;
  }

}