/*
 * DuplicataPojo.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class DuplicataPojo implements Duplicata {

  private final DuplicataCedente cedente;
  private final DuplicataSacado sacado;
  private final Fatura fatura;
  private final DuplicataTitulo titulo;
  private final String valorPorExtenso;
  private final LocalDate dataDoAceite;

  public DuplicataPojo(Construtor construtor) {
    cedente = construtor.getCedente();
    sacado = construtor.getSacado();
    fatura = construtor.getFatura();
    titulo = construtor.getTitulo();
    valorPorExtenso = construtor.getValorPorExtenso();
    dataDoAceite = construtor.getDataDoAceite();
  }

  @Override
  public DuplicataCedente getCedente() {
    return cedente;
  }

  @Override
  public DuplicataSacado getSacado() {
    return sacado;
  }

  @Override
  public Fatura getFatura() {
    return fatura;
  }

  @Override
  public DuplicataTitulo getTitulo() {
    return titulo;
  }

  @Override
  public String getValorPorExtenso() {
    return valorPorExtenso;
  }

  @Override
  public LocalDate getDataDoAceite() {
    return dataDoAceite;
  }

}