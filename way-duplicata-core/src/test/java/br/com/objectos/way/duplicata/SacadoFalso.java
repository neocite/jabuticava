/*
 * SacadoFalso.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import br.com.objectos.comuns.base.br.CadastroRFB;
import br.com.objectos.comuns.base.br.Cep;
import br.com.objectos.comuns.base.br.Cnpj;
import br.com.objectos.comuns.base.br.Estado;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class SacadoFalso implements DuplicataSacado {

  @Override
  public String getNome() {
    return "Empresa LTDA";
  }

  @Override
  public CadastroRFB getCadastroRFB() {
    return Cnpj.valueOf("57336483000117");
  }

  @Override
  public String getEndereco() {
    return "Rua com número, 2150";
  }

  @Override
  public String getBairro() {
    return "Paraíso";
  }

  @Override
  public Cep getCep() {
    return Cep.valueOf("01254-012");
  }

  @Override
  public String getCidade() {
    return "São Paulo";
  }

  @Override
  public Estado getEstado() {
    return Estado.SP;
  }

}