/*
 * TesteDeCaracteristica.java criado em 24/04/2013
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

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.way.io.LineKey;
import br.com.objectos.way.io.Record;
import br.com.objectos.way.io.ToEnumStringVal;
import br.com.objectos.way.io.ToIntegerVal;
import br.com.objectos.way.io.ToLocalDateVal;
import br.com.objectos.way.io.ToLongVal;
import br.com.objectos.way.io.ToStringVal;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Test
public class TesteDeCaracteristica {

  private List<Record> regs;

  private final int i0 = 2 - 2;
  private final int i1 = 24 - 2;
  private final int i2 = 209 - 2;

  @BeforeClass
  public void prepararRegistros() {
    File file = CaracteristicasFalso.CARACTERISTICAS_20130424;
    Caracteristica snd = Caracteristica.of(file);
    regs = snd.getRegistros();
  }

  public void codigo() {
    LineKey<String> key = keys().codigo();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("ABC11"));
    assertThat(res.get(i1), equalTo("ABMX11"));
    assertThat(res.get(i2), equalTo("BFBL14"));
  }

  public void empresa() {
    LineKey<String> key = keys().empresa();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("PARTICIPACOES ABC S/A"));
    assertThat(res.get(i1), equalTo("ABIMEX IMPORTACAO E EXPORTACAO S/A"));
    assertThat(res.get(i2), equalTo("BFB LEASING S/A ARRENDAMENTO MERCANTIL"));
  }

  public void serie() {
    LineKey<String> key = keys().serie();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("001"));
    assertThat(res.get(i1), equalTo("UNI"));
    assertThat(res.get(i2), equalTo("001"));
  }

  public void emissao() {
    LineKey<Integer> key = keys().emissao();
    List<Integer> res = transform(regs, new ToIntegerVal(key));

    assertThat(res.get(i0), equalTo(1));
    assertThat(res.get(i1), equalTo(1));
    assertThat(res.get(i2), equalTo(4));
  }

  public void situacao() {
    LineKey<CaracteristicaSituacao> key = keys().situacao();
    List<String> res = transform(regs, new ToEnumStringVal(key));

    assertThat(res.get(i0), equalTo("EXCLUIDO"));
    assertThat(res.get(i1), equalTo("REGISTRADO"));
    assertThat(res.get(i2), equalTo("EXCLUIDO"));
  }

  public void codigo_isin() {
    LineKey<String> key = keys().codigoIsin();
    List<String> res = transform(regs, new ToStringVal(key));

    assertThat(res.get(i0), equalTo("BRPTABDBS011"));
    assertThat(res.get(i1), equalTo("BRABMXDBS002"));
    assertThat(res.get(i2), equalTo(null));
  }

  public void data_emissao() {
    LineKey<LocalDate> key = keys().dataEmissao();
    List<LocalDate> res = transform(regs, new ToLocalDateVal(key));

    assertThat(res.get(i0), equalTo(new LocalDate(1995, 5, 23)));
    assertThat(res.get(i1), equalTo(new LocalDate(2012, 4, 10)));
    assertThat(res.get(i2), equalTo(new LocalDate(1992, 7, 1)));
  }

  public void data_vencimento() {
    LineKey<LocalDate> key = keys().dataVencimento();
    List<LocalDate> res = transform(regs, new ToLocalDateVal(key));

    assertThat(res.get(i0), equalTo(null));
    assertThat(res.get(i1), equalTo(new LocalDate(2018, 4, 10)));
    assertThat(res.get(i2), equalTo(new LocalDate(1995, 1, 1)));
  }

  public void qtd_emitida() {
    LineKey<Long> key = keys().quantidadeEmitida();
    List<Long> res = transform(regs, new ToLongVal(key));

    assertThat(res.get(i0), equalTo(1176l));
    assertThat(res.get(i1), equalTo(60l));
    assertThat(res.get(i2), equalTo(6000l));
  }

  public void qtd_mercado() {
    LineKey<Long> key = keys().quantidadeMercado();
    List<Long> res = transform(regs, new ToLongVal(key));

    assertThat(res.get(i0), equalTo(0l));
    assertThat(res.get(i1), equalTo(60l));
    assertThat(res.get(i2), equalTo(0l));
  }

}