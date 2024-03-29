/*
 * Copyright 2012 Objectos, Fábrica de Software LTDA.
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
package br.com.objectos.way.cnab;

import static br.com.objectos.way.base.br.TipoDeCadastroRFB.CPF;
import static br.com.objectos.way.cnab.Itau.headerRemessa;
import static br.com.objectos.way.cnab.Itau.loteRemessa;
import static br.com.objectos.way.cnab.Itau.trailerRemessa;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

import java.util.List;

import br.com.objectos.way.base.br.CadastroRFB;
import br.com.objectos.way.base.br.Estado;
import br.com.objectos.way.base.br.TipoDeCadastroRFB;
import br.com.objectos.way.cnab.remessa.Agencia;
import br.com.objectos.way.cnab.remessa.Cedente;
import br.com.objectos.way.cnab.remessa.Cobranca;
import br.com.objectos.way.cnab.remessa.CobrancaOpcoes;
import br.com.objectos.way.cnab.remessa.Conta;
import br.com.objectos.way.cnab.remessa.Endereco;
import br.com.objectos.way.cnab.remessa.Instrucao;
import br.com.objectos.way.cnab.remessa.Sacado;
import br.com.objectos.way.cnab.remessa.Titulo;

import com.google.common.base.Function;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauRemessaBuilder extends AbstractRemessaBuilder {

  private int sequencia = 2;

  public ItauRemessaBuilder(Banco banco) {
    super(banco);
  }

  @Override
  protected List<String> build() {
    List<String> lines = newArrayList();

    lines.add(doHeader());

    lines.addAll(doLotes());

    lines.add(doTrailer());

    lines.add(" ");

    return lines;
  }

  private String doHeader() {
    return HeaderRemessa.paraBanco(banco)

        .put(headerRemessa().agencia(), agencia.getCodigo())
        .put(headerRemessa().conta(), conta.getNumero())
        .put(headerRemessa().dac(), conta.getDigito())
        .put(headerRemessa().nomeEmpresa(), empresa.getRazaoSocial())
        .put(headerRemessa().dataGeracao(), dataArquivo)

        .toString();
  }

  private List<String> doLotes() {
    return transform(cobrancas, new CobrancaToString());
  }

  private String doTrailer() {
    return TrailerRemessa.paraBanco(banco)

        .put(trailerRemessa().seqRegistro(), sequencia++)

        .toString();
  }

  private class CobrancaToString implements Function<Cobranca, String> {

    @Override
    public String apply(Cobranca cobranca) {
      Titulo titulo = cobranca.getTitulo();

      ItauInscricao inscricao = ItauInscricao.of(empresa, titulo);
      Agencia agencia = cobranca.getAgencia();
      Conta conta = cobranca.getConta();
      ItauCarteira carteira = new ItauCarteira(cobranca.getCarteira());

      CobrancaOpcoes opcoes = cobranca.getOpcoes();
      Instrucao instrucao1 = opcoes.getInstrucao1();
      Instrucao instrucao2 = opcoes.getInstrucao2();

      int prazo = prazoDe(instrucao1, 0);
      prazo = prazoDe(instrucao2, prazo);

      Cedente cedente = titulo.getCedente();

      Sacado sacado = titulo.getSacado();
      CadastroRFB sacadoCadastro = sacado.getCadastroRFB();
      TipoDeCadastroRFB sacadoTipo = sacadoCadastro.getTipo();

      Endereco endereco = sacado.getEndereco();
      Estado estado = endereco.getEstado();

      return LoteRemessa.paraBanco(banco)

          // cobranca
          .put(loteRemessa().codigoDeInscricao(), inscricao.getTipo())
          .put(loteRemessa().numeroDeInscricao(), inscricao.getCadastro())
          .put(loteRemessa().agencia(), agencia.getCodigo())
          .put(loteRemessa().conta(), conta.getNumero())
          .put(loteRemessa().dac(), conta.getDigito())
          .put(loteRemessa().carteiraNumero(), carteira.getNumero())
          .put(loteRemessa().carteiraCodigo(), carteira.getCodigo())

          .put(loteRemessa().comando(), cobranca.getComando())

          // opções
          .put(loteRemessa().aceite(), opcoes.isAceite())
          .put(loteRemessa().instrucao1(), instrucao1.getCodigo())
          .put(loteRemessa().instrucao2(), instrucao2.getCodigo())
          .put(loteRemessa().moraDia(), opcoes.getMoraDia())

          // titulo
          .put(loteRemessa().usoDaEmpresa(), titulo.getUsoDaEmpresa())
          .put(loteRemessa().especie(), titulo.getEspecie())
          .put(loteRemessa().nossoNumero(), titulo.getNossoNumero())
          .put(loteRemessa().numeroDocumento(), titulo.getNumero())
          .put(loteRemessa().emissao(), titulo.getEmissao())
          .put(loteRemessa().vencimento(), titulo.getVencimento())
          .put(loteRemessa().prazo(), prazo)
          .put(loteRemessa().valorTitulo(), titulo.getValor())
          .put(loteRemessa().valorIOF(), titulo.getValorIof())
          .put(loteRemessa().valorDesconto(), titulo.getValorDesconto())
          .put(loteRemessa().valorAbatimento(), titulo.getValorAbatimento())

          // cedente
          .put(loteRemessa().sacadorAvalista(), cedente.getNome())

          // sacado
          .put(loteRemessa().sacadoInscricaoTipo(), CPF.equals(sacadoTipo) ? 1 : 2)
          .put(loteRemessa().sacadoInscricaoNumero(), sacado.getCadastroRFB())
          .put(loteRemessa().sacadoNome(), sacado.getNome())
          .put(loteRemessa().sacadoLogradouro(), endereco.getLogradouro())
          .put(loteRemessa().sacadoBairro(), endereco.getBairro())
          .put(loteRemessa().sacadoCidade(), endereco.getCidade())
          .put(loteRemessa().sacadoEstado(), estado != null ? estado.name() : null)
          .put(loteRemessa().sacadoCep(), endereco.getCep())

          .put(loteRemessa().seqRegistro(), sequencia++)

          .toString();
    }

    private int prazoDe(Instrucao instrucao, int prazo) {
      int codigo = instrucao.getCodigo();
      switch (codigo) {
      case 9:
      case 34:
      case 35:
      case 42:
      case 81:
      case 82:
      case 91:
      case 92:
        return instrucao.intValue();

      default:
        return prazo;
      }
    }

  }

}