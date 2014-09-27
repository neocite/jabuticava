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
class CriEmissorParser implements CriEmissor.Construtor {

  private final CriMap map;

  public CriEmissorParser(CriMap map) {
    this.map = map;
  }

  @Override
  public CriEmissor novaInstancia() {
    return new CriEmissorPojo(this);
  }

  @Override
  public String getStatus() {
    return map.getString("Status atual da emissão:");
  }

  @Override
  public String getLocalNegociacao() {
    return map.getString("Local de negociação:");
  }

}