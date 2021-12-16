# spring-security-jwt

# Protegendo sua API RESTful com Spring Security e JWT

## O que é JWT?

- É um padrão que define como transmitir e armazenar objetos JSON de forma segura entre diferentes aplicações.
- Serve para realizar autenticação entre duas partes através de um token assinado que autentica uma requisição web.
- Esse token é um código em Base64 que armazena objetos JSON juntamente com os dados que permitem a autenticação da
  requisição.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT](https://jwt.io)
- [Lombok](https://projectlombok.org/)
- [H2 Database](https://www.h2database.com/html/quickstart.html)

## Funcionalidades

- Geração do token JWT.
- Autenticação utilizando o token.
- Autorização de acesso dos recursos da aplicação através dos "ROLE's".

## Links úteis

- [JWT](https://jwt.io)
- [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.3&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=jwt&name=spring-rest-security-jwt&description=Demo%20project%20for%20Spring%20Security%20with%20JWT&packageName=com.example.jwt&dependencies=web,devtools,data-jpa,h2,security,lombok)
