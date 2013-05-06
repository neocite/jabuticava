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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author "edenir.anschau@objectos.com.br (Edenir Norberto Anschau)"
 */
@Test
public class TesteDeFatorDeVencimento {

  FatorDeVencimento fatorDeVencimento = new FatorDeVencimento();

  public void fator_1000() {
    int prova = 1000;

    LocalDate dataVencimento = new LocalDate(2000, 7, 3);

    int res = fatorDeVencimento.fatorDeVencimentoDe(dataVencimento);

    assertThat(res, equalTo(prova));
  }

  public void fator_06052013() {
    int prova = 5690;

    LocalDate dataVencimento = new LocalDate(2013, 5, 6);

    int res = fatorDeVencimento.fatorDeVencimentoDe(dataVencimento);

    assertThat(res, equalTo(prova));
  }

}