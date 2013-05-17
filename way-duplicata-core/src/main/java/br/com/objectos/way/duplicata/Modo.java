/*
 * Modo.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.IOException;
import java.io.StringWriter;

import com.github.mustachejava.Mustache;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
enum Modo {

  HTML {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Duplicata duplicata) {
      return mustaches.getDuplicata();
    }

    @Override
    Object contextsOf(Contexts contexts, Duplicata duplicata) {
      return contexts.of(duplicata);
    }

  },

  HTML_INLINE_CSS {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Duplicata duplicata) {
      return mustaches.getDuplicata();
    }

    @Override
    Object contextsOf(Contexts contexts, Duplicata duplicata) {
      return contexts.inlineCssOf(duplicata);
    }

  },

  HTML_PAGE {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Duplicata duplicata) {
      return mustaches.getDuplicataPage();
    }

    @Override
    Object contextsOf(Contexts contexts, Duplicata duplicata) {
      return contexts.pageOf(duplicata);
    }

  };

  public String toString(DuplicataRender render, Duplicata duplicata) {
    try {
      Mustaches mustaches = render.mustaches();
      Mustache mustache = mustacheOf(mustaches, duplicata);
      StringWriter writer = new StringWriter();

      Contexts contexts = render.contexts();
      Object context = contextsOf(contexts, duplicata);
      mustache.execute(writer, context).close();
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  abstract Mustache mustacheOf(Mustaches mustaches, Duplicata duplicata);

  abstract Object contextsOf(Contexts contexts, Duplicata duplicata);

}