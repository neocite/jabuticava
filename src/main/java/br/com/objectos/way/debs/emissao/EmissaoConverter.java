/*
 * EmissaoConverter.java criado em 18/12/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import br.com.objectos.comuns.io.csv.AbstractCsvConverter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class EmissaoConverter extends AbstractCsvConverter<Integer> {

  static final EmissaoConverter INSTANCE = new EmissaoConverter();

  private EmissaoConverter() {
  }

  @Override
  protected Integer convert(String text) {
    text = SerieConverter.INSTANCE.convert(text);
    return Integer.valueOf(text);
  }

}