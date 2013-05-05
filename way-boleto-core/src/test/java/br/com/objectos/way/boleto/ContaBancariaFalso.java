/*
 * BoletoContaBancariaPojo.java criado em 03/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ContaBancariaFalso implements BoletoContaBancaria {

  @Override
  public BoletoBanco getBanco() {
    return BoletoBanco.ITAU;
  }

  @Override
  public BoletoCarteira getCarteira() {
    return BoletoCarteira.COBRANCA_SIMPLES_COM_REGISTRO;
  }

  @Override
  public String getAgencia() {
    return "5252";
  }

  @Override
  public String getNumero() {
    return "5525252-1";
  }

}