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
public class TituloFalso implements BoletoTitulo {

  @Override
  public BoletoEspecie getEspecie() {
    return BoletoEspecie.DS_DUPLICATA_DE_SERVICO;
  }

  @Override
  public ValorFinanceiro getValor() {
    return new ValorFinanceiroImpl(1500.50);
  }

  @Override
  public LocalDate getEmissao() {
    return new LocalDate(2013, 4, 30);
  }

  @Override
  public LocalDate getVencimento() {
    return new LocalDate(2013, 5, 30);
  }

}