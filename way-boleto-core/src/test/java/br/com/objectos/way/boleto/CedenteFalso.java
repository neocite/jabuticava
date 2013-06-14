/*
 * CedentePojo.java criado em 02/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

import br.com.objectos.comuns.base.br.Cnpj;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class CedenteFalso implements BoletoCedente {

  @Override
  public String getNome() {
    return "Cedente XYZ";
  }

  @Override
  public long getNumeroConvenio() {
    return 125;
  }

  @Override
  public Cnpj getCnpj() {
    return Cnpj.valueOf("62.703.768/0001-89");
  }

}