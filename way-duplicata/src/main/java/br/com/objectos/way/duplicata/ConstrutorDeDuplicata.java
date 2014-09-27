/*
 * ConstrutorDeDuplicata.java criado em 06/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ConstrutorDeDuplicata implements Duplicata.Construtor {

  private DuplicataTipo tipo;
  private DuplicataCedente cedente;
  private DuplicataSacado sacado;
  private Fatura fatura;
  private DuplicataTitulo titulo;

  @Override
  public Duplicata novaInstancia() {
    return new DuplicataPojo(this);
  }

  public ConstrutorDeDuplicata tipo(DuplicataTipo tipo) {
    this.tipo = tipo;
    return this;
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

  public ConstrutorDeDuplicata titulo(DuplicataTitulo titulo) {
    this.titulo = titulo;
    return this;
  }

  @Override
  public DuplicataTipo getTipo() {
    return tipo;
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

}