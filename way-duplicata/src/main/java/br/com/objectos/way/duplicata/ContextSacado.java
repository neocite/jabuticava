/*
 * MustacheSacado.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Cep;
import br.com.objectos.way.base.br.Estado;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class ContextSacado {

  private final DuplicataSacado sacado;

  public ContextSacado(DuplicataSacado sacado) {
    this.sacado = sacado;
  }

  public String getNome() {
    return sacado.getNome();
  }

  public CadastroRFB getCadastroRFB() {
    return sacado.getCadastroRFB();
  }

  public String getEndereco() {
    return sacado.getEndereco();
  }

  public String getBairro() {
    return sacado.getBairro();
  }

  public Cep getCep() {
    return sacado.getCep();
  }

  public String getCidade() {
    return sacado.getCidade();
  }

  public Estado getEstado() {
    return sacado.getEstado();
  }

}