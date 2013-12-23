/*
 * MustacheTipo.java criado em 20/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ContextDuplicataTipo {

  private final DuplicataTipo tipo;

  public ContextDuplicataTipo(DuplicataTipo tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return tipo.getDescricao();
  }

}