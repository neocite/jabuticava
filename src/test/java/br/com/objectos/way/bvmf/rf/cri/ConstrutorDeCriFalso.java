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
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeCriFalso implements Cri.Contrutor {

  private CriEmissor emissor = new ConstrutorDeCriEmissorFalso().novaInstancia();

  private CriEmissao emissao = new ConstrutorDeCriEmissaoFalso().novaInstancia();

  private CriSerie serie = new ConstrutorDeCriSerieFalso().novaInstancia();

  private CriRemuneracao remuneracao = new ConstrutorDeCriRemuneracaoFalso().novaInstancia();

  private CriInformacoes informacoes = new ConstrutorDeCriInformacoesFalso().novaInstancia();

  @Override
  public Cri novaInstancia() {
    return new CriPojo(this);
  }

  public ConstrutorDeCriFalso emissor(CriEmissor emissor) {
    this.emissor = emissor;
    return this;
  }

  public ConstrutorDeCriFalso emissao(CriEmissao emissao) {
    this.emissao = emissao;
    return this;
  }

  public ConstrutorDeCriFalso serie(CriSerie serie) {
    this.serie = serie;
    return this;
  }

  public ConstrutorDeCriFalso remuneracao(CriRemuneracao remuneracao) {
    this.remuneracao = remuneracao;
    return this;
  }

  public ConstrutorDeCriFalso informacoes(CriInformacoes informacoes) {
    this.informacoes = informacoes;
    return this;
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
    return informacoes;
  }

}