/*
 * LancamentoContmaticTxtPojo.java criado em 21/10/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import org.joda.time.LocalDate;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
class LancamentoTxtPojo extends LancamentoTxt {

  private final String nome;
  private final LocalDate data;
  private final String conteudo;

  public LancamentoTxtPojo(Construtor construtor) {
    nome = construtor.getNome();
    data = construtor.getData();
    conteudo = construtor.getConteudo();
  }

  @Override
  public String getNome() {
    return nome;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public String getConteudo() {
    return conteudo;
  }

}