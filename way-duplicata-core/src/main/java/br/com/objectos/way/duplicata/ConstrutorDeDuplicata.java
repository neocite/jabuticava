/*
 * ConstrutorDeDuplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ConstrutorDeDuplicata implements Duplicata.Construtor {

  private DuplicataCedente cedente;
  private DuplicataSacado sacado;
  private Fatura fatura;
  private String valorPorExtenso;
  private LocalDate dataDoAceite;

  @Override
  public Duplicata novaInstancia() {
    return new DuplicataPojo(this);
  }

  public ConstrutorDeDuplicata cedente(DuplicataCedente cedente) {
    this.cedente = cedente;
    return this;
  }

  public ConstrutorDeDuplicata sacado(DuplicataSacado sacado) {
    this.sacado = sacado;
    return this;
  }

  public ConstrutorDeDuplicata fatura(Fatura fatura) {
    this.fatura = fatura;
    return this;
  }

  public ConstrutorDeDuplicata valorPorExtenso(String valorPorExtenso) {
    this.valorPorExtenso = valorPorExtenso;
    return this;
  }

  public ConstrutorDeDuplicata dataDoAceite(LocalDate dataDoAceite) {
    this.dataDoAceite = dataDoAceite;
    return this;
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
  public String getValorPorExtenso() {
    return valorPorExtenso;
  }

  @Override
  public LocalDate getDataDoAceite() {
    return dataDoAceite;
  }

}