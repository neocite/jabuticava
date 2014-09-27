/*
 * Copyright 2013 Objectos, Fábrica de Software LTDA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.objectos.way.boleto;

import java.io.IOException;
import java.io.StringWriter;

import com.github.mustachejava.Mustache;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
enum Modo {

  HTML {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Boleto boleto) {
      return mustaches.getBoleto();
    }

    @Override
    Object contextsOf(Contexts contexts, Boleto boleto) {
      return contexts.of(boleto);
    }

  },

  HTML_INLINE_CSS {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Boleto boleto) {
      return mustaches.getBoleto();
    }

    @Override
    Object contextsOf(Contexts contexts, Boleto boleto) {
      return contexts.inlineCssOf(boleto);
    }

  },

  HTML_PAGE {

    @Override
    Mustache mustacheOf(Mustaches mustaches, Boleto boleto) {
      return mustaches.getBoletoPage();
    }

    @Override
    Object contextsOf(Contexts contexts, Boleto boleto) {
      return contexts.pageOf(boleto);
    }

  };

  public String toString(BoletoRender render, Boleto boleto) {
    try {
      Mustaches mustaches = render.mustaches();
      Mustache mustache = mustacheOf(mustaches, boleto);
      StringWriter writer = new StringWriter();

      Contexts contexts = render.contexts();
      Object context = contextsOf(contexts, boleto);
      mustache.execute(writer, context).close();
      return writer.toString();
    } catch (IOException e) {
      return "";
    }
  }

  abstract Mustache mustacheOf(Mustaches mustaches, Boleto boleto);

  abstract Object contextsOf(Contexts contexts, Boleto boleto);

}