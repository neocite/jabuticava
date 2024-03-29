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
package br.com.objectos.way.bvmf.rf.cri;

import br.com.objectos.comuns.base.Construtor;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface Cri {

  interface Contrutor extends Construtor<Cri> {

    CriEmissor getEmissor();

    CriEmissao getEmissao();

    CriSerie getSerie();

    CriRemuneracao getRemuneracao();

    CriInformacoes getInformacoes();

  }

  CriEmissor getEmissor();

  CriEmissao getEmissao();

  CriSerie getSerie();

  CriRemuneracao getRemuneracao();

  CriInformacoes getInformacoes();

}