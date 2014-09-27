/*
 * BoletoCobrancaPojo.java criado em 03/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import java.util.List;

import org.joda.time.LocalDate;

import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class CobrancaFalso implements BoletoCobranca {

  @Override
  public String getDescricao() {
    return "Título referente ao produto XYZ.";
  }

  @Override
  public LocalDate getDataProcessamento() {
    return new LocalDate(2013, 5, 6);
  }

  @Override
  public String getNossoNumero() {
    return "5252528-0";
  }

  @Override
  public boolean isAceite() {
    return false;
  }

  @Override
  public List<String> getInstrucoes() {
    return ImmutableList.of(
        "Após o vencimento cobrar mora de................................R$ 0,35 ao dia.",
        "Efetuar pagamento somente através deste bloqueto e na rede bancária escritural.");
  }

  @Override
  public String getInformacaoAdicional() {
    return "Após o vencimento acesse www.itau.com.br/boletos para atualizar seu boleto.";
  }

  @Override
  public String getLocalPagamento() {
    return "Pagável em qualquer banco até a data de vencimento, após o vencimento somente no Itaú.";
  }

  @Override
  public String getNumeroDocumento() {
    return "03052013";
  }

}
