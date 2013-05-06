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

import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

/**
 * @author "edenir.anschau@objectos.com.br (Edenir Norberto Anschau)"
 */
@Test
public class TesteDeBradesco {

  private final Bradesco bradesco = new Bradesco();

  public void codigo_barras() {
    Boleto boleto = null;
    String prova = "23795581000000340000123090000000105000123450";

    String res = bradesco.codigoDeBarrasDe(boleto);

    assertThat(res, equalTo(prova));
  }

  private class BoletoFalso implements Boleto {

    private final int codigoMoeda = 9;

    public int getCodigoMoeda() {
      return codigoMoeda;
    }

    public DigitoVerificador getDVCodigoDeBarras() {
      return null;
    }

    public FatorDeVencimento getFatorDeVencimento() {
      return null;
    }

    @Override
    public BoletoContaBancaria getContaBancaria() {
      return new BoletoContaBancariaFalso();
    }

    @Override
    public BoletoCedente getCedente() {
      return null;
    }

    @Override
    public BoletoSacado getSacado() {
      return null;
    }

    @Override
    public BoletoTitulo getTitulo() {
      return new TituloFalso();
    }

    @Override
    public BoletoCobranca getCobranca() {
      return new BoletoCobrancaFalso();
    }

  }

  private class TituloFalso implements BoletoTitulo {

    @Override
    public BoletoEspecie getEspecie() {
      return null;
    }

    @Override
    public ValorFinanceiro getValor() {
      return null; // retornar 340.00
    }

    @Override
    public LocalDate getEmissao() {
      return null;
    }

    @Override
    public LocalDate getVencimento() {
      return new LocalDate(2013, 5, 6);
    }

  }

  private class BoletoContaBancariaFalso implements BoletoContaBancaria {

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
      return "0123";
    }

    @Override
    public String getNumero() {
      return "00123-4";
    }

  }

  private class BoletoCobrancaFalso implements BoletoCobranca {

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
      return "112/00001050-9";
    }

    @Override
    public boolean isAceite() {
      return false;
    }

    @Override
    public String getInstrucao() {
      return null;
    }

    @Override
    public String getLocalPagamento() {
      return null;
    }

    @Override
    public String getNumeroDocumento() {
      return null;
    }

  }

}