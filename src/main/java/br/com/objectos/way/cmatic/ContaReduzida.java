/*
 * ContaReduzida.java criado em 26/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import com.google.common.base.Objects;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ContaReduzida {

  private static final ContaReduzida VAZIA = new ContaReduzida(0);

  private final int intValue;

  private ContaReduzida(int intValue) {
    this.intValue = intValue;
  }

  public static ContaReduzida of() {
    return VAZIA;
  }

  public static ContaReduzida valueOf(int val) {
    return new ContaReduzida(val);
  }

  public boolean isZero() {
    return intValue == 0;
  }

  public int get() {
    return intValue;
  }

  public int intValue() {
    return intValue;
  }

  @Override
  public String toString() {
    String res = "";

    if (!isZero()) {
      res = String.format("%07d", intValue);
    }

    return res;
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(intValue);
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (obj instanceof ContaReduzida) {
      final ContaReduzida that = (ContaReduzida) obj;
      return this.intValue == that.intValue;
    } else {
      return false;
    }
  }

}