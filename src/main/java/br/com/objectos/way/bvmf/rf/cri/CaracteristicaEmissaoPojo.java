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
class CaracteristicaEmissaoPojo implements CaracteristicaEmissao {

  private final int numero;
  private final double volumeTotalEmissao;
  private final int quantidadeCri;
  private final int quantidadeSeriesEmitidas;

  public CaracteristicaEmissaoPojo(Construtor construtor) {
    numero = construtor.getNumero();
    volumeTotalEmissao = construtor.getVolumeTotalEmissao();
    quantidadeCri = construtor.getQuantidadeCri();
    quantidadeSeriesEmitidas = construtor.getQuantidadeSeriesEmitidas();
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