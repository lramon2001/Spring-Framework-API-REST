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


     ```java   
     http.csrf().ignoringAntMatchers("/api/v1/**");
        http.formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/clientes")
            .permitAll();
	    
     ```
	    

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
Na aula 7 foi abordado como adicionar o spring hateoas como dependência do projeto. Para isso, basta adicionar essa dependência ao pom.xml
```xml
  <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-hateoas</artifactId>
  </dependency>
```
Além disso foi necessário herdar a classe do RepresentationModel para a entidade, veja como clicando [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/entidades/Entidade.java).


## Aula 8

Na aula 8 foi ensinado e exemplificado como fazer a adição dos links usando a classe WEBMVCLinkBuilder do Hateoas do Spring.

Exemplo da adição de links a reposta da requisição.

```java
public List<Cargo> buscarTodos()
   {
    List<Cargo> cargos = cargoServico.buscarTodos();

    cargos.forEach(cargo-> {
      Long id = cargo.getId();
      Link selfLink = WebMvcLinkBuilder.
      linkTo(WebMvcLinkBuilder.
      methodOn(CargoControleApi.class).
      buscaPorId(id)).
      withSelfRel().withType("GET");
    
      Link editarLink = WebMvcLinkBuilder.
      linkTo(WebMvcLinkBuilder.
      methodOn(CargoControleApi.class).
      atualizar(null, id)).
      withSelfRel().
      withType("PUT");
      
      Link excluirLink = WebMvcLinkBuilder.
      linkTo(WebMvcLinkBuilder.methodOn(CargoControleApi.class).
      excluirPorId(id)).withSelfRel().withType("NO CONTENT");
      cargo.add(selfLink,editarLink);
    });
    
    return cargos;
   }

```
 A implementação dos métodos está disponivel [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_VII.java);
 
 ## Aula 9
 
 Na aula 9 foi ensinado como fazer a correta implementação do HATEOAS utilizando uma camada separada Assembler. Esta camada basicamente implementa 
 a interface SimpleRepresentationModelAssembler que nos "obriga" a implementar os métodos addLinks. A Implementação dessa camada ficará disponível [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/tree/main/api/hateoas).
 
 Além disso, foi necessário anotar a camada com @Component para utilizá-lo como dependência na camada de controle com a anotação @autowired.
 Feito isso, modifiquei os métodos da camada de controle para retornar os objetos utilizando o Assembler.
 A nova implementação da camada de controle ficará disponível [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/edit/main/api/controle/cargoControleApi_VII.java).
 
 ## Aula 10
 
Na aula 10 foi ensinado como implementar o recurso de paginação utilizando o Pageaable do spring. Há uma forma rudimentar de implementar que é adicionando o objeto Pageable nos parâmetros do método na camada de serviço e fazendo a sobrecarga do método nas outras classes necessárias.
No entanto, a melhor maneira é utilizando uma dependência na camada de serviço chamada PageResourceAssembler. É a melhor maneira pois ao receber a resposta de uma requisição paginada isso é informado ao cliente que executou a requisição
 
A implementação da paginação está disponível [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/api/controle/cargoControleApi_VIII.java);

## Aula 11

Na aula 11 foi ensinado como modificar o application.propreties para a API receber os parametros de paginacao como o desenvolvedor preferir
Arquivo disponível [aqui](https://github.com/lramon2001/Spring-Framework-API-REST/blob/main/application.properties)

## Aula 12

Na aula 12 foi explanado como tratar excecões exception handler para isso foi criada uma classe que herda do ResponseEntityExceptionHandler com dois métodos sendo um anotado com @ExceptionHandler e outro com sendo a sobrecarga do método handleMethodArgumentNotValid. Confira a implementação clicando [aqui]().

## Aula 13

Na aula 13 foi explicado como adicionar o swagger como dependência do projeto para documentar a API.
1 passo é a adicionar as dependências ao pom.xml

```xml
<properties>
		<java.version>11</java.version>
		<swagger.version>3.0.0</swagger.version>
</properties> 
<dependencies>
<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger2</artifactId>
		<version>${swagger.version}</version>
		</dependency>

		<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-swagger-ui</artifactId>
		<version>${swagger.version}</version>
		</dependency>

		<dependency>
		<groupId>io.springfox</groupId>
		<artifactId>springfox-boot-starter</artifactId>
		<version>${swagger.version}</version>
		</dependency>
  </dependencies>
```
## Aula 14

Na aula 14 foi exemplifacado como fazer a configuração do swagger. Confira [aqui]() como foi feita a configuração.
