/*
 * DuplicataRenderGuice.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class DuplicataRenderGuice implements DuplicataRender {

  private final Contexts contexts;

  private final Mustaches mustaches;

  @Inject
  public DuplicataRenderGuice(Contexts contexts, Mustaches mustaches) {
    this.contexts = contexts;
    this.mustaches = mustaches;
  }

  @Override
  public Contexts contexts() {
    return contexts;
  }

  @Override
  public Mustaches mustaches() {
    return mustaches;
  }

}