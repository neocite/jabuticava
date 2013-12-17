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
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@Test
public class TesteDeBradesco {

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

  public void codigo_barras() {
    String prova = "23791570100000150001018090000000502000163240";

    CodigoDeBarras res = bradesco.codigoDeBarrasDe(boleto);

    assertThat(res, hasToString(equalTo(prova)));
  }

  public void linha_digitavel() {
    String prova = "23791.01807 90000.000506 20001.632403 1 57010000015000";

    CodigoDeBarras codigo = bradesco.codigoDeBarrasDe(boleto);
    LinhaDigitavel res = codigo.toLinhaDigitavel();

    System.out.println(prova);
    System.out.println(res);

    assertThat(res, hasToString(equalTo(prova)));
  }

  private class TituloFalso implements BoletoTitulo {

    @Override
    public BoletoEspecie getEspecie() {
      return BoletoEspecie.DM_DUPLICATA_MERCANTIL;
    }

    @Override
    public ValorFinanceiro getValor() {
      return new ValorFinanceiroImpl(150.0);
    }

    @Override
    public LocalDate getEmissao() {
      return new LocalDate(2013, 5, 7);
    }

    @Override
    public LocalDate getVencimento() {
      return new LocalDate(2013, 5, 17);
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
      return "1018";
    }

    @Override
    public String getNumero() {
      return "16324";
    }

  }

  private class CobrancaFalso implements BoletoCobranca {

    @Override
    public String getDescricao() {
      return null;
    }

    @Override
    public LocalDate getDataProcessamento() {
      return null;
    }

    @Override
    public String getNossoNumero() {
      return "50200";
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
      return "1002";
    }

  }

}