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
package br.com.objectos.way.cmatic;

import static com.google.common.collect.Lists.transform;

import java.util.List;

import javax.annotation.concurrent.NotThreadSafe;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
@NotThreadSafe
public class PlanoDeContas {

  interface CMatic {
    List<ContaContabil> getContas();
  }

  private final List<ContaContabil> contas;

  private String txt;

  private PlanoDeContas(CMatic cmatic) {
    this.contas = cmatic.getContas();
  }

  static PlanoDeContas of(CMatic cmatic) {
    return new PlanoDeContas(cmatic);
  }

  public final String getNome() {
    return "Plcontas.txt";
  }

  public String toTxt() {
    if (txt == null) {
      List<String> lines = toLines();
      txt = Joiner.on("\r\n").join(lines);
    }
    return txt;
  }

  private List<String> toLines() {
    List<String> lines = transform(contas, ContaContabilToTxt.INSTANCE);
    return ImmutableList.copyOf(lines);
  }

  private static enum ContaContabilToTxt implements Function<ContaContabil, String> {
    INSTANCE;
    @Override
    public String apply(ContaContabil cc) {
      return cc.toPlanoDeContasTxt();
    }
  }

}