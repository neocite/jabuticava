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
class CriEmissaoParser implements CriEmissao.Construtor {

  private final CriMap map;

  public CriEmissaoParser(CriMap map) {
    this.map = map;
  }

  @Override
  public CriEmissao novaInstancia() {
    return new CriEmissaoPojo(this);
  }

  @Override
  public int getNumero() {
    return map.getInt("Número da emissão:");
  }

  @Override
  public double getVolumeTotalEmissao() {
    return map.getDouble("Volume Total da Emissão (R$):");
  }

  @Override
  public int getQuantidadeCri() {
    return map.getInt("Quantidade de CRIs:");
  }

  @Override
  public int getQuantidadeSeriesEmitidas() {
    return map.getInt("Quantidade de Séries Emitidas:");
  }

}