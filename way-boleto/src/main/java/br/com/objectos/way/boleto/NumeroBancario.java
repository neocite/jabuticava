/*
 * NumeroBancario.java criado em 21/03/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.objectos.way.base.HasIntValue;
import br.com.objectos.way.base.HasLongValue;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class NumeroBancario implements HasIntValue, HasLongValue {

  private static final Pattern pattern = Pattern.compile("([0-9]+)(|\\-([0-9]))");

  private final long numero;

  private final char digito;

  private final int digitoValue;

  NumeroBancario(String numero) {
    Matcher matcher = pattern.matcher(numero);
    Preconditions.checkArgument(matcher.matches());

    String _numero = matcher.group(1);
    this.numero = Long.parseLong(_numero);

    String _digito = matcher.group(3);
    this.digito = Strings.isNullOrEmpty(_digito) ? 0 : _digito.charAt(0);

    this.digitoValue = Character.getNumericValue(digito);
  }

  @Override
  public int intValue() {
    return (int) numero;
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