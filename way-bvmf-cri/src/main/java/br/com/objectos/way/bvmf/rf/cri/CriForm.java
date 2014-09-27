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

import java.io.IOException;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CriForm {

  private static final Map<String, String> POST_DATA = ImmutableMap.<String, String> builder()
      .put("cboEmissor", "")
      .put("cboAgente", "QQ")
      .put("cboPrazo", "QQ")
      .put("cboIndexador", "QQ")
      .put("cboMesEmiss", "")
      .put("cboAnoEmiss", "")
      .put("cboCodEmissor", "")
      .put("cboLider", "QQ")
      .put("cboGarantia", "QQ")
      .put("cboVolume", "0")
      .put("cboMercado", "QQ")
      .put("cboArt1", "QQ")
      .put("cboArt2", "QQ")
      .build();

  private final CriFormAction action;

  @Inject
  public CriForm(CriFormAction action) {
    this.action = action;
  }

  public Document post() throws IOException {
    String url = action.get();

    return Jsoup.connect(url)
        .data(POST_DATA)
        .post();
  }

}