/*
 * TesteDeCaracteristica20131206.java criado em 18/12/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import static br.com.objectos.way.debs.emissao.Caracteristica.keys;
import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.way.io.LineKey;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.ToIntegerVal;
import br.com.objectos.way.io.ToStringVal;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeCaracteristica20131206 {

  private Caracteristica snd;
  private List<Record> regs;

  private final int i0 = 4 - 4;
  private final int i1 = 5 - 4;
  private final int i2 = 7 - 4;

  @BeforeClass
  public void prepararRegistros() {
    File file = CaracteristicasFalso.CARACTERISTICAS_20131206;
    snd = Caracteristica.of(file);
    regs = snd.getRegistros();
  }

  public void serie() {
    LineKey<String> key = keys().serie();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("UNI"));
    assertThat(res.get(i1), equalTo("UNI"));
    assertThat(res.get(i2), equalTo("001"));
  }

  public void emissao() {
    LineKey<Integer> key = keys().emissao();
    List<Integer> res = transform(regs, new ToIntegerVal(key));

    assertThat(res.get(i0), equalTo(1));
    assertThat(res.get(i1), equalTo(2));
    assertThat(res.get(i2), equalTo(5));
  }

}