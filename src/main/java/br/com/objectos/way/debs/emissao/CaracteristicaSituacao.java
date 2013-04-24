/*
 * CaracteristicaSituacao.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import br.com.objectos.comuns.io.csv.AbstractCsvConverter;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public enum CaracteristicaSituacao {

  REGISTRADO,

  EXCLUIDO;

  static final Converter CONVERTER = new Converter();

  static class Converter extends AbstractCsvConverter<CaracteristicaSituacao> {
    @Override
    protected CaracteristicaSituacao convert(String text) {
      CaracteristicaSituacao res = REGISTRADO;

      if ("Excluído".equals(text)) {
        res = EXCLUIDO;
      }

      return res;
    }
  }

}