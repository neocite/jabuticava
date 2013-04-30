/*
 * CaracteristicaKey.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import java.io.File;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.csv.CsvFile;
import br.com.objectos.way.io.Record;

import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Caracteristica {

  private static final CaracteristicaSpec keys = new CaracteristicaSpec();

  private final LocalDate data;

  private final List<Record> registros;

  Caracteristica(LocalDate data, Iterable<Record> registros) {
    this.data = data;
    this.registros = ImmutableList.copyOf(registros);
  }

  public static Caracteristica of(File file) {
    LocalDate data = new DataParser(file).get();
    CsvFile csvFile = CsvFile.parse(file);
    return new CaracteristicaParser(data, csvFile).get();
  }

  public static CaracteristicaSpec keys() {
    return keys;
  }

  public LocalDate getData() {
    return data;
  }

  public List<Record> getRegistros() {
    return registros;
  }

}