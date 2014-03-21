/*
 * PerdaDeCredito.java criado em 21/03/2014
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

import java.util.List;

import org.joda.time.LocalDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
@Test
public class TesteDeBradesco343701 {

  private final BoletoBanco bradesco = BoletoBanco.BRADESCO;

  private Boleto boleto;

  @BeforeClass
  public void prepararBoleto() {
    boleto = Boletos.novoBoleto()
        .contaBancaria(new ContaBancariaFalso())
        .titulo(new TituloFalso())
        .cobranca(new CobrancaFalso())
        .novaInstancia();
  }

  public void linha_digitavel() {
    String prova = "23790.59906 94066.000004 02001.580006 4 60130000057200";

    CodigoDeBarras codigo = bradesco.codigoDeBarrasDe(boleto);
    LinhaDigitavel res = codigo.toLinhaDigitavel();

    assertThat(res, hasToString(equalTo(prova)));
  }

  private class TituloFalso implements BoletoTitulo {

    @Override
    public BoletoEspecie getEspecie() {
      return BoletoEspecie.DM_DUPLICATA_MERCANTIL;
    }

    @Override
    public ValorFinanceiro getValor() {
      return new ValorFinanceiroImpl(572.0);
    }

    @Override
    public ValorFinanceiro getDesconto() {
      return new ValorFinanceiroImpl(0.0);
    }

    @Override
    public LocalDate getEmissao() {
      return new LocalDate(2014, 3, 7);
    }

    @Override
    public LocalDate getVencimento() {
      return new LocalDate(2014, 3, 25);
    }

  }

  private class ContaBancariaFalso implements BoletoContaBancaria {

    @Override
    public BoletoBanco getBanco() {
      return BoletoBanco.BRADESCO;
    }

    @Override
    public BoletoCarteira getCarteira() {
      return BoletoCarteira.COBRANCA_SIMPLES_COM_REGISTRO;
    }

    @Override
    public String getAgencia() {
      return "0599";
    }

    @Override
    public String getNumero() {
      return "15800-3";
    }

  }

  private class CobrancaFalso implements BoletoCobranca {

    @Override
    public String getDescricao() {
      return null;
    }

    @Override
    public LocalDate getDataProcessamento() {
      return new LocalDate(2014, 2, 21);
    }

    @Override
    public String getNossoNumero() {
      return "40660000002P";
    }

    @Override
    public boolean isAceite() {
      return false;
    }

    @Override
    public List<String> getInstrucoes() {
      return null;
    }

    @Override
    public String getInformacaoAdicional() {
      return null;
    }

    @Override
    public String getLocalPagamento() {
      return null;
    }

    @Override
    public String getNumeroDocumento() {
      return "3437/01";
    }

  }

}