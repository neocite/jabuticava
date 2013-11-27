/*
 * LancamentoContmatic.java criado em 09/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static br.com.objectos.way.cmatic.WayCMatic.toTxtPart;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class LancamentoSimples {

  public static interface Construtor {

    int getNumero();

    LocalDate getData();

    ContaReduzida getDebito();

    ContaReduzida getCredito();

    double getValor();

    HistoricoPadrao getHistoricoPadrao();

    ContaCentroCusto getCcdb();
    ContaCentroCusto getCcdr();

  }

  private final int numero;
  private final LocalDate data;
  private final ContaReduzida debito;
  private final ContaReduzida credito;
  private final double valor;
  private final HistoricoPadrao historicoPadrao;
  private final ContaCentroCusto ccdb;
  private final ContaCentroCusto ccdr;

  private LancamentoSimples(Construtor construtor) {
    numero = construtor.getNumero();
    data = construtor.getData();
    debito = construtor.getDebito();
    credito = construtor.getCredito();
    valor = construtor.getValor();
    historicoPadrao = construtor.getHistoricoPadrao();
    ccdb = construtor.getCcdb();
    ccdr = construtor.getCcdr();
  }

  public static LancamentoSimples of(Construtor construtor) {
    return new LancamentoSimples(construtor);
  }

  String toTxt() {
    return new StringBuilder()
        .append(toTxtPart("%07d", numero, 7))
        .append(data.toString("dd/MM"))
        .append(debito)
        .append(credito)
        .append(toTxtPart("%-17.2f", valor, 17))
        .append(historicoPadrao.toLancamentoTxt())
        .append(ccdb.toLancamentoTxt())
        .append(ccdr.toLancamentoTxt())
        .toString();
  }

}