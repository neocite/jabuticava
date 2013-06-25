/*
 * CaracteristicaSerie.java criado em 26/06/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.base;

import org.joda.time.LocalDate;

import com.google.common.base.Optional;

/**
 * @author anderson.silva@objectos.com.br (Anderson Silva)
 */
public interface CaracteristicaSerie {

  interface Construtor extends br.com.objectos.comuns.base.Construtor<CaracteristicaSerie> {

    String getCodigoTitulo();

    String getCodigoIsin();

    int getQuantidadeCri();

    int getNumeroSerie();

    LocalDate getDataEmissao();

    LocalDate getDataVencimento();

    double getVolumeSerie();

    String getAtualizacao();

    Optional<String> getGarantia();

    Optional<LocalDate> getProximaRepactuacao();

    Optional<LocalDate> getUltimaRepactuacao();

    String getAmortizacao();

    String getAgenteFiduciario();

    String getEnquadraArtUm();

    String getEnquadraArtDois();
  }

  int getId();

  String getCodigoTitulo();

  String getCodigoIsin();

  int getQuantidadeCri();

  int getNumeroSerie();

  LocalDate getDataEmissao();

  LocalDate getDataVencimento();

  double getVolumeSerie();

  String getAtualizacao();

  Optional<String> getGarantia();

  Optional<LocalDate> getProximaRepactuacao();

  Optional<LocalDate> getUltimaRepactuacao();

  String getAmortizacao();

  String getAgenteFiduciario();

  String getEnquadraArtUm();

  String getEnquadraArtDois();

}