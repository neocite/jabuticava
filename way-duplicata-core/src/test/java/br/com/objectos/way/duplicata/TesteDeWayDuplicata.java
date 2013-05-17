/*
 * TesteDeWayDuplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import static com.google.common.collect.Lists.newArrayList;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
@Guice(modules = { ModuloDeTesteWayDuplicata.class })
public class TesteDeWayDuplicata {

  @Inject
  private WayDuplicata way;

  private Duplicata duplicata;

  @BeforeClass
  public void preparDuplicata() {
    duplicata = Duplicatas.novaDuplicata()
        .cedente(new CedenteFalso())
        .sacado(new SacadoFalso())
        .fatura(new FaturaFalsa())
        .valorPorExtenso("Quinhentos reais.")
        .dataDoAceite(new LocalDate(2013, 5, 7))
        .novaInstancia();
  }

  public void html_string() throws Exception {
    String contra = "/duplicata.html";
    String prova = DuplicatasFalso.toString(contra);

    String res = way.htmlOf(duplicata).toString();
    assertLines(res, prova);
  }

  public void html_file() throws IOException {
    String tmpDir = System.getProperty("java.io.tmpdir");
    File dir = new File(tmpDir);
    File file = new File(dir, "way-duplicata.html");
    way.htmlOf(duplicata).page().toFile(file);
  }

  private void assertLines(String _res, String _prova) throws IOException {
    List<String> lines = linesOf(_res);
    List<String> prova = linesOf(_prova);

    List<String> invalids = newArrayList();

    for (int i = 0; i < prova.size(); i++) {
      String exp = prova.get(i);
      String res = null;
      if (i < lines.size()) {
        res = lines.get(i);
      }

      Line line = new Line(i, exp, res);
      if (!line.valid()) {
        invalids.add(line.toString());
      }
    }

    if (!invalids.isEmpty()) {
      String output = Joiner.on("\n").join(invalids);
      System.out.println(output);
      fail();
    }
  }

  private List<String> linesOf(String html) {
    Iterable<String> lines = Splitter.on(br.com.objectos.way.duplicata.Line.sep).split(html);
    return ImmutableList.copyOf(lines);
  }

}