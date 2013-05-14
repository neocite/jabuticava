/*
 * FiiUrlPadrao.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiUrlPadrao implements FiiUrl {
  @Override
  public String get() {
    return "http://www.bmfbovespa.com.br/Fundos-Listados/FundosListados.aspx?tipoFundo=imobiliario&Idioma=pt-br";
  }
}