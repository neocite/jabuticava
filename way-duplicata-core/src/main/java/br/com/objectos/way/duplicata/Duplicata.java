/*
 * Duplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public interface Duplicata {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<Duplicata> {

    DuplicataTipo getTipo();

    DuplicataCedente getCedente();

    DuplicataSacado getSacado();

    Fatura getFatura();

    DuplicataTitulo getTitulo();

  }

  DuplicataTipo getTipo();

  DuplicataCedente getCedente();

  DuplicataSacado getSacado();

  Fatura getFatura();

  DuplicataTitulo getTitulo();

}