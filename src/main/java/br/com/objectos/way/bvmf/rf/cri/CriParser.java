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

import org.jsoup.nodes.Document;

/**
 * @author carolene.bertoldi@objectos.com.br (Carolene Bertoldi)
 */
class CriParser {

  private final Document doc;

  public CriParser(Document doc) {
    this.doc = doc;
  }

  public Cri get() {
    CriTableMap tableMap = new CriTableMapGen(doc).get();
    return new Construtor(tableMap).novaInstancia();
  }

  private class Construtor implements Cri.Contrutor {

    private final CriTableMap tableMap;

    public Construtor(CriTableMap tableMap) {
      this.tableMap = tableMap;
    }

    @Override
    public Cri novaInstancia() {
      return new CriPojo(this);
    }

    @Override
    public Emissor getEmissor() {
      CriMap map = tableMap.get("Emissor");
      return new EmissorParser(map).novaInstancia();
    }

    @Override
    public CaracteristicaEmissao getCaracteristicaEmissao() {
      CriMap map = tableMap.get("Características da Emissão");
      return new CaracteristicaEmissaoParser(map).novaInstancia();
    }

    @Override
    public CaracteristicaSerie getCaracteristicaSerie() {
      CriMap map = tableMap.get("Características da Série");
      return new CaracteristicaSerieParser(map).novaInstancia();
    }

    @Override
    public Remuneracao getRemuneracao() {
      CriMap map = tableMap.get("Remuneração");
      return new RemuneracaoParser(map).novaInstancia();
    }

    @Override
    public InformacoesRelacionadas getInformacoesRelacionadas() {
      CriMap map = tableMap.get("Informações relacionadas");
      return new InformacoesRelacionadasParser(map).novaInstancia();
    }

  }

}