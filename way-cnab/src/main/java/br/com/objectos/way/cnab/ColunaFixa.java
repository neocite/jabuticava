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
package br.com.objectos.way.cnab;

import com.google.common.base.Preconditions;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ColunaFixa extends Coluna<String> {

  private final String value;

  public ColunaFixa(int inicio, int fim, Object value) {
    super(inicio, fim);
    this.value = value.toString();

    Preconditions.checkArgument(this.value.length() == getTamanho());
  }

  @Override
  public String get() {
    return value;
  }

  @Override
  public ColunaWriter<String> set(Object value) {
    return new ColunaFixa(inicio, fim, this.value);
  }

}