/*
 * ContaCentroCusto.java criado em 27/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;


import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ContaCentroCusto {

  private static final ContaCentroCusto VAZIO = new ContaCentroCusto("");

  private final String toString;

  private ContaCentroCusto(String toString) {
    this.toString = toString;
  }

  public static ContaCentroCusto parse(String text) {
    String val = Strings.nullToEmpty(text);
    return new ContaCentroCusto(val);
  }

  public static ContaCentroCusto of() {
    return VAZIO;
  }

  @Override
  public String toString() {
    return toString;
  }

  String toLancamentoTxt() {
    return WayCMatic.toTxtPart("%-42s", toString, 42);
  }

}