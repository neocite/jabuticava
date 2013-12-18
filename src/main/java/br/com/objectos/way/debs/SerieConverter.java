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

import br.com.objectos.comuns.io.csv.AbstractCsvConverter;

import com.google.common.base.Strings;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class SerieConverter extends AbstractCsvConverter<String> {

  static final SerieConverter INSTANCE = new SerieConverter();

  private SerieConverter() {
  }

  @Override
  protected String convert(String text) {
    text = Strings.nullToEmpty(text);
    return br.com.objectos.comuns.base.Strings
        .accentsToAscii(text)
        .alphanum()
        .toString();
  }

}