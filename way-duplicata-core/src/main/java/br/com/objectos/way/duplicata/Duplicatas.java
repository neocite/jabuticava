/*
 * Duplicatas.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

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
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class Duplicatas {

  private Duplicatas() {
  }

  public static ConstrutorDeDuplicata novaDuplicata() {
    return new ConstrutorDeDuplicata();
  }

  static MustacheFactory resourcesMf() {
    try {
      URL url = Resources.getResource(Duplicatas.class, "/template");
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