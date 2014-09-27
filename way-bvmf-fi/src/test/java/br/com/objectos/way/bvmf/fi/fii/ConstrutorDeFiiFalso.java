/*
 * ConstrutorDeFiiFalso.java criado em 02/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import br.com.objectos.way.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class ConstrutorDeFiiFalso implements Fii.Construtor {

  private String codigo;

  private String nome;

  private Cnpj cnpj;

  private FiiEmissao emissao;

  @Override
  public Fii novaInstancia() {
    return new FiiPojo(this);
  }

  public ConstrutorDeFiiFalso codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

  public ConstrutorDeFiiFalso nome(String nome) {
    this.nome = nome;
    return this;
  }

  public ConstrutorDeFiiFalso cnpj(Cnpj cnpj) {
    this.cnpj = cnpj;
    return this;
  }

  public ConstrutorDeFiiFalso emissao(FiiEmissao emissao) {
    this.emissao = emissao;
    return this;
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