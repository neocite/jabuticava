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
public class ConstrutorDeBdrFalso implements Bdr.Construtor {

  private String codigoDeNegocicao;
  private String codigoIsin;
  private BdrCategoria categoria;

  @Override
  public Bdr novaInstancia() {
    return new BdrPojo(this);
  }

  public ConstrutorDeBdrFalso codigoDeNegocicao(String codigoDeNegocicao) {
    this.codigoDeNegocicao = codigoDeNegocicao;
    return this;
  }

  public ConstrutorDeBdrFalso codigoDeIsin(String codigoDeIsin) {
    this.codigoIsin = codigoDeIsin;
    return this;
  }

  public ConstrutorDeBdrFalso categoria(BdrCategoria categoria) {
    this.categoria = categoria;
    return this;
  }

  @Override
  public String getCodigoDeNegocicao() {
    return codigoDeNegocicao;
  }

  @Override
  public String getCodigoIsin() {
    return codigoIsin;
  }

  @Override
  public BdrCategoria getCategoria() {
    return categoria;
  }

}