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
package br.com.objectos.way.cmatic;

import static br.com.objectos.way.cmatic.WayCMatic.toTxtPart;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ContaContabil {

  public static interface CMatic {

    ContaAnalitica getAnalitica();

    String getDescricao();

    ContaReduzida getReduzida();

  }

  private final ContaAnalitica analitica;
  private final String descricao;
  private final ContaReduzida reduzida;

  private ContaContabil(CMatic cmatic) {
    analitica = cmatic.getAnalitica();
    descricao = cmatic.getDescricao();
    reduzida = cmatic.getReduzida();
  }

  public static ContaContabil of(CMatic cmatic) {
    return new ContaContabil(cmatic);
  }

  String toPlanoDeContasTxt() {
    return new StringBuilder()
        .append(toTxtPart("%-56s", analitica.toString(), 56))
        .append(toTxtPart("%-40s", descricao, 40))
        .append(toTxtPart("%-7s", reduzida, 7))
        .toString();
  }

}