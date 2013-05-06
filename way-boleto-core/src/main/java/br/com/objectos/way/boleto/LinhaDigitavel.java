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

import static java.util.Arrays.copyOfRange;
import br.com.objectos.way.base.SeqNum;

import com.google.common.base.Preconditions;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class LinhaDigitavel {

  private final SeqNum seqNum;

  public LinhaDigitavel(SeqNum seqNum) {
    this.seqNum = seqNum;
  }

  public static LinhaDigitavel of(CodigoDeBarras codigo) {
    SeqNum codigoNum = codigo.getSeqNum();
    int[] barras = codigoNum.toArray();
    Preconditions.checkArgument(barras.length == 44);

    SeqNum seqNum = SeqNum.builder()

        .col("Banco")
        .at(1, 3).intArray(copyOfRange(barras, 0, 3))

        .col("Moeda")
        .at(4, 4).intArray(copyOfRange(barras, 3, 4))

        .col("Carteira")
        .at(5, 7).intArray(copyOfRange(barras, 19, 22))

        .col("Nosso número (1)")
        .at(8, 9).intArray(copyOfRange(barras, 22, 24))

        .col("Campo 1 (DAC)")
        .at(10, 10).checkDigit(Modulos.MODULO_10)
        .of("Banco", "Moeda", "Carteira", "Nosso número (1)")

        .col("Campo 2")
        .at(11, 20).intArray(copyOfRange(barras, 24, 34))

        .col("Campo 2 (DAC)")
        .at(21, 21).checkDigit(Modulos.MODULO_10)
        .of("Campo 2")

        .col("Campo 3")
        .at(22, 31).intArray(copyOfRange(barras, 34, 44))

        .col("Campo 3 (DAC)")
        .at(32, 32).checkDigit(Modulos.MODULO_10)
        .of("Campo 3")

        .col("Campo 4")
        .at(33, 33).intArray(copyOfRange(barras, 4, 5))

        .col("Campo 5-0")
        .at(34, 37).intArray(copyOfRange(barras, 5, 9))

        .col("Campo 5-1")
        .at(38, 47).intArray(copyOfRange(barras, 9, 19))

        .build();

    return new LinhaDigitavel(seqNum);
  }

  @Override
  public String toString() {
    String raw = seqNum.toString();
    StringBuilder res = new StringBuilder(raw);
    res.insert(5, ".");
    res.insert(11, " ");
    res.insert(17, ".");
    res.insert(24, " ");
    res.insert(30, ".");
    res.insert(37, " ");
    res.insert(39, " ");
    return res.toString();
  }

}