# Projeto de cadastro de pacientes de uma clínica em RestFul API

## Tecnologias utilizadas
* Java 17 LTS
* Swagger OpenAPI
* OpenFeign
* Spring boot
* JPA
* Conector PostgreSQL

## Link do projeto rodando no Railway
https://clinica-production-6136.up.railway.app/swagger-ui/index.html

## Diagrama de classes

```mermaid
classDiagram
    class Paciente {
        - cpf: string
        - nome: string
        - dataNasc: Date
        - endereco: Endereco
        - telefones: Telefone[]
        - exames: Exame[]
    }

    class Telefone {
        - id: int
        - tel: string
    }

    class Endereco {
        - id: int
        - CEP: int
        - rua: string
        - numero: string
        - cidade: string
        - estado: string
        - bairro: string
        - complemento: string
    }

    class Exame {
        - id: int
        - exame: string
        - valor: float
        - realizado: boolean
    }

    Paciente -- "1" Endereco : possui
    Paciente -- "0..*" Exame : realiza
    Paciente -- "1..*" Telefone : possui
```