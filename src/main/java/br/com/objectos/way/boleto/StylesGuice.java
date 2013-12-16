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
import com.google.inject.Singleton;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
@Singleton
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
      copy(dir, "way-boleto.less");

      File less = copy(dir, "way-boleto-deps.less");
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