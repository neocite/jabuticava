# objectos :: way :: debentures.com.br

Biblioteca Java (&trade;) para extrair e tratar informações do site debenture.com.br. Simples.

## Can haz code?

### Características das debêntures

```java
Caracteristica caracteristica = Caracteristica.wget(); // download do site debenture.com.br
List<Record> registros = caracteristica.getRegistros();
for (Record registro : registros) {
   String codigo = registro.get(Caracteristica.keys().codigo());
   String serie = registro.get(Caracteristica.keys().serie());
   // etc...
}
```

## Maven

way-debs está na central Maven.

```xml
<dependency>
    <groupId>br.com.objectos</groupId>
    <artifactId>way-debs</artifactId>
    <version>x.y.z</version>
</dependency>
```

## Versões

Estamos trabalhando para atender a especificação SemVer.

Até o lançamento da versão 2.0.0, a API poderá mudar bastante...

# Licença de uso

Copyright 2013 [objectos, fábrica de software LTDA](http://www.objectos.com.br)

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, 
software distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions 
and limitations under the License.