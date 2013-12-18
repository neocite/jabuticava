/*
 * CaracteristicasFalso.java criado em 24/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.debs.emissao;

import static br.com.objectos.way.io.WayIOFakes.gunzip;

import java.io.File;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
public class CaracteristicasFalso {

  public static final File CARACTERISTICAS_20130424 =
      gunzip(CaracteristicasFalso.class, "/caracteristicas_e.asp.gz");

  public static final File CARACTERISTICAS_20131206 =
      gunzip(CaracteristicasFalso.class, "/caracteristicas_20131206.asp.gz");

  private CaracteristicasFalso() {
  }

}