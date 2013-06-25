/*
 * TesteDeListagemCrii.java criado em 27/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
@Test
public class TesteDeListagemCrii {

  private Cri cri;

  public void cri() {
    Cri res = cri;
    Emissor emissor = res.getEmissor();
    CaracteristicaEmissao caracteristica = res.getCaracteristicaEmissao();
    CaracteristicaSerie serie = res.getCaracteristicaSerie();
    Remuneracao remuneracao = res.getRemuneracao();
    InformacoesRelacionadas relacionadas = res.getInformacoesRelacionadas();

    assertThat(emissor.getStatusDaEmissao(), equalTo("Ativo"));
    assertThat(emissor.getLocalNegociacao(), equalTo("Bovespa Fix"));

    assertThat(caracteristica.getNumero(), equalTo(1));
    assertThat(caracteristica.getEmissor().getNome(),
        equalTo("WTVP - BRPR 55 Securit. de Créditos Imob. S.A."));
    assertThat(caracteristica.getVolumeTotalEmissao(), equalTo(18000000.00));
    assertThat(caracteristica.getQuantidadeCri(), equalTo(60));
    assertThat(caracteristica.getQuantidadeSeriesEmitidas(), equalTo(1));

    assertThat(serie.getCodigoTitulo(), equalTo("WTVP-C11"));
    assertThat(serie.getCodigoIsin(), equalTo("BRWTVPCRI004"));
    assertThat(serie.getQuantidadeCri(), equalTo(60));
    assertThat(serie.getNumeroSerie(), equalTo(1));
    assertThat(serie.getDataEmissao(), equalTo(new LocalDate(2005, 11, 03)));
    assertThat(serie.getDataVencimento(), equalTo(new LocalDate(2020, 11, 03)));
    assertThat(serie.getVolumeSerie(), equalTo(18000000.00));
    assertThat(serie.getAtualizacao(), equalTo("IGP-M"));
    assertThat(serie.getGarantia(), equalTo(null));
    // assertThat(serie.getProximaRepactuacao(), equalTo(new LocalDate(2006, 05,
    // 03)));
    // assertThat(serie.getUltimaRepactuacao(), equalTo(new LocalDate(2006, 05,
    // 03)));
    assertThat(serie.getAmortizacao(), equalTo("Amortizado anual e sucessivamente," +
        " a partir da data da emissão, sempre no dia 3 de novembro de cada ano," +
        " sendo a 1ª amortização no dia 3/11/2006."));
    assertThat(serie.getAgenteFiduciario(), equalTo("Pentagono S.A D.T.V.M"));
    assertThat(serie.getEnquadraArtUm(), equalTo("Não"));
    assertThat(serie.getEnquadraArtDois(), equalTo("Não"));

    assertThat(remuneracao.getParticipacaoLucro(), equalTo(null));
    assertThat(remuneracao.getTaxaJuros(), equalTo("10,30% a.a."));
    assertThat(remuneracao.getPagamento(), equalTo(null));
    assertThat(remuneracao.getPremio(), equalTo(null));

    assertThat(relacionadas.getAdicionais(), equalTo("Informações de Atas de Assembleias"));

  }
}