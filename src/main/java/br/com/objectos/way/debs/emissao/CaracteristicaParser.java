/*
 * Parser.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import static br.com.objectos.way.debs.emissao.CaracteristicaSpec.DATA_SAIDA;
import static br.com.objectos.way.debs.emissao.CaracteristicaSpec.DATA_VENCIMENTO;
import static br.com.objectos.way.debs.emissao.CaracteristicaSpec.EMISSAO;
import static br.com.objectos.way.debs.emissao.CaracteristicaSpec.SERIE;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.Encoding;
import br.com.objectos.comuns.io.Line;
import br.com.objectos.comuns.io.ParsedLines;
import br.com.objectos.comuns.io.csv.AbstractCsvConverter;
import br.com.objectos.comuns.io.csv.CsvFile;
import br.com.objectos.comuns.io.csv.LocalDateCsvConverter;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.RecordSpec;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CaracteristicaParser {

  private static final RecordSpec spec = new CaracteristicaSpec();

  private final LocalDate data;

  private final CsvFile file;

  public CaracteristicaParser(LocalDate data, CsvFile file) {
    this.data = data;
    this.file = file;
  }

  public Caracteristica get() {
    ParsedLines lines = file
        .onTabs()
        .notEscaped()
        .notQuoted()
        .encodedWith(Encoding.ISO_8859_1)
        .skipFirstLines(3)
        .withConverter(CaracteristicaSituacao.class, CaracteristicaSituacao.CONVERTER)
        .withConverter(Double.class, new DoubleConverter())
        .withConverter(LocalDate.class, new LocalDateCsvConverter("dd/MM/yyyy"))
        .withConverter(DATA_VENCIMENTO, new DataVencimento())
        .withConverter(DATA_SAIDA, new DataOpcional())
        .withConverter(SERIE, SerieConverter.INSTANCE)
        .withConverter(EMISSAO, EmissaoConverter.INSTANCE)
        .getLines();

    Iterable<Record> registros;
    registros = Iterables.transform(lines, new ToRecord());

    registros = Iterables.filter(registros, Predicates.notNull());

    return new Caracteristica(data, registros);
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

  private static class DataOpcional extends LocalDateCsvConverter {
    public DataOpcional() {
      super("dd/MM/yyyy");
    }

    @Override
    public LocalDate convert(String text) {
      LocalDate date = null;

      if (!Strings.isNullOrEmpty(text)) {
        date = super.convert(text);
      }

      return date;
    }
  }

  private static class DoubleConverter extends AbstractCsvConverter<Double> {

    @Override
    protected Double convert(String text) {
      try {
        text = text.replaceAll("\\.", "");
        text = text.replaceAll(",", ".");
        return Double.parseDouble(text);
      } catch (NumberFormatException e) {
        return Double.valueOf(0d);
      }
    }

  }

}