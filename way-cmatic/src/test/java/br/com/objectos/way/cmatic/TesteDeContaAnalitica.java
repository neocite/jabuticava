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
import static org.hamcrest.Matchers.hasToString;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeContaAnalitica {

  public void equals_test() {
    EqualsVerifier
        .forClass(ContaAnalitica.class)
        .verify();
  }

  public void whatever() {
    ContaAnalitica res = ContaAnalitica.parse("abc");
    assertThat(res, hasToString(equalTo("")));
  }

  public void deve_retornar_cc_analitica_cc_nenhum() {
    ContaAnalitica res = ContaAnalitica.parse("3112000002");
    assertThat(res, hasToString(equalTo("3.1.1.20.00002")));
  }

  public void deve_retornar_cc_analitica() {
    ContaAnalitica res = ContaAnalitica.parse("1120100800");
    assertThat(res, hasToString(equalTo("1.1.2.01.00800")));
  }

  public void parse_com_clean() {
    ContaAnalitica res = ContaAnalitica.parse("1.1.2.01.00800");
    assertThat(res, hasToString(equalTo("1.1.2.01.00800")));
  }

  public void legado_deve_continuar_igual() {
    ContaAnalitica res = ContaAnalitica.parse("1121");
    assertThat(res, hasToString(equalTo("1121")));
  }

}