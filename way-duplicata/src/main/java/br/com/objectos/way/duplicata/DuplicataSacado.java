/*
 * DuplicataSacado.java criado em 07/05/2013
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
public interface DuplicataSacado {

  String getNome();

  CadastroRFB getCadastroRFB();

  String getEndereco();

  String getBairro();

  Cep getCep();

  String getCidade();

  Estado getEstado();

}