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
package br.com.objectos.way.bvmf.rf.cri;

import static org.joda.time.format.DateTimeFormat.forPattern;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.objectos.comuns.base.text.DecimalFormats;

import com.google.common.base.Strings;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
class CriMap {

  private static final Logger logger = LoggerFactory.getLogger(CriMap.class);

  private final Map<String, String> map;

  private final DecimalFormat doubleFormat = DecimalFormats.newCurrencyWithLocale("pt");

  public CriMap(Map<String, String> map) {
    this.map = map;
  }

  public String getString(String key) {
    String val = map.get(key);
    return Strings.nullToEmpty(val);
  }

  public boolean getBoolean(String key) {
    String val = getString(key);
    return "Sim".equals(val);
  }

  public int getInt(String key) {
    int res = 0;

    String val = getString(key);
    if (!Strings.isNullOrEmpty(val)) {
      try {
        res = Integer.parseInt(val);
      } catch (NumberFormatException e) {
        logger.debug("getInt:" + key + "=" + val);
      }
    }

    return res;
  }

  public double getDouble(String key) {
    double res = 0;

    String val = getString(key);
    if (!Strings.isNullOrEmpty(val)) {
      try {
        Number number = doubleFormat.parse(val);
        res = number.doubleValue();
      } catch (ParseException e) {
      }
    }

    return res;
  }

  public LocalDate getLocalDate(String key) {
    LocalDate res = null;

    String val = getString(key);
    if (!Strings.isNullOrEmpty(val)) {
      res = forPattern("dd/MM/yyyy").parseLocalDate(val);
    }

    return res;
  }

}