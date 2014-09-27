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

import java.util.List;

import org.testng.annotations.Test;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDePlanoDeContas {

  public void write() {
    ContaContabil cc0 = cc("1.1.1.03.00000", "BANCOS C/ APLICACOES", 0);
    ContaContabil cc1 = cc("1.1.1.03.00001", "Banco Bradesco S/A", 5);
    ContaContabil cc2 = cc("1.1.1.03.00002", "Banco Itau S/A", 6);

    PlanoDeContas pl = WayCMatic.planoDeContas()
        .add(cc0)
        .add(cc1)
        .add(cc2)
        .novaInstancia();
    String txt = pl.toTxt();
    List<String> res = Txts.split(txt);
    List<String> prova = Txts.toLines("/txt/plcontas.txt");

    assertThat(res, equalTo(prova));
  }

  private ContaContabil cc(String analitica, String descricao, int reduzida) {
    return new ConstrutorDeContaContabilFalso()
        .analitica(analitica)
        .descricao(descricao)
        .reduzida(reduzida)
        .novaInstancia();
  }

}