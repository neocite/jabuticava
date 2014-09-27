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
public class ConstrutorDeCriEmissaoFalso implements CriEmissao.Construtor {

  private int numero;
  private double volumeTotalEmissao;
  private int quantidadeCri;
  private int quantidadeSeriesEmitidas;

  @Override
  public CriEmissao novaInstancia() {
    return new CriEmissaoPojo(this);
  }

  public ConstrutorDeCriEmissaoFalso numero(int numero) {
    this.numero = numero;
    return this;
  }

  public ConstrutorDeCriEmissaoFalso volumeTotalEmissao(double volumeTotalEmissao) {
    this.volumeTotalEmissao = volumeTotalEmissao;
    return this;
  }

  public ConstrutorDeCriEmissaoFalso quantidadeCri(int quantidadeCri) {
    this.quantidadeCri = quantidadeCri;
    return this;
  }

  public ConstrutorDeCriEmissaoFalso quantidadeSeriesEmitidas(int quantidadeSeriesEmitidas) {
    this.quantidadeSeriesEmitidas = quantidadeSeriesEmitidas;
    return this;
  }

  @Override
  public int getNumero() {
    return numero;
  }

  @Override
  public double getVolumeTotalEmissao() {
    return volumeTotalEmissao;
  }

  @Override
  public int getQuantidadeCri() {
    return quantidadeCri;
  }

  @Override
  public int getQuantidadeSeriesEmitidas() {
    return quantidadeSeriesEmitidas;
  }

}