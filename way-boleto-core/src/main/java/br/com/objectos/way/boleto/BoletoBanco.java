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
package br.com.objectos.way.boleto;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

/**
 * @author ricardo.murad@objectos.com.br (Ricardo Murad)
 */
public enum BoletoBanco {

  BRADESCO(237, 2) {

    @Override
    public String getNome() {
      return "Banco Bradesco SA";
    }

  },

  ITAU(341, 7) {

    @Override
    public String getNome() {
      return "Banco Itaú SA";
    }

  };

  private static final Map<Integer, BoletoBanco> codigoMap = newHashMap();

  static {
    for (BoletoBanco boletoBanco : BoletoBanco.values()) {
      int codigo = boletoBanco.getCodigo();
      codigoMap.put(codigo, boletoBanco);
    }
  }

  private final int codigo;
  private final int digito;

  private BoletoBanco(int codigo, int digito) {
    this.codigo = codigo;
    this.digito = digito;
  }

  public static BoletoBanco valueOf(int codigo) {
    BoletoBanco boletoBanco = BoletoBanco.BRADESCO;

    if (codigoMap.containsKey(codigo)) {
      boletoBanco = codigoMap.get(codigo);
    }

    return boletoBanco;
  }

  public int getCodigo() {
    return codigo;
  }

  public int getDigito() {
    return digito;
  }

  public abstract String getNome();

  public String getNumero() {
    return String.format("%d-%d", codigo, digito);
  }

}