/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.cnab.remessa;

import br.com.objectos.way.base.br.CadastroRFB;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class EmpresaCnab implements Empresa {

  private final long codigo;

  private final CadastroRFB cadastroRFB;

  private final String razaoSocial;

  public EmpresaCnab(Construtor construtor) {
    this.codigo = construtor.getCodigo();
    this.cadastroRFB = construtor.getCadastroRFB();
    this.razaoSocial = construtor.getRazaoSocial();
  }

  @Override
  public long getCodigo() {
    return codigo;
  }

  @Override
  public CadastroRFB getCadastroRFB() {
    return cadastroRFB;
  }

  @Override
  public String getRazaoSocial() {
    return razaoSocial;
  }

}