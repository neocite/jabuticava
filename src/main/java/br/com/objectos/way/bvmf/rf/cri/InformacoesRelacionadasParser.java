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
class InformacoesRelacionadasParser implements InformacoesRelacionadas.Construtor {

  private final CriMap map;

  public InformacoesRelacionadasParser(CriMap map) {
    this.map = map;
  }

  @Override
  public InformacoesRelacionadas novaInstancia() {
    return new InformacoesRelacionadasPojo(this);
  }

  @Override
  public String getAdicionais() {
    return map.getString("Adicionais:");
  }

  @Override
  public String getParametroSecuritizacao() {
    return map.getString("Download Termo de Securitização:");
  }

}