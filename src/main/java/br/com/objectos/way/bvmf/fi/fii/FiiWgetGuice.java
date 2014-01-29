/*
 * FiiWgetGuice.java criado em 25/04/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.bvmf.fi.fii;

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
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class FiiWgetGuice implements FiiWget {

  private static final Logger logger = LoggerFactory.getLogger(FiiWget.class);

  private final ExecutorService executor;

  private final FiiUrl url;

  @Inject
  public FiiWgetGuice(FiiUrl url) {
    this.executor = WayExecutors.newCoreSizedNamed(4, "fii-wget");
    this.url = url;
  }

  @Override
  public List<Fii> connect() {
    try {
      String _url = url.get();
      Document doc = Jsoup.connect(_url).get();

      List<FiiLink> links;
      links = new ListagemParser(doc).get();

      List<Future<Fii>> lazyFutures;
      lazyFutures = transform(links, new ToFuture());

      List<Future<Fii>> futures;
      futures = ImmutableList.copyOf(lazyFutures);

      List<Fii> fiis;
      fiis = transform(futures, new ToFii());

      return ImmutableList.copyOf(fiis);
    } catch (IOException e) {
      return ImmutableList.of();
    }
  }

  private class ToFuture implements Function<FiiLink, Future<Fii>> {
    @Override
    public Future<Fii> apply(FiiLink link) {
      Get get = new Get(link);
      return executor.submit(get);
    }
  }

  private class ToFii implements Function<Future<Fii>, Fii> {
    @Override
    public Fii apply(Future<Fii> future) {
      try {
        return future.get();
      } catch (InterruptedException e) {
        return new FiiErro();
      } catch (ExecutionException e) {
        return new FiiErro();
      }
    }
  }

  private static class Get implements Callable<Fii> {

    private final FiiLink link;

    public Get(FiiLink link) {
      this.link = link;
    }

    @Override
    public Fii call() throws Exception {
      String href = link.getHref();
      Document doc = Jsoup.connect(href).get();
      Fii fii = new FiiParser(doc).get();
      logger.info("got :<< {}", fii.getNome());
      return fii;
    }

  }

}