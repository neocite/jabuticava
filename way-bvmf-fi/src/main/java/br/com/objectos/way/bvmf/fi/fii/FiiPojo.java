/*
 * FiiPojo.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import br.com.objectos.way.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiPojo implements Fii {

  private final String codigo;
  private final String nome;
  private final Cnpj cnpj;
  private final FiiEmissao emissao;

  public FiiPojo(Construtor construtor) {
    codigo = construtor.getCodigo();
    nome = construtor.getNome();
    cnpj = construtor.getCnpj();
    emissao = construtor.getEmissao();
  }

  @Override
  public String getCodigo() {
    return codigo;
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public Cnpj getCnpj() {
    return cnpj;
  }

  @Override
  public FiiEmissao getEmissao() {
    return emissao;
  }

}