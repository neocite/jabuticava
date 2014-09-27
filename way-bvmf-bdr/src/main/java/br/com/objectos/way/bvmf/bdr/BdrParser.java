/*
 * Copyright 2014 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.bvmf.bdr;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BdrParser {

  private final Element div;
  private final BdrLink bdrLink;

  public BdrParser(Document doc, BdrLink bdrLink) {
    this.div = doc.getElementById("colunaCentral");
    this.bdrLink = bdrLink;
  }

  public List<Bdr> get() {
    Iterator<String> negociaoIt = negociaoIterator();
    Iterator<String> isinIt = isinIterator();

    return buildBdrs(negociaoIt, isinIt);
  }

  private Iterator<String> negociaoIterator() {
    Elements anchorsNegociacao = div.select(".LinkCodNeg");

    Iterable<String> lazyNegociacoes;
    lazyNegociacoes = Iterables.transform(anchorsNegociacao, new ToSetNegociacao());

    Set<String> negociacoes;
    negociacoes = ImmutableSet.copyOf(lazyNegociacoes);

    return negociacoes.iterator();
  }

  private Iterator<String> isinIterator() {
    Elements anchorsIsin = div.select("#divCodigosOculto td");
    String element = anchorsIsin.get(3).text();

    Iterable<String> lazyIsins = Splitter.on(",")
        .trimResults()
        .split(element);

    Set<String> isins;
    isins = ImmutableSet.copyOf(lazyIsins);

    return isins.iterator();
  }

  private List<Bdr> buildBdrs(Iterator<String> negociaoIt, Iterator<String> isinIt) {
    Builder<Bdr> bdrs = ImmutableList.<Bdr> builder();

    while (negociaoIt.hasNext() && isinIt.hasNext()) {
      String codigoNegociacao = negociaoIt.next();
      String codigoIsin = isinIt.next();

      Bdr bdr;
      bdr = new Construtor(codigoNegociacao, codigoIsin).novaInstancia();
      bdrs.add(bdr);
    }

    return bdrs.build();
  }

  private class ToSetNegociacao implements Function<Element, String> {
    @Override
    public String apply(Element input) {
      return input.text();
    }
  }

  private class Construtor implements Bdr.Construtor {

    private final String codigoNegociacao;
    private final String codigoIsin;

    public Construtor(String codigoNegociacao, String codigoIsin) {
      this.codigoNegociacao = codigoNegociacao;
      this.codigoIsin = codigoIsin;
    }

    @Override
    public Bdr novaInstancia() {
      return new BdrPojo(this);
    }

    @Override
    public String getCodigoDeNegocicao() {
      return codigoNegociacao;
    }

    @Override
    public String getCodigoIsin() {
      return codigoIsin;
    }

    @Override
    public BdrCategoria getCategoria() {
      return bdrLink.getCategoria();
    }

  }

}