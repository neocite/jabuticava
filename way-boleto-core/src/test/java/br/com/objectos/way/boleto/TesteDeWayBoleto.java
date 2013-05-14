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

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author ricardo.murad@objectos.com.br (Ricardo Murad)
 */
@Test
@Guice(modules = { ModuloDeTesteWayBoleto.class })
public class TesteDeWayBoleto {

  @Inject
  private WayBoleto way;

  private Boleto boleto;

  @BeforeClass
  public void prepararBoleto() {
    boleto = Boletos.novoBoleto()
        .contaBancaria(new ContaBancariaFalso())
        .cedente(new CedenteFalso())
        .sacado(new SacadoFalso())
        .titulo(new TituloFalso())
        .cobranca(new CobrancaFalso())
        .novaInstancia();
  }

  public void html_string() throws Exception {
    String contra = "/boleto.html";
    String prova = BoletosFalso.toString(contra);

    String res = way.htmlOf(boleto).toString();
    assertLines(res, prova);
  }

  public void html_file() throws IOException {
    String tmpDir = System.getProperty("java.io.tmpdir");
    File dir = new File(tmpDir);
    File file = new File(dir, "way-boleto.html");
    way.htmlOf(boleto).page().toFile(file);
  }

  private void assertLines(String _res, String _prova) throws IOException {
    List<String> lines = linesOf(_res);
    List<String> prova = linesOf(_prova);

    // assertThat(lines.size(), equalTo(prova.size()));

    List<String> invalids = newArrayList();

    for (int i = 0; i < prova.size(); i++) {
      String exp = prova.get(i);
      String res = null;
      if (i < lines.size()) {
        res = lines.get(i);
      }

      Line line = new Line(i, exp, res);
      if (!line.valid()) {
        invalids.add(line.toString());
      }
    }

    if (!invalids.isEmpty()) {
      String output = Joiner.on("\n").join(invalids);
      System.out.println(output);
      fail();
    }
  }

  private List<String> linesOf(String html) {
    Iterable<String> lines = Splitter.on(Line.sep).split(html);
    return ImmutableList.copyOf(lines);
  }

}