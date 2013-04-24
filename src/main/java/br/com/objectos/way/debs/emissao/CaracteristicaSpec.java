/*
 * CaracteristicaSpec.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import org.joda.time.LocalDate;

import br.com.objectos.way.io.AbstractLineSpec;
import br.com.objectos.way.io.LineKey;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CaracteristicaSpec extends AbstractLineSpec implements CaracteristicaKeys {

  private final LineKey<String> codigo;
  private final LineKey<String> empresa;
  private final LineKey<String> serie;
  private final LineKey<Integer> emissao;
  private final LineKey<CaracteristicaSituacao> situacao;
  private final LineKey<String> codigoIsin;
  private final LineKey<LocalDate> dataEmissao;
  private final LineKey<LocalDate> dataVencimento;
  private final LineKey<Long> quantidadeEmitida;
  private final LineKey<Long> quantidadeMercado;

  public CaracteristicaSpec() {
    codigo = id("Código do Ativo")
        .get(String.class);

    empresa = id("Empresa")
        .get(String.class);

    serie = id("Série")
        .get(String.class);

    emissao = id("Emissão")
        .get(Integer.class);

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

    id("Motivo de Saída ").get(String.class);
    id("Data de Saída / Novo Vencimento").get(String.class);
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

    id("Artigo 14º").get(String.class);
    id("Artigo 24º").get(String.class);

    quantidadeMercado = id("Quantidade em Mercado")
        .get(Long.class);

    id("Quantidade em Tesouraria").get(String.class);
    id("Quantidade Resgatada").get(String.class);
    id("Quantidade  Cancelada").get(String.class);
    id("Quantidade Convertida no SND").get(String.class);
    id("Quantidade Convertida fora do SND").get(String.class);
    id("Quantidade Permutada no SND").get(String.class);
    id("Quantidade Permutada fora do SND").get(String.class);
    id("Unidade Monetária").get(String.class);
    id("Valor Nominal na Emissão").get(String.class);
    id("Unidade Monetária").get(String.class);
    id("Valor Nominal Atual").get(String.class);
    id("Data Últ. VNA").get(String.class);
    id("Índice").get(String.class);
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
  public LineKey<Long> quantidadeEmitida() {
    return quantidadeEmitida;
  }

  @Override
  public LineKey<Long> quantidadeMercado() {
    return quantidadeMercado;
  }

}