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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.text.DecimalFormats;
import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Boletos {

  private Boletos() {
  }

  public static ConstrutorDeBoleto novoBoleto() {
    return new ConstrutorDeBoleto();
  }

  static MustacheFactory resourcesMf() {
    try {
      File tempDir = Files.createTempDir();
      return newMustacheFactoryAt(tempDir);
    } catch (IOException e) {
      return new DefaultMustacheFactory();
    }
  }

  static String toString(LocalDate data) {
    return data != null ? data.toString("dd/MM/yyyy") : null;
  }

  static String toString(ValorFinanceiro val) {
    String res = "";

    if (val != null) {
      double dbl = val.doubleValue();
      NumberFormat nf = DecimalFormats.newCurrencyWithLocale("pt");
      res = nf.format(dbl);
    }

    return res;
  }

  private static MustacheFactory newMustacheFactoryAt(File dir) throws IOException {
    copyMustache("boleto.mustache", dir);
    copyMustache("boleto-inline-css.mustache", dir);
    copyMustache("boleto-page.mustache", dir);

    return new DefaultMustacheFactory(dir);
  }

  private static File copyMustache(String from, File to) throws IOException {
    URL url = Resources.getResource(Styles.class, String.format("/template/%s", from));
    File dest = new File(to, from);
    FileOutputStream out = new FileOutputStream(dest);
    Resources.copy(url, out);
    return dest;
  }

}