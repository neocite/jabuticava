/*
 * Parser.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import static br.com.objectos.way.debs.emissao.CaracteristicaKeys.DATA_VENCIMENTO;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.Encoding;
import br.com.objectos.comuns.io.Line;
import br.com.objectos.comuns.io.ParsedLines;
import br.com.objectos.comuns.io.csv.CsvFile;
import br.com.objectos.comuns.io.csv.LocalDateCsvConverter;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.RecordSpec;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CaracteristicaParser {

  private static final RecordSpec spec = new CaracteristicaSpec();

  private final CsvFile file;

  public CaracteristicaParser(CsvFile file) {
    this.file = file;
  }

  public Caracteristica get() {
    ParsedLines lines = file
        .onTabs()
        .encodedWith(Encoding.ISO_8859_1)
        .skipFirstLines(3)
        .withConverter(CaracteristicaSituacao.class, CaracteristicaSituacao.CONVERTER)
        .withConverter(LocalDate.class, new LocalDateCsvConverter("dd/MM/yyyy"))
        .withConverter(DATA_VENCIMENTO, new DataVencimento())
        .getLines();

    Iterable<Record> registros;
    registros = Iterables.transform(lines, new ToRecord());

    registros = Iterables.filter(registros, Predicates.notNull());

    return new Caracteristica(null, registros);
  }

  private static class ToRecord implements Function<Line, Record> {
    @Override
    public Record apply(Line line) {
      return spec.parse(line);
    }
  }

  private static class DataVencimento extends LocalDateCsvConverter {
    public DataVencimento() {
      super("dd/MM/yyyy");
    }

    @Override
    public LocalDate convert(String text) {
      LocalDate date = null;

      if (!"Indeterminado".equals(text)) {
        date = super.convert(text);
      }

      return date;
    }
  }

}