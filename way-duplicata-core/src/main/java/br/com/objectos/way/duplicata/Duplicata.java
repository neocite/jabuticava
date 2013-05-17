/*
 * Duplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public interface Duplicata {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Duplicata> {

    DuplicataCedente getCedente();

    DuplicataSacado getSacado();

    Fatura getFatura();

    DuplicataTitulo getTitulo();

    String getValorPorExtenso();

    LocalDate getDataDoAceite();

  }

  DuplicataCedente getCedente();

  DuplicataSacado getSacado();

  Fatura getFatura();

  DuplicataTitulo getTitulo();

  String getValorPorExtenso();

  LocalDate getDataDoAceite();

}