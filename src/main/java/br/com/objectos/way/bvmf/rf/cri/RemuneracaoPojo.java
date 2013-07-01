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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class RemuneracaoPojo implements Remuneracao {

  private final boolean participacaoLucro;
  private final String taxaJuros;
  private final String pagamento;
  private final double premio;

  public RemuneracaoPojo(Construtor construtor) {
    participacaoLucro = construtor.isParticipacaoLucro();
    taxaJuros = construtor.getTaxaJuros();
    pagamento = construtor.getPagamento();
    premio = construtor.getPremio();
  }

  public boolean isParticipacaoLucro() {
    return participacaoLucro;
  }

  @Override
  public String getTaxaJuros() {
    return taxaJuros;
  }

  @Override
  public String getPagamento() {
    return pagamento;
  }

  @Override
  public double getPremio() {
    return premio;
  }

}