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
package br.com.objectos.way.cnab;

import java.util.List;

import org.joda.time.LocalDate;

import br.com.objectos.way.cnab.remessa.Agencia;
import br.com.objectos.way.cnab.remessa.Cobranca;
import br.com.objectos.way.cnab.remessa.Conta;
import br.com.objectos.way.cnab.remessa.Empresa;

/**
 * @author marcos.piazzolla@objectos.com.br (Marcos Piazzolla)
 */
public interface RemessaBuilder {

  RemessaBuilder empresa(Empresa empresa);

  RemessaBuilder agencia(Agencia agencia);

  RemessaBuilder conta(Conta conta);

  RemessaBuilder dataArquivo(LocalDate dataArquivo);

  RemessaBuilder sequenciaArquivo(int sequenciaArquivo);

  RemessaBuilder cobrancas(List<Cobranca> cobrancas);

  @Override
  String toString();

}