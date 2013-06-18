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
package br.com.objectos.way.boleto;

import br.com.objectos.comuns.base.br.CadastroRFB;
import br.com.objectos.comuns.base.br.Cep;
import br.com.objectos.comuns.base.br.Estado;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MustacheSacado {

  private final String nome;
  private final CadastroRFB cadastroRFB;
  private final String endereco;
  private final String bairro;
  private final Cep cep;
  private final String cidade;
  private final Estado estado;

  public MustacheSacado(BoletoSacado sacado) {
    nome = sacado.getNome();
    cadastroRFB = sacado.getCadastroRFB();
    endereco = sacado.getEndereco();
    bairro = sacado.getBairro();
    cep = sacado.getCep();
    cidade = sacado.getCidade();
    estado = sacado.getEstado();
  }

  public String getNome() {
    return nome;
  }

  public CadastroRFB getCadastroRFB() {
    return cadastroRFB;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getBairro() {
    return bairro;
  }

  public Cep getCep() {
    return cep;
  }

  public String getCidade() {
    return cidade;
  }

  public Estado getEstado() {
    return estado;
  }

}