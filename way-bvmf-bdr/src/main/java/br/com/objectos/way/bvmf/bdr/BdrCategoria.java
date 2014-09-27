/*
 * Copyright 2014 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.bvmf.bdr;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public enum BdrCategoria {

  DR1("BDR Nível 1"),
  DR2("BDR Nível 2"),
  DR3("BDR Nível 3"),
  DRN("BDR Não Patrocinado");

  private final String descricao;

  private BdrCategoria(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}