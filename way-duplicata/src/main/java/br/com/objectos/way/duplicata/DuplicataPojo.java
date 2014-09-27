/*
 * DuplicataPojo.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class DuplicataPojo implements Duplicata {

  private final DuplicataTipo tipo;
  private final DuplicataCedente cedente;
  private final DuplicataSacado sacado;
  private final Fatura fatura;
  private final DuplicataTitulo titulo;

  public DuplicataPojo(Construtor construtor) {
    tipo = construtor.getTipo();
    cedente = construtor.getCedente();
    sacado = construtor.getSacado();
    fatura = construtor.getFatura();
    titulo = construtor.getTitulo();
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