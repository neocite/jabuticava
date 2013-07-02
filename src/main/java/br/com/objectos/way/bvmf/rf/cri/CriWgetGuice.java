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
package br.com.objectos.way.bvmf.rf.cri;

import static com.google.common.collect.Lists.transform;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CriWgetGuice implements CriWget {

  private static final Logger logger = LoggerFactory.getLogger(CriWget.class);

  private final ExecutorService executor;

  private final CriForm form;

  @Inject
  public CriWgetGuice(CriForm form) {
    int cpus = Runtime.getRuntime().availableProcessors();
    this.executor = Executors.newFixedThreadPool(cpus * 4);
    this.form = form;
  }

  @Override
  public List<Cri> connect() {
    try {
      Document doc = form.post();

      List<CriLink> links;
      links = new ListagemParser(doc).get();

      List<Future<Cri>> lazyFutures;
      lazyFutures = transform(links, new ToFuture());

      List<Future<Cri>> futures;
      futures = ImmutableList.copyOf(lazyFutures);

      List<Cri> cris;
      cris = transform(futures, new ToCri());

      return ImmutableList.copyOf(cris);
    } catch (IOException e) {
      return ImmutableList.of();
    }
  }

  private class ToFuture implements Function<CriLink, Future<Cri>> {
    @Override
    public Future<Cri> apply(CriLink link) {
      Get get = new Get(link);
      return executor.submit(get);
    }
  }

  private class ToCri implements Function<Future<Cri>, Cri> {
    @Override
    public Cri apply(Future<Cri> future) {
      try {
        return future.get();
      } catch (InterruptedException e) {
        return new CriErro();
      } catch (ExecutionException e) {
        return new CriErro();
      }
    }
  }

  private static class Get implements Callable<Cri> {

    private final CriLink link;

    public Get(CriLink link) {
      this.link = link;
    }

    @Override
    public Cri call() throws Exception {
      String href = link.getHref();
      Document doc = Jsoup.connect(href).get();
      Cri cri = new CriParser(doc).get();
      CaracteristicaSerie serie = cri.getCaracteristicaSerie();
      logger.info("got :<< {}", serie != null ? serie.getCodigoTitulo() : "");
      return cri;
    }

  }

}