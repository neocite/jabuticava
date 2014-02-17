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

import org.joda.time.LocalDate;

import br.com.objectos.comuns.matematica.financeira.ValorFinanceiro;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MustacheTitulo {

  private final String especie;
  private final String valor;
  private final String desconto;
  private final String emissao;
  private final String vencimento;

  public MustacheTitulo(BoletoTitulo titulo) {
    BoletoEspecie especie = titulo.getEspecie();
    this.especie = especie.getSigla();
    ValorFinanceiro valor = titulo.getValor();
    this.valor = Boletos.toString(valor);
    ValorFinanceiro desconto = titulo.getDesconto();
    this.desconto = Boletos.toString(Boletos.zeroToNull(desconto));
    LocalDate data = titulo.getEmissao();
    this.emissao = Boletos.toString(data);
    data = titulo.getVencimento();
    this.vencimento = Boletos.toString(data);
  }

  public final String getEspecie() {
    return especie;
  }

  public final String getValor() {
    return valor;
  }

  public String getDesconto() {
    return desconto;
  }

  public final String getEmissao() {
    return emissao;
  }

  public final String getVencimento() {
    return vencimento;
  }

}