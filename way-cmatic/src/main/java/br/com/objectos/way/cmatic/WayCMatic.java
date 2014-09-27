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

import java.util.Locale;

import org.joda.time.LocalDate;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class WayCMatic {

  private static final Locale EN = new Locale("en");

  static final String SEPARATOR = "\r\n";

  private WayCMatic() {
  }

  public static HistoricoPadrao hpOf(int codigo, String complemento) {
    return HistoricoPadrao.hpOf(codigo, complemento);
  }
  public static HistoricoPadrao hpOf(String complemento) {
    return HistoricoPadrao.hpOf(complemento);
  }

  public static ConstrutorDeLancamentos lancamentosDe(String empresa, LocalDate ano) {
    Preconditions.checkNotNull(empresa);
    Preconditions.checkNotNull(ano);
    return new ConstrutorDeLancamentos(empresa, ano);
  }

  public static ConstrutorDeLancamentoMM multiploMultiplo(int numero, LocalDate data) {
    return new ConstrutorDeLancamentoMM(numero, data);
  }

  public static ConstrutorDePlanoDeContas planoDeContas() {
    return new ConstrutorDePlanoDeContas();
  }

  static String joinLines(Iterable<String> lines) {
    return Joiner.on(SEPARATOR).join(lines);
  }

  static String toTxtPart(String format, Object val, int limit) {
    return String.format(EN, format, val).substring(0, limit);
  }

}