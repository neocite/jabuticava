# objectos :: way :: cnab
## Processamento de arquivos CNAB em Java(tm)

objectos way-cnab ([www.objectos.com.br](http://www.objectos.com.br)) 
é uma implementação em Java(tm) da especificação CNAB400 da Febrabran.

Filosofias principais:

- fácil de usar: fluent interfaces
- type safety
- fácil de extender

## Bancos

- Bradesco
- Itaú

## Como usar

Estão implementados tanto o arquivo de retorno, como o arquivo de remessa.

### Retorno

A utilização é razoavelmente simples:

```java
File file = // abrir um retorno BRADESCO, por exemplo.
ArquivoRetorno retorno = Cnab.retornoDe(file);

List<Lote> lotes = retorno.getLotes();
for (Lote lote : lotes) {
  // look ma!!! type safe!!!
  LocalDate vencimento = lote.get(Bradesco.lote().dataDeVencimento()); 
}
```

## Notas

- A implementação está longe de completa. 

## Licença de uso

Copyright 2012 objectos, fábrica de software LTDA

Distributed under the Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0 
