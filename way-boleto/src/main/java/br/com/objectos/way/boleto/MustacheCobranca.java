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

import java.util.List;

import org.joda.time.LocalDate;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class MustacheCobranca {

  private final String descricao;
  private final String dataProcessamento;
  private final String nossoNumero;
  private final boolean aceite;
  private final List<String> instrucoes;
  private final String informacaoAdicional;
  private final String localPagamento;
  private final String numeroDocumento;

  public MustacheCobranca(BoletoCobranca cobranca) {
    descricao = cobranca.getDescricao();
    LocalDate data = cobranca.getDataProcessamento();
    dataProcessamento = Boletos.toString(data);
    nossoNumero = cobranca.getNossoNumero();
    aceite = cobranca.isAceite();
    instrucoes = cobranca.getInstrucoes();
    informacaoAdicional = cobranca.getInformacaoAdicional();
    localPagamento = cobranca.getLocalPagamento();
    numeroDocumento = cobranca.getNumeroDocumento();

  }

  public String getDescricao() {
    return descricao;
  }

  public String getDataProcessamento() {
    return dataProcessamento;
  }

  public String getNossoNumero() {
    return nossoNumero;
  }

  public String isAceite() {
    return aceite ? "S" : "N";
  }

  public List<String> getInstrucoes() {
    return instrucoes;
  }

  public String getInformacaoAdicional() {
    return informacaoAdicional;
  }

  public String getLocalPagamento() {
    return localPagamento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

}