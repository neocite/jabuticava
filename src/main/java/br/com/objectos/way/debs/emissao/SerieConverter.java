/*
 * SerieConverter.java criado em 18/12/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import br.com.objectos.comuns.io.csv.AbstractCsvConverter;

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class SerieConverter extends AbstractCsvConverter<String> {

  static final SerieConverter INSTANCE = new SerieConverter();

  private SerieConverter() {
  }

  @Override
  protected String convert(String text) {
    text = Strings.nullToEmpty(text);
    return br.com.objectos.comuns.base.Strings
        .accentsToAscii(text)
        .alphanum()
        .toString();
  }

}