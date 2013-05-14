/*
 * Link.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
interface FiiLink {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<FiiLink> {

    String getCodigo();

    String getHref();

  }

  String getCodigo();

  String getHref();

}