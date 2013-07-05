/*
 * CedentePojo.java criado em 02/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import br.com.objectos.comuns.base.br.Cep;
import br.com.objectos.comuns.base.br.Cnpj;
import br.com.objectos.comuns.base.br.Estado;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class CedenteFalso implements BoletoCedente {

  @Override
  public String getNome() {
    return "Beneficiário XYZ";
  }

  @Override
  public long getNumeroConvenio() {
    return 125;
  }

  @Override
  public Cnpj getCnpj() {
    return Cnpj.valueOf("62.703.768/0001-89");
  }

  @Override
  public String getEndereco() {
    return "Av. Jabaquara, 1";
  }

  @Override
  public String getBairro() {
    return "Jabaquara";
  }

  @Override
  public Cep getCep() {
    return Cep.valueOf("04046-200");
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