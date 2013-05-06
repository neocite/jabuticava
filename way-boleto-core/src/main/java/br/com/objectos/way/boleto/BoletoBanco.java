/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import org.joda.time.LocalDate;

import br.com.objectos.way.base.SeqNum;

/**
 * @author ricardo.murad@objectos.com.br (Ricardo Murad)
 */
public enum BoletoBanco {

  BRADESCO(237, 2) {

    @Override
    String getNome() {
      return "Banco Bradesco SA";
    }

    @Override
    CodigoDeBarras codigoDeBarrasDe(Boleto boleto) {
      SeqNum seqNum = SeqNum.builder()
          .build();

      return CodigoDeBarras.of(seqNum);
    }

  },

  ITAU(341, 7) {

    @Override
    String getNome() {
      return "Banco Itaú SA";
    }

    @Override
    CodigoDeBarras codigoDeBarrasDe(Boleto boleto) {
      BoletoContaBancaria conta = boleto.getContaBancaria();
      String _agencia = conta.getAgencia();
      NumeroBancario agencia = new NumeroBancario(_agencia);
      String _numero = conta.getNumero();
      NumeroBancario numero = new NumeroBancario(_numero);
      BoletoCarteira carteira = conta.getCarteira();
      BoletoCobranca cobranca = boleto.getCobranca();
      String _nossoNumero = cobranca.getNossoNumero();
      NumeroBancario nossoNumero = new NumeroBancario(_nossoNumero);
      BoletoTitulo titulo = boleto.getTitulo();
      LocalDate vencimento = titulo.getVencimento();
      FatorDeVencimento fatorDeVencimento = new FatorDeVencimento(vencimento);

      SeqNum seqNum = SeqNum.builder()

          .col("Banco")
          .at(1, 3).integer(341)

          .col("Moeda")
          .at(4, 4).integer(9)

          .col("DAC")
          .at(5, 5).integer(0)

          .col("Fator de Vencimento")
          .at(6, 9).integer(fatorDeVencimento.intValue())

          .col("Valor")
          .at(10, 19).valorFin(titulo.getValor())

          .col("Carteira")
          .at(20, 22).integer(carteira.getCodigo(this))

          .col("Nosso número")
          .at(23, 30).hasIntValue(nossoNumero)

          .col("DAC [Agência/Conta/Carteira/Nosso Número]")
          .at(31, 31).checkDigit(Modulos.MODULO_10)
          .of("Agência", "Conta Corrente", "Carteira", "Nosso número")

          .col("Agência")
          .at(32, 35).hasIntValue(agencia)

          .col("Conta Corrente")
          .at(36, 40).hasIntValue(numero)

          .col("DAC [Agência/Conta Corrente]")
          .at(41, 41).checkDigit(Modulos.MODULO_10)
          .of("Agência", "Conta Corrente")

          .col("Zeros")
          .at(42, 44).integer(0)

          .build();

      return CodigoDeBarras.of(seqNum);
    }

  };

  private static final Map<Integer, BoletoBanco> codigoMap = newHashMap();

  static {
    for (BoletoBanco boletoBanco : BoletoBanco.values()) {
      int codigo = boletoBanco.getCodigo();
      codigoMap.put(codigo, boletoBanco);
    }
  }

  private final int codigo;
  private final int digito;

  private BoletoBanco(int codigo, int digito) {
    this.codigo = codigo;
    this.digito = digito;
  }

  public static BoletoBanco valueOf(int codigo) {
    BoletoBanco boletoBanco = BoletoBanco.BRADESCO;

    if (codigoMap.containsKey(codigo)) {
      boletoBanco = codigoMap.get(codigo);
    }

    return boletoBanco;
  }

  int getCodigo() {
    return codigo;
  }

  int getDigito() {
    return digito;
  }

  String getNumero() {
    return String.format("%d-%d", codigo, digito);
  }

  abstract String getNome();

  abstract CodigoDeBarras codigoDeBarrasDe(Boleto boleto);

}