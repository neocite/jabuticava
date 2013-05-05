/*
 * CedentePojo.java criado em 02/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.boleto;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class CedenteFalso implements BoletoCedente {

  @Override
  public String getNome() {
    return "Cedente XYZ";
  }

  @Override
  public long getNumeroConvenio() {
    return 125;
  }

}