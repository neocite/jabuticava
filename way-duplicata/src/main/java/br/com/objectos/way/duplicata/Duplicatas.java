/*
 * Duplicatas.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.joda.time.LocalDate;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;
import com.google.common.io.Files;
import com.google.common.io.Resources;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class Duplicatas {

  private Duplicatas() {
  }

  public static ConstrutorDeDuplicata novaDuplicata(DuplicataTipo tipo) {
    return new ConstrutorDeDuplicata()
        .tipo(tipo);
  }

  static MustacheFactory resourcesMf() {
    try {
      File tempDir = Files.createTempDir();
      return newMustacheFactoryAt(tempDir);
    } catch (IOException e) {
      return new DefaultMustacheFactory();
    }
  }

  static String toString(LocalDate data) {
    return data != null ? data.toString("dd/MM/yyyy") : null;
  }

  private static MustacheFactory newMustacheFactoryAt(File dir) throws IOException {
    copyMustache("duplicata.mustache", dir);
    copyMustache("duplicata-page.mustache", dir);

    return new DefaultMustacheFactory(dir);
  }

  private static File copyMustache(String from, File to) throws IOException {
    URL url = Resources.getResource(Styles.class, String.format("/template/%s", from));
    File dest = new File(to, from);
    FileOutputStream out = new FileOutputStream(dest);
    Resources.copy(url, out);
    return dest;
  }

}