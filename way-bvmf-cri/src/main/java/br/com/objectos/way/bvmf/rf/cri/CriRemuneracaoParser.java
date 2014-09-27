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
class CriRemuneracaoParser implements CriRemuneracao.Construtor {

  private final CriMap map;

  public CriRemuneracaoParser(CriMap map) {
    this.map = map;
  }

  @Override
  public CriRemuneracao novaInstancia() {
    return new CriRemuneracaoPojo(this);
  }

  @Override
  public boolean isParticipacaoLucro() {
    return map.getBoolean("Participação no Lucro:");
  }

  @Override
  public String getTaxaJuros() {
    return map.getString("Taxa de Juros:");
  }

  @Override
  public String getPagamento() {
    return map.getString("Pagamento:");
  }

  @Override
  public double getPremio() {
    return map.getDouble("Prêmio:");
  }

}