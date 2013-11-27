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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeLancamento {

  public void to_txt() {
    LancamentoSimples trx = new ConstrutorDeLancamentoSimplesFalso()
        .codigo(1)
        .data(new LocalDate(2013, 1, 2))
        .debito(149)
        .credito(64)
        .valor(420d)
        .historicoPadrao("N/COMPRA CF REC 5285")
        .novaInstancia();

    String res = trx.toTxt();

    assertThat(res, equalTo(Txts.toString("/txt/trx01.txt")));
  }

}