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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

/**
 * @author ricardo.murad@objectos.com.br (Ricardo Murad)
 */
@Test
public class TesteDeBoletoBanco {

  public void deve_retornar_banco_correto() {
    int bancoBradesco = 237;
    int bancoItau = 341;

    BoletoBanco res2 = BoletoBanco.valueOf(bancoBradesco);
    BoletoBanco res3 = BoletoBanco.valueOf(bancoItau);

    assertThat(res2, equalTo(BoletoBanco.BRADESCO));
    assertThat(res3, equalTo(BoletoBanco.ITAU));
  }

}