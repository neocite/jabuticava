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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.way.bvmf.rf.cri.CriEmissao;
import br.com.objectos.way.bvmf.rf.cri.CriSerie;
import br.com.objectos.way.bvmf.rf.cri.Cri;
import br.com.objectos.way.bvmf.rf.cri.CriParser;
import br.com.objectos.way.bvmf.rf.cri.CriEmissor;
import br.com.objectos.way.bvmf.rf.cri.CriInformacoes;
import br.com.objectos.way.bvmf.rf.cri.CriRemuneracao;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
@Test
public class TesteDeListagemCri {

  private Cri cri;

  @BeforeClass
  public void setUp() {
    Document doc = HtmlsFalso.DETALHES;
    cri = new CriParser(doc).get();
  }

  public void emissor() {
    CriEmissor res = cri.getEmissor();

    assertThat(res.getStatus(), equalTo("ATIVO"));
    assertThat(res.getLocalNegociacao(), equalTo("Bovespa Fix"));
  }

  public void caracteristica() {
    CriEmissao res = cri.getEmissao();

    assertThat(res.getNumero(), equalTo(1));
    assertThat(res.getVolumeTotalEmissao(), equalTo(34912722.86));
    assertThat(res.getQuantidadeCri(), equalTo(34));
    assertThat(res.getQuantidadeSeriesEmitidas(), equalTo(1));
  }

  public void caracterista_serie() {
    CriSerie res = cri.getSerie();

    assertThat(res.getCodigoTitulo(), equalTo("AETA-C10"));
    assertThat(res.getCodigoIsin(), equalTo("BRAETACRI099"));
    assertThat(res.getQuantidadeCri(), equalTo(0));
    assertThat(res.getNumeroSerie(), equalTo(10));
    assertThat(res.getDataEmissao(), equalTo(new LocalDate(2011, 4, 19)));
    assertThat(res.getDataVencimento(), equalTo(new LocalDate(2018, 1, 8)));
    assertThat(res.getVolumeSerie(), equalTo(3867394.35));
    assertThat(res.getAtualizacaoMonetaria(), equalTo("IGP-M"));

    assertThat(res.getGarantia(), equalTo(""));
    assertThat(res.getProximaRepactuacao().isPresent(), equalTo(false));
    assertThat(res.getUltimaRepactuacao().isPresent(), equalTo(false));
    assertThat(res.getAmortizacao(), equalTo(""));
    assertThat(res.getAgenteFiduciario(), equalTo("GDC Partners DTVM"));
    assertThat(res.isEnquadraArtUm(), equalTo(false));
    assertThat(res.isEnquadraArtDois(), equalTo(false));
  }

  public void remuneracao() {
    CriRemuneracao res = cri.getRemuneracao();

    assertThat(res.isParticipacaoLucro(), equalTo(false));
    assertThat(res.getTaxaJuros(), equalTo("9,%"));
    assertThat(res.getPagamento(), equalTo(""));
    assertThat(res.getPremio(), equalTo(0.0));
  }

  public void informacoes_relacionadas() {
    CriInformacoes res = cri.getInformacoes();

    assertThat(res.getAdicionais(), equalTo("Informações de Atas de Assembleias"));
  }

}