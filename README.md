# simulador-credito

Projeto do Caixaverso de Backend

## Objetivos
- Receber um envelope JSON, via chamadade API, contendo uma solicitação de simulação de empréstimo
- Consultar um conjunto de informações  parametrizadas em uma tabela de banco de dados SQL Server
- Validar os dados de entrada da API com base nos parâmetros de produtos retornados no banco de dados.
- Filtrar qual produto se adequa aos parâmetros de entrada
- Retornar cálculos para os sistemas de amortização SAC e PRICE de acordo com dados validados
- Retornar um envelope JSON contendo o nome do produto valido, e o resultado da simulação utilizando dois sistemas de amortização (SAC e PRICE), gravando este mesmo envelope JSON no EventHub. A Gravação no Eventhub visa simular uma possibilidade de integração com a área de relacionamento com o cliente da empresa, que receberia em poucos segundos este evento de simulação, e estaria apta à execução de estratégia negocial com base na interação do cliente
- persistir em banco local a simulação realizada
- Criar um endpoint para retornar todas as simulações realizadas
- Criar um endpoint para retornar os valores simulados para cada produto em cada dia
- Criar um endpoint para retornar dados de telemetria com volumes e tempos de resposta para cada serviço
- Disponibilizar o código fonte, com todas as evidência em .zip
- Incluir no projeto todos os arquivos para execução via container(dockerfile/ Docker Compose)

## Inicializando o projeto

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/simulador-credito-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
