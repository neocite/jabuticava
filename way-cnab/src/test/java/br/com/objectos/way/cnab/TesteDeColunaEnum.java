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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import br.com.objectos.way.cnab.bradesco.TipoDeIncricaoDoSacado;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
@Test
public class TesteDeColunaEnum {

  private ColunaWriter<TipoDeIncricaoDoSacado> writer;

  public void deve_formatar_uma_constante() {
    int inicio = 0;
    int fim = 1;
    TipoDeIncricaoDoSacado valor = TipoDeIncricaoDoSacado.CNPJ;
    int tamanho = 2;

    writer = new ColunaEnum<TipoDeIncricaoDoSacado>
        (inicio, fim, TipoDeIncricaoDoSacado.class).set(valor);
    String res = writer.get();

    assertThat(res.length(), equalTo(tamanho));
    assertThat(res, equalTo(valor.getValor()));
  }

}