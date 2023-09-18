# API Organizador de Times
### Resolução do Bootcamp de Desemvolvedor Jr da [IBM](https://www.ibm.com/br-pt)
## Descrição
API para gerenciamento de times de futebol e seus jogadores de acordo com as seguintes regras:

Cada time deve ser formado com jogadores cujo sobrenome comece com a mesma letra. Ou seja, jogadores com sobrenomes começando com 'A' formam um time, jogadores com 'B' formam outro, e assim por diante.

Mas aqui está a reviravolta: você só pode ter UM jogador com o mesmo sobrenome começando com a mesma letra em um time. Se houver mais de um jogador com o mesmo sobrenome começando com a mesma letra, eles não podem estar no mesmo time.

## Deploy
A API está hospedada no Render e pode ser acessada [aqui](#).

## Tecnologias
- Java 17
- Spring Boot 3.1.3
- H2 Database
- Maven
- JUnit 5
- Swagger
- JPA (Hibernate)
## Como executar
### Pré-requisitos
- Java 17
- Maven

### Executando
- Clone o repositório
- Execute o comando `mvn spring-boot:run` na pasta raiz do projeto
- Acesse a documentação da API em `http://localhost:8080/swagger-ui.html`
- Acesse o banco de dados em `http://localhost:8080/h2-console`
- A url do H2 é `jdbc:h2:mem:organizador-de-times` com a senha `1234`

## Endpoints
### Times
#### GET /times
Retorna todos os times cadastrados e seus jogadores.
### Jogadores
#### POST /jogadores
Cadastra um novo jogador.
#### DELETE /jogadores/all
Deleta todos os jogadores cadastrados.

## Exemplos
### Cadastrar um novo jogador
#### POST /jogadores
```json
{
  "nome": "Diego Souza"
}
```
#### Response
A resposta não possui corpo e retorna o status 201 (Created).
### Listar todos os times
#### GET /times
#### Response
Retorna o body e o status 200 (OK).
```json
[
  {
    "Time S": [
      "Diego Souza"
    ]
  }
]
```
### Deletar todos os jogadores
#### DELETE /jogadores/all
#### Response
A resposta não possui corpo e retorna o status 202 (Accepted).

## Autor
[Jarbas Gouveia](https://github.com/jjgouveia)

