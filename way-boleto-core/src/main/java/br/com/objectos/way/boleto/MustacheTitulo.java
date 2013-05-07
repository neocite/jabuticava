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

  private final BoletoTitulo titulo;

  public MustacheTitulo(BoletoTitulo titulo) {
    this.titulo = titulo;
  }

  public String getEspecie() {
    BoletoEspecie especie = titulo.getEspecie();
    return especie.getSigla();
  }

  public String getValor() {
    ValorFinanceiro valor = titulo.getValor();
    return Boletos.toString(valor);
  }

  public String getEmissao() {
    LocalDate data = titulo.getEmissao();
    return Boletos.toString(data);
  }

  public String getVencimento() {
    LocalDate data = titulo.getVencimento();
    return Boletos.toString(data);
  }

}