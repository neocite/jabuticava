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
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeLancamentoMM extends TesteDeLancamentoAbstrato {

  public void multiplo_a_multiplo() {
    int numero = 243;
    LocalDate dt = new LocalDate(2013, 2, 24);

    SubLancamento sub01 = novoDeb(dt, 143, 6.24, "DESP SUST CART TIT 7671 1/1");
    SubLancamento sub02 = novoDeb(dt, 4, 27541.67, "CRED LIQ COBR ITAU");
    SubLancamento sub03 = novoCrd(dt, 3, 6.24, "DESP SUST CART DIVERSOS");
    SubLancamento sub04 = novoCrd(dt, 24, 3253.20, "LIQ P/ SAC TIT 007461A");
    SubLancamento sub05 = novoCrd(dt, 24, 24288.47, "LIQ P/ SAC TIT 007341C");

    LancamentoMM mm = WayCMatic.multiploMultiplo(numero, dt)
        .add(sub01)
        .add(sub02)
        .add(sub03)
        .add(sub04)
        .add(sub05)
        .novaInstancia();
    String txt = mm.toTxt();
    List<String> res = Txts.split(txt);
    List<String> prova = Txts.toLines("/txt/mm01.txt");

    assertThat(res, equalTo(prova));

    List<String> log = mm.toLog();
    assertThat(log.size(), equalTo(0));
  }

  public void log() {
    int numero = 243;
    LocalDate dt = new LocalDate(2013, 2, 24);

    SubLancamento sub01 = novoDeb(dt, 143, 6.24, "DESP SUST CART TIT 7671 1/1");
    SubLancamento sub03 = novoCrd(dt, 3, 6.24, "DESP SUST CART DIVERSOS");
    SubLancamento sub04 = novoCrd(dt, 24, 3253.20, "LIQ P/ SAC TIT 007461A");

    LancamentoMM mm = WayCMatic.multiploMultiplo(numero, dt)
        .add(sub01)
        .add(sub03)
        .add(sub04)
        .novaInstancia();

    List<String> res = mm.toLog();
    assertThat(res.size(), equalTo(1));

    String r0 = res.get(0);
    assertThat(r0, startsWith("[ERRO]"));
  }

}