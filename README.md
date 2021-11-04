# Cities API

Neste primeiro projeto desenvolvido através do Bootcamp promovido pela [NTT Data](https://www.nttdata.com/global/en) - Quality Assurance Beginner #3 em parceria com a [Digital Innovation One](https://www.linkedin.com/school/digitalinnovation-one/) e com participação dos intrutores [Denilson Bonatti](https://www.linkedin.com/in/denilson-bonatti-54a14529/), [Lucas Alves](https://www.linkedin.com/in/lucas-alves-silva/), [Akinely Reis](https://www.linkedin.com/in/akinely-reis-6514358/), [Rui Rodrigues](https://www.linkedin.com/in/rui-ml-rodrigues/), [André Gomes](https://www.linkedin.com/in/andreluisgomes/) e toda a excelente equipe que disponibilizou tempo, dedicação, e sobretudo experiência na transmissão dos conteúdos e que nos propocionou agregar conhecimento e nos permitir adentrar na produção e desenvolvimento de uma API Rest do zero para consultar as distâncias das cidades do Brasil. Neste projeto nos deparamos com uma série de requisitos na qual tivemos por algumas ocasiões o primeiro contato, nos levando a começar a entender, explorar e integrar cada ferramenta. 

- Configuração e instalação da IntelliJ IDEA e o uso de java;
- A utilização do spring boot através do Spring Initializr, a utilização do Gradle, as configurações das properties e injeção das dependências;
- A utilização e configuração do Docker Desktop para utilização dos containers e a transmissão do banco de dados para dentro do container com Postgres;
- O uso do Postman (uso do formato JSON) e do Heroku (banco de dados na nuvem).
- As boas práticas de utilização do Git;

Apesar do projeto final ser demonstrado com a a utilização de LInux, pudemos realizá-lo  em ambiente Windows executando com Power Shell, bastando por algumas vezes buscar o conhecimento além do disponibilizado na plataforma e não o bastante as aulas de cursos fora deste Bootcamp porém dentro da plataforma DIO nos fundamentou para o continuo aprendizado.

Foi muito proveitoso aprender e desenvolver a API acompanhando as instruções, entendendo e reproduzindo em nossa máquina local e na nuvem e nos permitindo vislumbrar o quão as tecnologias integradas podem ampliar e facilitar o desenvolvimentos de grandes projetos.

Deixo abaixo o README do instutor para consultas futuras.

## Requirements

- Linux
- Git
- Java 8
- Docker
- IntelliJ Community
- Heroku CLI

## DataBase

### Postgres

- [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

- [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

- [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
- [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
- [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
- [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
- [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```
docker exec -it cities-db /bin/bash

psql -U postgres_user_city cities
```

### Query Earth Distance

Point

```
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;

```

Cube

```
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;

```

## Spring Boot

- <https://start.spring.io/>


- Java 8
- Gradle Project
- Jar
- Spring Web
- Spring Data JPA
- PostgreSQL Driver

### Spring Data

- [jpa.query-methods](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)

### Properties

- [appendix-application-properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html)
- [jdbc-database-connectio](https://www.codejava.net/java-se/jdbc/jdbc-database-connection-url-for-common-databases)

### Types

- [JsonTypes](https://github.com/vladmihalcea/hibernate-types)
- [UserType](https://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/usertype/UserType.html)

## Heroku

- [DevCenter](https://devcenter.heroku.com/articles/getting-started-with-gradle-on-heroku)

## Code Quality

### PMD

- <https://pmd.github.io/pmd-6.8.0/index.html>

### Checkstyle

- <https://checkstyle.org/>
- <https://checkstyle.org/google_style.html>
- <http://google.github.io/styleguide/javaguide.html>

```
wget https://raw.githubusercontent.com/checkstyle/checkstyle/master/src/main/resources/google_checks.xml
```