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
public class ConstrutorDeCriEmissorFalso implements CriEmissor.Construtor {

  private String status;
  private String localNegociacao;

  @Override
  public CriEmissor novaInstancia() {
    return new CriEmissorPojo(this);
  }

  public ConstrutorDeCriEmissorFalso status(String status) {
    this.status = status;
    return this;
  }

  public ConstrutorDeCriEmissorFalso localNegociacao(String localNegociacao) {
    this.localNegociacao = localNegociacao;
    return this;
  }

  @Override
  public String getStatus() {
    return status;
  }

  @Override
  public String getLocalNegociacao() {
    return localNegociacao;
  }

}