package br.com.objectos.base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.joda.time.LocalDate;
import org.jsoup.nodes.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * TesteDeListagemCri.java criado em 27/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */

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

  public void emissao() {
    Emissor res = cri.getEmissor();

    assertThat(res.getStatusDaEmissao(), equalTo("Ativo"));
    assertThat(res.getLocalNegociacao(), equalTo("Bovespa Fix"));
  }

  public void caracteristica() {
    CaracteristicaEmissao res = cri.getCaracteristicaEmissao();

    assertThat(res.getNumero(), equalTo(1));
    assertThat(res.getEmissor().getNome(),
        equalTo("AETA - Aetatis Securitizadora S.A."));
    assertThat(res.getVolumeTotalEmissao(), equalTo(34912722.86));
    assertThat(res.getQuantidadeCri(), equalTo(34));
    assertThat(res.getQuantidadeSeriesEmitidas(), equalTo(1));
  }

  public void caracterista_serie() {
    CaracteristicaSerie res = cri.getCaracteristicaSerie();

    assertThat(res.getCodigoTitulo(), equalTo("AETA-C10"));
    assertThat(res.getCodigoIsin(), equalTo("BRAETACRI099"));
    assertThat(res.getQuantidadeCri(), equalTo(0));
    assertThat(res.getNumeroSerie(), equalTo(10));
    assertThat(res.getDataEmissao(), equalTo(new LocalDate(2011, 04, 19)));
    assertThat(res.getDataVencimento(),
        equalTo(new LocalDate(2018, 01, 8)));
    assertThat(res.getVolumeSerie(), equalTo(3867394.35));
    assertThat(res.getAtualizacao(), equalTo("IGP-M"));

    assertThat(res.getGarantia().get(), equalTo(""));
    assertThat(res.getProximaRepactuacao().get(), equalTo(new LocalDate(
        0000,
        00, 00)));
    assertThat(res.getUltimaRepactuacao().get(), equalTo(new LocalDate(
        0000, 00, 00)));
    assertThat(res.getAmortizacao(), equalTo(""));
    assertThat(res.getAgenteFiduciario(), equalTo("GDC Partners DTVM"));
    assertThat(res.getEnquadraArtUm(), equalTo("Não"));
    assertThat(res.getEnquadraArtDois(), equalTo("Não"));
  }

  public void remuneracao() {
    Remuneracao res = cri.getRemuneracao();

    assertThat(res.getParticipacaoLucro(), equalTo(false));
    assertThat(res.getTaxaJuros(), equalTo("9,%"));
    assertThat(res.getPagamento(), equalTo(""));
    assertThat(res.getPremio(), equalTo(0.00));
  }

  public void informacoes_relacionadas() {
    InformacoesRelacionadas res = cri.getInformacoesRelacionadas();

    assertThat(res.getAdicionais(),
        equalTo("Informações de Atas de Assembleias"));
  }

}