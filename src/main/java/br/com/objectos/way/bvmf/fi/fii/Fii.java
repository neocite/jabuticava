/*
 * Fii.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

import br.com.objectos.comuns.base.br.Cnpj;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public interface Fii {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Fii> {

    String getCodigo();

    String getNome();

    Cnpj getCnpj();

    FiiEmissao getEmissao();

  }

  String getCodigo();

  String getNome();

  Cnpj getCnpj();

  FiiEmissao getEmissao();

}