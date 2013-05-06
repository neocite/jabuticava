/*
 * BoletoCobrancaPojo.java criado em 03/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class CobrancaFalso implements BoletoCobranca {

  @Override
  public String getDescricao() {
    return "Título referente ao produto XYZ.";
  }

  @Override
  public LocalDate getDataProcessamento() {
    return new LocalDate();
  }

  @Override
  public String getNossoNumero() {
    return "5252528";
  }

  @Override
  public boolean isAceite() {
    return false;
  }

  @Override
  public String getInstrucao() {
    return "Juros/Mora ao Dia : R$ 0,35 apos 03/05/2013.\n" +
        "Multa de 2,00% apos 1 dia(s) do vencimento.";
  }

  @Override
  public String getLocalPagamento() {
    return "Pagável em qualquer banco até a data de vencimento";
  }

  @Override
  public String getNumeroDocumento() {
    return "03052013";
  }

}
