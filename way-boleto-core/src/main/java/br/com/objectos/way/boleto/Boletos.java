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
import java.net.URISyntaxException;
import java.net.URL;
import java.text.NumberFormat;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.text.DecimalFormats;
import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
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
      URL url = Resources.getResource(Boletos.class, "/template");
      File dir = new File(url.toURI());
      return new DefaultMustacheFactory(dir);
    } catch (URISyntaxException e) {
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

}