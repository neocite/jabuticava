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
package br.com.objectos.way.cmatic;

import static com.google.common.collect.Lists.transform;

import java.util.List;

import javax.annotation.concurrent.NotThreadSafe;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.Strings;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@NotThreadSafe
public class Lancamentos {

  interface CMatic {

    String getEmpresa();

    LocalDate getAno();

    List<IsLancamento> getLancamentos();

  }

  private final String empresa;
  private final LocalDate ano;
  private final List<IsLancamento> lancamentos;

  private String nome;
  private String log;
  private String txt;

  private Lancamentos(CMatic cmatic) {
    empresa = cmatic.getEmpresa();
    ano = cmatic.getAno();
    lancamentos = cmatic.getLancamentos();
  }

  static Lancamentos of(CMatic cmatic) {
    return new Lancamentos(cmatic);
  }

  public String getNome() {
    if (this.nome == null) {
      String nome = Strings
          .accentsToAscii(empresa)
          .stripWhitespace()
          .toString()
          .toUpperCase();
      String data = ano.toString("yy");
      this.nome = String.format("%s.M%s", nome, data);
    }
    return this.nome;
  }

  public String toLog() {
    if (log == null) {
      List<List<String>> listzes = transform(lancamentos, ToLog.INSTANCE);
      Iterable<String> lines = Iterables.concat(listzes);
      log = WayCMatic.joinLines(lines);
    }
    return log;
  }

  public String toTxt() {
    if (txt == null) {
      List<String> lines = transform(lancamentos, ToTxt.INSTANCE);
      txt = WayCMatic.joinLines(lines);
    }
    return txt;
  }

  private static enum ToLog implements Function<IsLancamento, List<String>> {
    INSTANCE;
    @Override
    public List<String> apply(IsLancamento input) {
      return input.toLog();
    }
  }

  private static enum ToTxt implements Function<IsLancamento, String> {
    INSTANCE;
    @Override
    public String apply(IsLancamento input) {
      return input.toTxt();
    }
  }

}