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
package br.com.objectos.comuns.cnab;

/**
 * @author marcio.endo@objectos.com.br (Marcio Endo)
 */
class ItauOcorrencia extends OcorrenciaCodigoPadrao {

  public ItauOcorrencia(int codigo, String descricao, MotivoParser motivoParser) {
    super(codigo, descricao, motivoParser);
  }

  @Override
  Banco getBanco() {
    return Banco.ITAU;
  }

  @Override
  public final OcorrenciaTipo getTipo() {
    // 02 ENTRADA CONFIRMADA
    // 03 ENTRADA REJEITADA (NOTA 20 - TABELA 1)
    // 04 ALTERAÇÃO DE DADOS - NOVA ENTRADA
    // 05 ALTERAÇÃO DE DADOS – BAIXA
    // 06 LIQUIDAÇÃO NORMAL
    // 07 LIQUIDAÇÃO PARCIAL – COBRANÇA INTELIGENTE (B2B)
    // 08 LIQUIDAÇÃO EM CARTÓRIO
    // 09 BAIXA SIMPLES
    // 10 BAIXA POR TER SIDO LIQUIDADO
    // 11 EM SER (SÓ NO RETORNO MENSAL)
    // 12 ABATIMENTO CONCEDIDO
    // 13 ABATIMENTO CANCELADO
    // 14 VENCIMENTO ALTERADO
    // 15 BAIXAS REJEITADAS (NOTA 20 - TABELA 4)
    // 16 INSTRUÇÕES REJEITADAS (NOTA 20 - TABELA 3)
    // 17 ALTERAÇÃO DE DADOS REJEITADOS (NOTA 20 - TABELA 2)
    // 18 COBRANÇA CONTRATUAL - INSTRUÇÕES/ALTERAÇÕES REJEITADAS/PENDENTES (NOTA
    // 20 - TABELA 5)

    // 19 CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE PROTESTO
    // 20 CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE SUSTAÇÃO DE PROTESTO /TARIFA
    // 21 CONFIRMA RECEBIMENTO DE INSTRUÇÃO DE NÃO PROTESTAR
    // 23 TÍTULO ENVIADO A CARTÓRIO/TARIFA
    // 24 INSTRUÇÃO DE PROTESTO REJEITADA / SUSTADA / PENDENTE (NOTA 20 - TABELA
    // 7)

    // 25 ALEGAÇÕES DO SACADO (NOTA 20 - TABELA 6)
    // 26 TARIFA DE AVISO DE COBRANÇA
    // 27 TARIFA DE EXTRATO POSIÇÃO (B40X)
    // 28 TARIFA DE RELAÇÃO DAS LIQUIDAÇÕES
    // 29 TARIFA DE MANUTENÇÃO DE TÍTULOS VENCIDOS
    // 30 DÉBITO MENSAL DE TARIFAS (PARA ENTRADAS E BAIXAS)
    // 32 BAIXA POR TER SIDO PROTESTADO
    // 33 CUSTAS DE PROTESTO
    // 34 CUSTAS DE SUSTAÇÃO
    // 35 CUSTAS DE CARTÓRIO DISTRIBUIDOR
    // 36 CUSTAS DE EDITAL
    // 37 TARIFA DE EMISSÃO DE BOLETO/TARIFA DE ENVIO DE DUPLICATA
    // 38 TARIFA DE INSTRUÇÃO
    // 39 TARIFA DE OCORRÊNCIAS
    // 40 TARIFA MENSAL DE EMISSÃO DE BOLETO/TARIFA MENSAL DE ENVIO DE DUPLICATA
    // 41 DÉBITO MENSAL DE TARIFAS – EXTRATO DE POSIÇÃO (B4EP/B4OX)
    // 42 DÉBITO MENSAL DE TARIFAS – OUTRAS INSTRUÇÕES
    // 43 DÉBITO MENSAL DE TARIFAS – MANUTENÇÃO DE TÍTULOS VENCIDOS
    // 44 DÉBITO MENSAL DE TARIFAS – OUTRAS OCORRÊNCIAS
    // 45 DÉBITO MENSAL DE TARIFAS – PROTESTO
    // 46 DÉBITO MENSAL DE TARIFAS – SUSTAÇÃO DE PROTESTO
    // 47 BAIXA COM TRANSFERÊNCIA PARA DESCONTO
    // 48 CUSTAS DE SUSTAÇÃO JUDICIAL
    // 51 TARIFA MENSAL REF A ENTRADAS BANCOS CORRESPONDENTES NA CARTEIRA
    // 52 TARIFA MENSAL BAIXAS NA CARTEIRA
    // 53 TARIFA MENSAL BAIXAS EM BANCOS CORRESPONDENTES NA CARTEIRA
    // 54 TARIFA MENSAL DE LIQUIDAÇÕES NA CARTEIRA
    // 55 TARIFA MENSAL DE LIQUIDAÇÕES EM BANCOS CORRESPONDENTES NA CARTEIRA
    // 56 CUSTAS DE IRREGULARIDADE
    // 57 INSTRUÇÃO CANCELADA (NOTA 20 – TABELA 8)
    // 59 BAIXA POR CRÉDITO EM C/C ATRAVÉS DO SISPAG
    // 60 ENTRADA REJEITADA CARNÊ (NOTA 20 – TABELA 1)
    // 61 TARIFA EMISSÃO AVISO DE MOVIMENTAÇÃO DE TÍTULOS (2154)
    // 62 DÉBITO MENSAL DE TARIFA - AVISO DE MOVIMENTAÇÃO DE TÍTULOS (2154)
    // 63 TÍTULO SUSTADO JUDICIALMENTE
    // 64 ENTRADA CONFIRMADA COM RATEIO DE CRÉDITO
    // 69 CHEQUE DEVOLVIDO (NOTA 20 - TABELA 9)
    // 71 ENTRADA REGISTRADA, AGUARDANDO AVALIAÇÃO
    // 72 BAIXA POR CRÉDITO EM C/C ATRAVÉS DO SISPAG SEM TÍTULO CORRESPONDENTE
    // 73 CONFIRMAÇÃO DE ENTRADA NA COBRANÇA SIMPLES – ENTRADA NÃO ACEITA NA
    // COBRANÇA CONTRATUAL

    // 76 CHEQUE COMPENSADO
    switch (codigo) {
    case 2:
      return OcorrenciaTipo.ENTRADA_CONFIRMADA;
    case 3:
      return OcorrenciaTipo.ENTRADA_REJEITADA;
    case 6:
      return OcorrenciaTipo.LIQUIDACAO_NORMAL;
    case 14:
      return OcorrenciaTipo.VENCIMENTO_ALTERADO;
    case 19:
      return OcorrenciaTipo.PROTESTO_CONFIRMADO;
    case 33:
      return OcorrenciaTipo.ALTERACAO_OUTROS_DADOS;
    default:
      return OcorrenciaTipo.DESCONHECIDA;
    }
  }

}