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
public class ConstrutorDeCriRemuneracaoFalso implements CriRemuneracao.Construtor {

  private boolean participacaoLucro;
  private String taxaJuros;
  private String pagamento;
  private double premio;

  @Override
  public CriRemuneracao novaInstancia() {
    return new CriRemuneracaoPojo(this);
  }

  public ConstrutorDeCriRemuneracaoFalso participacaoLucro(boolean participacaoLucro) {
    this.participacaoLucro = participacaoLucro;
    return this;
  }

  public ConstrutorDeCriRemuneracaoFalso taxaJuros(String taxaJuros) {
    this.taxaJuros = taxaJuros;
    return this;
  }

  public ConstrutorDeCriRemuneracaoFalso pagamento(String pagamento) {
    this.pagamento = pagamento;
    return this;
  }

  public ConstrutorDeCriRemuneracaoFalso premio(double premio) {
    this.premio = premio;
    return this;
  }

  @Override
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