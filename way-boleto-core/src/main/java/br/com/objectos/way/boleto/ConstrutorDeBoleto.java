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

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeBoleto implements Boleto.Construtor {

  private BoletoContaBancaria contaBancaria = new BoletoContaBancariaVazio();

  private BoletoCedente cedente;

  private BoletoSacado sacado;

  private BoletoTitulo titulo;

  private BoletoCobranca cobranca;

  @Override
  public Boleto novaInstancia() {
    return new BoletoPojo(this);
  }

  public ConstrutorDeBoleto contaBancaria(BoletoContaBancaria contaBancaria) {
    this.contaBancaria = contaBancaria;
    return this;
  }

  public ConstrutorDeBoleto cedente(BoletoCedente cedente) {
    this.cedente = cedente;
    return this;
  }

  public ConstrutorDeBoleto sacado(BoletoSacado sacado) {
    this.sacado = sacado;
    return this;
  }

  public ConstrutorDeBoleto titulo(BoletoTitulo titulo) {
    this.titulo = titulo;
    return this;
  }

  public ConstrutorDeBoleto cobranca(BoletoCobranca cobranca) {
    this.cobranca = cobranca;
    return this;
  }

  @Override
  public BoletoContaBancaria getContaBancaria() {
    return contaBancaria;
  }

  @Override
  public BoletoCedente getCedente() {
    return cedente;
  }

  @Override
  public BoletoSacado getSacado() {
    return sacado;
  }

  @Override
  public BoletoTitulo getTitulo() {
    return titulo;
  }

  @Override
  public BoletoCobranca getCobranca() {
    return cobranca;
  }

}