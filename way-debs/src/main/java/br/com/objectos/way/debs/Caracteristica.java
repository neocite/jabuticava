/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.debs;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.csv.CsvFile;
import br.com.objectos.way.io.Record;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class Caracteristica {

  private static String url = "http://www.debentures.com.br"
      + "/exploreosnd/consultaadados/emissoesdedebentures"
      + "/caracteristicas_e.asp?tip_deb=publicas&op_exc=False";

  private static final CaracteristicaSpec keys = new CaracteristicaSpec();

  static final Charset CHARSET = Charsets.ISO_8859_1;

  private final String text;

  private final LocalDate data;

  private final List<Record> registros;

  Caracteristica(String text, LocalDate data, Iterable<Record> registros) {
    this.text = text;
    this.data = data;
    this.registros = ImmutableList.copyOf(registros);
  }

  public static Caracteristica wget() {
    try {
      URLInputSupplier in = new URLInputSupplier(url);
      String text = CharStreams.toString(CharStreams.newReaderSupplier(in, CHARSET));
      return Caracteristica.parseString(text);
    } catch (IOException e) {
      return Caracteristica.vazio();
    }
  }

  public static Caracteristica parse(File file) {
    try {
      String text = Files.toString(file, CHARSET);
      return parseString(text);
    } catch (IOException e) {
      return Caracteristica.vazio();
    }
  }

  public static Caracteristica parseString(String text) {
    LocalDate data = new DataParser(text).get();
    CsvFile csvFile = CsvFile.parseString(text);
    return new CaracteristicaParser(text, data, csvFile).get();
  }

  static Caracteristica vazio() {
    LocalDate data = new LocalDate();
    List<Record> registros = ImmutableList.of();
    return new Caracteristica("", data, registros);
  }

  public void writeTo(File file) {
    try {
      Files.write(text, file, CHARSET);
    } catch (IOException e) {
    }
  }

  public static CaracteristicaKeys keys() {
    return keys;
  }

  public LocalDate getData() {
    return data;
  }

  public List<Record> getRegistros() {
    return registros;
  }

  @Override
  public String toString() {
    return text;
  }

}