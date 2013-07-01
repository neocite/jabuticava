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

import static com.google.common.collect.Lists.transform;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
@Test
public class TesteDeListagemParser {

  private ListagemParser parser;

  private final int i0 = 0;
  private final int i1 = 1;
  private final int in = 142 - 3;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.LISTAGEM;
    parser = new ListagemParser(doc);
  }

  public void deve_retornar_todos_os_links() {
    List<CriLink> res = parser.get();
    assertThat(res.size(), equalTo(142));

    List<String> cods = transform(res, new ToCodigo());
    assertThat(cods.get(i0), equalTo("AETA-C10"));
    assertThat(cods.get(i1), equalTo("AETA-C11"));
    assertThat(cods.get(in), equalTo("WTPI-C02"));

    List<String> hrefs = transform(res, new ToHref());
    assertThat(
        hrefs.get(i0),
        equalTo("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=AETA&CodEsp=C10&CodTit=3&NumEmi=1&NumSeri=10&Art1=N&Art2=N"));
    assertThat(
        hrefs.get(i1),
        equalTo("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=AETA&CodEsp=C11&CodTit=3&NumEmi=1&NumSeri=1&Art1=N&Art2=N"));
    assertThat(
        hrefs.get(in),
        equalTo("http://fake/rendafixa/CRI_ResumoEmissoesDetalhes.asp?CodEmi=WTPI&CodEsp=C02&CodTit=3&NumEmi=2&NumSeri=1&Art1=N&Art2=N"));
  }

  private class ToCodigo implements Function<CriLink, String> {

    @Override
    public String apply(CriLink input) {
      return input.getCodigo();
    }

  }

  private class ToHref implements Function<CriLink, String> {

    @Override
    public String apply(CriLink input) {
      return input.getHref();
    }

  }

}
