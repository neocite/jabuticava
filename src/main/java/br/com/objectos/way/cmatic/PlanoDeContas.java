/*
 * PlanoDeContaTxt.java criado em 07/11/2013
 * 
 * Propriedade de Objectos Fábrica de Software LTDA.
 * Reprodução parcial ou total proibida.
 */
package br.com.objectos.way.cmatic;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import br.com.objectos.way.cmatic.ContaContabil.CMatic;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

/**
 * @author edenir.anschau@objectos.com.br (Edenir Norberto Anschau)
 */
public class PlanoDeContas {

  interface Construtor {
    List<ContaContabil> getContas();
  }

  private final List<ContaContabil> contas;

  private PlanoDeContas(Construtor construtor) {
    this.contas = construtor.getContas();
  }

  public final String getNome() {
    return "Plcontas.txt";
  }

  List<String> toLines() {
    List<String> lines = transform(contas, ContaContabilToTxt.INSTANCE);
    return ImmutableList.copyOf(lines);
  }

  String toTxt() {
    List<String> lines = toLines();
    return Joiner.on("\r\n").join(lines);
  }

  public static class ConstrutorDePlanoDeContas
      implements PlanoDeContas.Construtor,
      br.com.objectos.comuns.base.Construtor<PlanoDeContas> {

    private final List<ContaContabil> contas = newArrayList();

    ConstrutorDePlanoDeContas() {
    }

    @Override
    public PlanoDeContas novaInstancia() {
      return new PlanoDeContas(this);
    }

    public ConstrutorDePlanoDeContas add(ContaContabil cc) {
      contas.add(cc);
      return this;
    }

    public ConstrutorDePlanoDeContas addAll(Iterable<? extends ContaContabil.CMatic> contas) {
      for (CMatic cmatic : contas) {
        ContaContabil cc = ContaContabil.of(cmatic);
        this.contas.add(cc);
      }
      return this;
    }

    @Override
    public List<ContaContabil> getContas() {
      return ImmutableList.copyOf(contas);
    }

  }

  private static enum ContaContabilToTxt implements Function<ContaContabil, String> {
    INSTANCE;
    @Override
    public String apply(ContaContabil cc) {
      return cc.toPlanoDeContasTxt();
    }
  }

}