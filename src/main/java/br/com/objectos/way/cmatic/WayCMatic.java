/*
 * CMatic.java criado em 27/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import java.util.Locale;

import br.com.objectos.way.cmatic.PlanoDeContas.ConstrutorDePlanoDeContas;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WayCMatic {

  private static final Locale EN = new Locale("en");

  private WayCMatic() {
  }

  public static ConstrutorDePlanoDeContas planoDeContas() {
    return new ConstrutorDePlanoDeContas();
  }

  static String toTxtPart(String format, Object val, int limit) {
    return String.format(EN, format, val).substring(0, limit);
  }

}