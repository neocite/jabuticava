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

import static com.google.common.collect.Lists.transform;

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
import com.google.inject.Inject;

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
  public List<BdrStage> connect() {
    try {
      String _url = url.get();
      Document doc = Jsoup.connect(_url).get();

      List<BdrLink> links;
      links = new ListagemParser(doc).get();

      List<Future<BdrStage>> lazyFutures;
      lazyFutures = transform(links, new ToFuture());

      List<Future<BdrStage>> futures;
      futures = ImmutableList.copyOf(lazyFutures);

      List<BdrStage> bdrs;
      bdrs = transform(futures, new ToBdrStage());

      return ImmutableList.copyOf(bdrs);
    } catch (IOException e) {
      return ImmutableList.of();
    }
  }

  private class ToFuture implements Function<BdrLink, Future<BdrStage>> {
    @Override
    public Future<BdrStage> apply(BdrLink link) {
      Get get = new Get(link);
      return executor.submit(get);
    }
  }

  private class ToBdrStage implements Function<Future<BdrStage>, BdrStage> {
    @Override
    public BdrStage apply(Future<BdrStage> future) {
      try {
        return future.get();
      } catch (InterruptedException e) {
        return new BdrErro();
      } catch (ExecutionException e) {
        return new BdrErro();
      }
    }
  }

  private static class Get implements Callable<BdrStage> {

    private final BdrLink bdrLink;

    public Get(BdrLink bdrLink) {
      this.bdrLink = bdrLink;
    }

    @Override
    public BdrStage call() throws Exception {
      String href = bdrLink.getHref();
      Document doc = Jsoup.connect(href).get();
      BdrStage bdr = new BdrParser(doc, bdrLink).get();
      logger.info("got :<< {}", bdr.getCodigoDeNegocicao());
      return bdr;
    }

  }

}