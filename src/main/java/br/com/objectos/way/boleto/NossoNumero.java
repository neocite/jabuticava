/*
 * NossoNumero.java criado em 21/03/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import br.com.objectos.way.base.HasLongValue;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class NossoNumero implements HasLongValue {

  private final long numero;

  private final char digito;

  private final int digitoValue;

  private NossoNumero(long numero, char digito) {
    this.numero = numero;
    this.digito = digito;
    this.digitoValue = Character.getNumericValue(digito);
  }

  public static NossoNumero parseString(String text) {
    long numero = 0;
    char digito = 0;

    String source = text
        .replaceAll("[A-Z]$", "0")
        .replaceAll("[^0-9]", "");
    int length = source.length();
    if (length > 0) {
      String _numero = source.substring(0, length - 1);
      numero = Long.parseLong(_numero);

      if (length > 1) {
        digito = source.charAt(length - 1);
      }
    }

    return new NossoNumero(numero, digito);
  }

  @Override
  public long longValue() {
    return numero;
  }

  public char getDigito() {
    return digito;
  }

  public int getDigitoValue() {
    return digitoValue;
  }

}