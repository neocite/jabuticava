/*
 * MustacheCedente.java criado em 07/05/2013
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
class ContextCedente {

  private final DuplicataCedente cedente;

  public ContextCedente(DuplicataCedente cedente) {
    this.cedente = cedente;
  }

  public String getNome() {
    return cedente.getNome();
  }

  public String getRazaoSocial() {
    return cedente.getRazaoSocial();
  }

  public String getTelefone() {
    return cedente.getTelefone();
  }

  public String getSite() {
    return cedente.getSite();
  }

  public CadastroRFB getCadastroRFB() {
    return cedente.getCadastroRFB();
  }

  public String getEndereco() {
    return cedente.getEndereco();
  }

  public String getBairro() {
    return cedente.getBairro();
  }

  public Cep getCep() {
    return cedente.getCep();
  }

  public String getCidade() {
    return cedente.getCidade();
  }

  public Estado getEstado() {
    return cedente.getEstado();
  }

}