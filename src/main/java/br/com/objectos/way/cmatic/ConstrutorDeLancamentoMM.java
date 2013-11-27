/*
 * ConstrutorDeBloco.java criado em 27/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.joda.time.LocalDate;

import br.com.objectos.comuns.base.Construtor;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class ConstrutorDeLancamentoMM implements LancamentoMM.Construtor, Construtor<LancamentoMM> {

  private final int codigo;
  private final LocalDate data;
  private double valorCredito;
  private double valorDebito;
  private final List<SubLancamento> lancamentos = newArrayList();

  ConstrutorDeLancamentoMM(int codigo, LocalDate data) {
    this.codigo = codigo;
    this.data = data;
  }

  @Override
  public LancamentoMM novaInstancia() {
    Preconditions.checkArgument(valorCredito == valorDebito,
        "Diferença contábil: valores de débito e crédito não são iguais.");
    return LancamentoMM.of(this);
  }

  public ConstrutorDeLancamentoMM add(SubLancamento lancamento) {
    valorCredito += lancamento.getValorCredito();
    valorDebito += lancamento.getValorDebito();
    lancamentos.add(lancamento);
    return this;
  }

  @Override
  public int getNumero() {
    return codigo;
  }

  @Override
  public LocalDate getData() {
    return data;
  }

  @Override
  public double getValor() {
    return valorCredito;
  }

  @Override
  public List<SubLancamento> getLancamentos() {
    return ImmutableList.copyOf(lancamentos);
  }

}