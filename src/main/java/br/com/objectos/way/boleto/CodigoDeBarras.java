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

import static com.google.common.collect.Lists.transform;
import static java.util.Arrays.copyOfRange;

import java.util.List;

import br.com.objectos.way.barcode.Bar;
import br.com.objectos.way.barcode.Barcode;
import br.com.objectos.way.base.SeqNum;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class CodigoDeBarras {

  private final SeqNum seqNum;

  private CodigoDeBarras(SeqNum seqNum) {
    this.seqNum = seqNum;
  }

  public static CodigoDeBarras of(SeqNum seqNum) {
    int[] original = seqNum.toArray();
    Preconditions.checkArgument(original.length == 44);

    SeqNum codigoBarras = SeqNum.builder()

        .col("header")
        .at(1, 4).intArray(copyOfRange(original, 0, 4))

        .col("DAC")
        .at(5, 5).checkDigit(Modulos.MODULO_11)
        .of("header", "trailer")

        .col("trailer")
        .at(6, 44).intArray(copyOfRange(original, 5, 44))
        .build();

    return new CodigoDeBarras(codigoBarras);
  }

  public List<MustacheBarra> getBarras() {
    int[] digits = seqNum.toArray();
    Barcode barcode = Barcode
        .encode(digits)
        .asInterleavedTwoFive();

    List<Bar> bars = barcode.getBars();

    List<MustacheBarra> barras;
    barras = transform(bars, new ToMustacheBar());

    return ImmutableList.copyOf(barras);
  }

  public LinhaDigitavel toLinhaDigitavel() {
    return LinhaDigitavel.of(this);
  }

  SeqNum getSeqNum() {
    return seqNum;
  }

  @Override
  public String toString() {
    return seqNum.toString();
  }

  private class ToMustacheBar implements Function<Bar, MustacheBarra> {

    @Override
    public MustacheBarra apply(Bar input) {
      return new MustacheBarra(input);
    }

  }

}