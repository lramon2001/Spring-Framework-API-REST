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
