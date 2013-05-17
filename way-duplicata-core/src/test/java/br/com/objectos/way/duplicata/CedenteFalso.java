/*
 * CedenteFalso.java criado em 07/05/2013
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
public class CedenteFalso implements DuplicataCedente {

  @Override
  public String getNome() {
    return "Meu Nome Fantasia";
  }

  @Override
  public String getRazaoSocial() {
    return "Minha razão social";
  }

  @Override
  public String getTelefone() {
    return "11 3333-3333";
  }

  @Override
  public String getSite() {
    return "www.meusite.com.br";
  }

  @Override
  public CadastroRFB getCadastroRFB() {
    return Cnpj.valueOf("13674724000162");
  }

  @Override
  public String getEndereco() {
    return "Rua x csdfdf";
  }

  @Override
  public String getBairro() {
    return "Centro";
  }

  @Override
  public Cep getCep() {
    return Cep.valueOf("04512-012");
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