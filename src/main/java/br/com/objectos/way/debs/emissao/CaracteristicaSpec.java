/*
 * CaracteristicaSpec.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.io.ColumnKey;
import br.com.objectos.way.io.AbstractLineSpec;
import br.com.objectos.way.io.LineKey;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CaracteristicaSpec extends AbstractLineSpec implements CaracteristicaKeys {

  static final ColumnKey<LocalDate> DATA_VENCIMENTO =
      ColumnKey.of(LocalDate.class, "dataVencimento");
  static final ColumnKey<LocalDate> DATA_SAIDA =
      ColumnKey.of(LocalDate.class, "dataSaida");
  static final ColumnKey<String> SERIE =
      ColumnKey.of(String.class, "serie");
  static final ColumnKey<Integer> EMISSAO =
      ColumnKey.of(Integer.class, "emissao");

  private final LineKey<String> codigo;
  private final LineKey<String> empresa;
  private final LineKey<String> serie;
  private final LineKey<Integer> emissao;
  private final LineKey<CaracteristicaSituacao> situacao;
  private final LineKey<String> codigoIsin;
  private final LineKey<LocalDate> dataEmissao;
  private final LineKey<LocalDate> dataVencimento;
  private final LineKey<String> motivoSaida;
  private final LineKey<LocalDate> dataSaida;
  private final LineKey<Long> quantidadeEmitida;
  private final LineKey<Long> artigo14;
  private final LineKey<Long> artigo24;
  private final LineKey<Long> quantidadeMercado;
  private final LineKey<Long> quantidadeTesouraria;
  private final LineKey<Long> quantidadeResgatada;
  private final LineKey<Long> quantidadeCancelada;
  private final LineKey<Long> quantidadeConvertida;
  private final LineKey<Long> quantidadeConvertidaFora;
  private final LineKey<Long> quantidadePermutada;
  private final LineKey<Long> quantidadePermutadaFora;
  private final LineKey<Double> valorNominalEmissao;
  private final LineKey<Double> valorNominalAtual;
  private final LineKey<String> indice;

  public CaracteristicaSpec() {
    codigo = id("Código do Ativo")
        .get(String.class);

    empresa = id("Empresa")
        .get(String.class);

    serie = id("Série")
        .get(SERIE);

    emissao = id("Emissão")
        .get(EMISSAO);

    id("IPO").get(String.class);

    situacao = id("Situação")
        .get(CaracteristicaSituacao.class);

    codigoIsin = id("ISIN")
        .get(String.class);

    id("Registro CVM da Emissão").get(String.class);
    id("Data de Registro CVM da Emissão").get(String.class);
    id("Registro CVM do Programa").get(String.class);
    id("Data de Registro CVM do Programa").get(String.class);

    dataEmissao = id("Data de Emissão")
        .get(LocalDate.class);

    dataVencimento = id("Data de Vencimento")
        .get(DATA_VENCIMENTO);

    motivoSaida = id("Motivo de Saída ")
        .get(String.class);

    dataSaida = id("Data de Saída / Novo Vencimento")
        .get(DATA_SAIDA);

    id("Data do Início da Rentabilidade").get(String.class);
    id("Data do Início da Distribuição").get(String.class);
    id("Data da Próxima Repactuação").get(String.class);
    id("Ato Societário (1)").get(String.class);
    id("Data do Ato (1)").get(String.class);
    id("Ato Societário (2)").get(String.class);
    id("Data do Ato (2)").get(String.class);
    id("Forma").get(String.class);
    id("Garantia/Espécie").get(String.class);
    id("Classe").get(String.class);

    quantidadeEmitida = id("Quantidade Emitida")
        .get(Long.class);

    artigo14 = id("Artigo 14º")
        .get(Long.class);

    artigo24 = id("Artigo 24º")
        .get(Long.class);

    quantidadeMercado = id("Quantidade em Mercado")
        .get(Long.class);

    quantidadeTesouraria = id("Quantidade em Tesouraria")
        .get(Long.class);

    quantidadeResgatada = id("Quantidade Resgatada")
        .get(Long.class);

    quantidadeCancelada = id("Quantidade Cancelada")
        .get(Long.class);

    quantidadeConvertida = id("Quantidade Convertida no SND")
        .get(Long.class);

    quantidadeConvertidaFora = id("Quantidade Convertida fora do SND")
        .get(Long.class);

    quantidadePermutada = id("Quantidade Permutada no SND")
        .get(Long.class);

    quantidadePermutadaFora = id("Quantidade Permutada fora do SND")
        .get(Long.class);

    id("Unidade Monetária (1)").get(String.class);

    valorNominalEmissao = id("Valor Nominal na Emissão")
        .get(Double.class);

    id("Unidade Monetária (2)").get(String.class);

    valorNominalAtual = id("Valor Nominal Atual")
        .get(Double.class);

    id("Data Últ. VNA").get(String.class);

    indice = id("Índice")
        .get(String.class);

    id("Tipo").get(String.class);
    id("Critério de Cálculo").get(String.class);
    id("Dia de Referência para Índice de Preços").get(String.class);
    id("Critério para Índice").get(String.class);
    id("Corrige a cada").get(String.class);
    id("Percentual Multiplicador/Rentabilidade").get(String.class);
    id("Limite da TJLP").get(String.class);
    id("Tipo de Tratamento do Limite da TJLP").get(String.class);
    id("Juros Critério Antigo do SND").get(String.class);
    id("Prêmios Critério Antigo do SND").get(String.class);
    id("Amortização - Taxa").get(String.class);
    id("Amortização - Cada").get(String.class);
    id("Amortização - Unidade").get(String.class);
    id("Amortização - Carência").get(String.class);
    id("Amortização - Critério").get(String.class);
    id("Tipo de Amortização").get(String.class);
    id("Juros Critério Novo - Taxa").get(String.class);
    id("Juros Critério Novo - Prazo").get(String.class);
    id("Juros Critério Novo - Cada").get(String.class);
    id("Juros Critério Novo - Unidade").get(String.class);
    id("Juros Critério Novo - Carência").get(String.class);
    id("Juros Critério Novo - Critério").get(String.class);
    id("Juros Critério Novo - Tipo").get(String.class);
    id("Prêmio Critério Novo - Taxa").get(String.class);
    id("Prêmio Critério Novo - Prazo").get(String.class);
    id("Prêmio Critério Novo - Cada").get(String.class);
    id("Prêmio Critério Novo - Unidade").get(String.class);
    id("Prêmio Critério Novo - Carência").get(String.class);
    id("Prêmio Critério Novo - Critério").get(String.class);
    id("Prêmio Critério Novo - Tipo").get(String.class);
    id("Participação - Taxa").get(String.class);
    id("Participação - Cada").get(String.class);
    id("Participação - Unidade").get(String.class);
    id("Participação - Carência").get(String.class);
    id("Participação - Descrição").get(String.class);
    id("Rating1").get(String.class);
    id("Agência Classificadora").get(String.class);
    id("Rating2").get(String.class);
    id("Agência Classificadora").get(String.class);
    id("Rating3").get(String.class);
    id("Agência Classificadora").get(String.class);
    id("Banco Mandatário").get(String.class);
    id("Agente Fiduciário").get(String.class);
    id("Instituição Depositária").get(String.class);
    id("Coordenador Líder").get(String.class);
    id("CNPJ").get(String.class);
    id("Deb. Incent. (Lei 12.431)").get(String.class);
  }

  @Override
  public LineKey<String> codigo() {
    return codigo;
  }

  @Override
  public LineKey<String> empresa() {
    return empresa;
  }

  @Override
  public LineKey<String> serie() {
    return serie;
  }

  @Override
  public LineKey<CaracteristicaSituacao> situacao() {
    return situacao;
  }

  @Override
  public LineKey<Integer> emissao() {
    return emissao;
  }

  @Override
  public LineKey<String> codigoIsin() {
    return codigoIsin;
  }

  @Override
  public LineKey<LocalDate> dataEmissao() {
    return dataEmissao;
  }

  @Override
  public LineKey<LocalDate> dataVencimento() {
    return dataVencimento;
  }

  @Override
  public LineKey<String> motivoSaida() {
    return motivoSaida;
  }

  @Override
  public LineKey<LocalDate> dataSaida() {
    return dataSaida;
  }

  @Override
  public LineKey<Long> quantidadeEmitida() {
    return quantidadeEmitida;
  }

  @Override
  public LineKey<Long> quantidadeMercado() {
    return quantidadeMercado;
  }

  @Override
  public LineKey<Long> artigo14() {
    return artigo14;
  }

  @Override
  public LineKey<Long> artigo24() {
    return artigo24;
  }

  @Override
  public LineKey<Long> quantidadeTesouraria() {
    return quantidadeTesouraria;
  }

  @Override
  public LineKey<Long> quantidadeResgatada() {
    return quantidadeResgatada;
  }

  @Override
  public LineKey<Long> quantidadeCancelada() {
    return quantidadeCancelada;
  }

  @Override
  public LineKey<Long> quantidadeConvertida() {
    return quantidadeConvertida;
  }

  @Override
  public LineKey<Long> quantidadeConvertidaFora() {
    return quantidadeConvertidaFora;
  }

  @Override
  public LineKey<Long> quantidadePermutada() {
    return quantidadePermutada;
  }

  @Override
  public LineKey<Long> quantidadePermutadaFora() {
    return quantidadePermutadaFora;
  }

  @Override
  public LineKey<Double> valorNominalEmissao() {
    return valorNominalEmissao;
  }

  @Override
  public LineKey<Double> valorNominalAtual() {
    return valorNominalAtual;
  }

  @Override
  public LineKey<String> indice() {
    return indice;
  }

}