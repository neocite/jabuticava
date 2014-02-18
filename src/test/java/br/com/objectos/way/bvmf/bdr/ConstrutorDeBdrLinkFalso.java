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

import br.com.objectos.way.bvmf.bdr.BdrLink.Construtor;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ConstrutorDeBdrLinkFalso implements Construtor {

  private String href;
  private CategoriaTipo categoria;

  @Override
  public BdrLink novaInstancia() {
    return new BdrLinkPojo(this);
  }

  public ConstrutorDeBdrLinkFalso href(String href) {
    this.href = href;
    return this;
  }

  public ConstrutorDeBdrLinkFalso categoria(CategoriaTipo categoria) {
    this.categoria = categoria;
    return this;
  }

  @Override
  public String getHref() {
    return href;
  }

  @Override
  public CategoriaTipo getCategoria() {
    return categoria;
  }

}