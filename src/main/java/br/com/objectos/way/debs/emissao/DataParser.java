/*
 * DataParser.java criado em 29/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.csv.LocalDateCsvConverter;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class DataParser {

  private static final Pattern REGEX = Pattern.compile("([0-9]{2}/[0-9]{2}/[0-9]{4})");

  private final File file;

  public DataParser(File file) {
    this.file = file;
  }

  public LocalDate get() {
    LocalDate res = null;

    try {
      String line = Files.readFirstLine(file, Charsets.ISO_8859_1);
      line = Strings.nullToEmpty(line);
      Matcher matcher = REGEX.matcher(line);
      if (matcher.find()) {
        String data = matcher.group(0);
        res = new LocalDateCsvConverter("dd/MM/yyyy").convert(data);
      }
    } catch (IOException e) {
    }

    return res;
  }

}