# Spring-Framework-API-REST
 Spring Framework-API REST:books: :seedling:-Repositório de estudo criado para fazer versionamento de uma API REST desenvolvida em spring 


## Aula 1 
-Baixando o projeto base 

Basta clicar [aqui](https://github.com/treinaweb/treinaweb-spring-apis/releases/tag/v1) para baixar a release do projeto base

-Altere a string de conexão com o banco de dados no arquivo application.properties

- Baixe o maven, para isso basta executar o script:

```shell
 sudo apt install maven
```

- Agora no diretório em que o arquivo pom.xml está contido execute o seguinte comando:

```shell
 mvn spring-boot:run
```
-  O projeto base utiliza-se de spring security, desta forma vamos comentar a parte do código que trata as requisições que são autorizadas

<img src="https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/images/spring_security.png">

E depois de comentar este trecho adicione a chamada do método autorizando qualquer requisição em qualquer rota disponivel

assim:

```java 
 http.authorizeRequests().anyRequest().permitAll();
```
- Feito isso crie um cargo Gerente na rota cargos/cadastrar;
- Cadastre uma pessoa na rota funcionarios/cadastrar com o cargo de gerente;
- Pronto, agora desfaça as alterações de seguranças feitas no Webconfig.

## Aula 2

Na aula 2 foi abordado como fazer requisições do tipo get com injeçôes de dependências da camada de serviço, utilizando as notações de RestController e get Mapping. Inculise foram abordadas duas maneiras de fazer esta requisição

- [Primeira maneira](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi.java);
- [Segunda maneira](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_II.java).

## Aula 3

Na aula 3 foi abordado como fazer a consulta de uma identidade pelo id

- [Busca por id](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_III.java).

## Aula 4

Na aula 4 foi abordado como fazer um cadastro de uma entidade, que no nosso caso foi a entidade cargo. Utilizamos o padrão DTO com a resposta da requisição com o status 201 para fazer jus a boas práticas.

- [Cadastro](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_IV.java)

## Aula 5
Na aula 5 foi abordado como fazer a edição de uma entidade usando o padrão dto. Deixarei o link para um mapeador de entidade!

- [Atualizar](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_V.java);
- [Mapeador](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/mapeadores/CargoMapeador.java).

## Aula 6
Na aula 6 foi abordado como fazer um delete de uma entidade

- [Deletar](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_VI.java);

## Aula 7
Na aula 7 foi abordado como adicionar o spring hateoas como dependência do projeto
```xml
  <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-hateoas</artifactId>
  </dependency>
```
