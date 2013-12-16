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

import static br.com.objectos.way.boleto.BoletoBanco.BRADESCO;
import static br.com.objectos.way.boleto.BoletoBanco.ITAU;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum BoletoCarteira {

  COBRANCA_SIMPLES_COM_REGISTRO(newMap()
      .put(BRADESCO, 9)
      .put(ITAU, 112)
      .build());

  private final Map<BoletoBanco, Integer> codigoMap;

  private static Builder<BoletoBanco, Integer> newMap() {
    return ImmutableMap.<BoletoBanco, Integer> builder();
  }

  private BoletoCarteira(Map<BoletoBanco, Integer> codigoMap) {
    this.codigoMap = codigoMap;
  }

  int getCodigo(BoletoBanco banco) {
    int codigo = 1;

    if (codigoMap.containsKey(banco)) {
      codigo = codigoMap.get(banco).intValue();
    }

    return codigo;
  }

}