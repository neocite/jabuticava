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

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.objectos.way.base.util.concurrent.WayExecutors;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import static com.google.common.collect.Lists.transform;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class BdrWgetGuice implements BdrWget {

  private static final Logger logger = LoggerFactory.getLogger(BdrWget.class);

  private final ExecutorService executor;

  private final BrtUrl url;

  @Inject
  public BdrWgetGuice(BrtUrl url) {
    this.executor = WayExecutors.newCoreSizedNamed(4, "bdr-wget");
    this.url = url;
  }

  @Override
  public List<Bdr> connect() {
    try {
      String _url = url.get();
      Document doc = Jsoup.connect(_url).get();

      List<BdrLink> links;
      links = new ListagemParser(doc).get();

      List<Future<Iterable<Bdr>>> lazyFutures;
      lazyFutures = transform(links, new ToFuture());

      List<Future<Iterable<Bdr>>> futures;
      futures = ImmutableList.copyOf(lazyFutures);

      List<Iterable<Bdr>> lazyBdrs;
      lazyBdrs = transform(futures, new ToBdrStage());

      Iterable<Bdr> bdrs;
      bdrs = Iterables.concat(lazyBdrs);

      return ImmutableList.copyOf(bdrs);
    } catch (IOException e) {
      return ImmutableList.of();
    }
  }

  private class ToFuture implements Function<BdrLink,
      Future<Iterable<Bdr>>> {
    @Override
    public Future<Iterable<Bdr>> apply(BdrLink link) {
      Get get = new Get(link);
      return executor.submit(get);
    }
  }

  private class ToBdrStage implements Function<Future<Iterable<Bdr>>,
      Iterable<Bdr>> {
    @Override
    public Iterable<Bdr> apply(Future<Iterable<Bdr>> input) {
      try {
        return input.get();
      } catch (InterruptedException e) {
        return ImmutableList.of();
      } catch (ExecutionException e) {
        return ImmutableList.of();
      }
    }
  }

  private static class Get implements Callable<Iterable<Bdr>> {

    private final BdrLink bdrLink;

    public Get(BdrLink bdrLink) {
      this.bdrLink = bdrLink;
    }

    @Override
    public Iterable<Bdr> call() throws Exception {
      String href = bdrLink.getHref();
      Document doc = Jsoup.connect(href).get();
      Iterable<Bdr> bdrs = new BdrParser(doc, bdrLink).get();
      logger.info("got :<< {}", href);
      return bdrs;
    }

  }

}