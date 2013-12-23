/*
 * StylesGuice.java criado em 07/05/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.duplicata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.lesscss.LessCompiler;

import br.com.objectos.comuns.base.cache.CacheBuilder;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.google.inject.Inject;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class StylesGuice implements Styles {

  private final LoadingCache<Boolean, String> cssCache;
  private final LoadingCache<Boolean, String> inlineCache;

  @Inject
  public StylesGuice(CacheBuilder cacheBuilder) {
    this.cssCache = cacheBuilder
        .maximumSize(1)
        .build(new CssLoader());
    this.inlineCache = cacheBuilder
        .maximumSize(1)
        .build(new InlineLoader());
  }

  @Override
  public String css() {
    return cssCache.getUnchecked(Boolean.TRUE);
  }

  @Override
  public String inline() {
    return inlineCache.getUnchecked(Boolean.TRUE);
  }

  private class CssLoader extends CacheLoader<Boolean, String> {

    @Override
    public String load(Boolean key) throws Exception {
      File dir = Files.createTempDir();

      copy(dir, "bootstrap-mixins.less");
      copy(dir, "bootstrap-variables.less");
      copy(dir, "obj-type.less");
      copy(dir, "way-duplicata.less");

      File less = copy(dir, "way-duplicata-deps.less");
      return new LessCompiler().compile(less);
    }

    private File copy(File dir, String name) throws IOException {
      URL url = Resources.getResource(Styles.class, String.format("/style/%s", name));
      File dest = new File(dir, name);
      FileOutputStream out = new FileOutputStream(dest);
      Resources.copy(url, out);
      return dest;
    }

  }

  private class InlineLoader extends CacheLoader<Boolean, String> {

    @Override
    public String load(Boolean key) throws Exception {
      StringBuilder res = new StringBuilder();

      res.append("<style type=\"text/css\">");
      res.append("\r\n");

      String css = cssCache.getUnchecked(key);
      res.append(css);
      res.append("\r\n");

      res.append("</style>");

      return res.toString();
    }

  }

}