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
package br.com.objectos.way.cnab;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MotivoItauBaixaSimples extends MotivoPadrao {

  public static final Motivo INSTANCE = new MotivoItauBaixaSimples();

  private MotivoItauBaixaSimples() {
    super("", "");
  }

  @Override
  public boolean isVazio() {
    return true;
  }

  @Override
  public double recebidoDe(Lote lote) {
    return 0;
  }

}