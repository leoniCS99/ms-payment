# Payment Application

Este projeto é uma aplicação para gerenciar pagamentos, implementada usando Spring Boot. A arquitetura segue os princípios da Clean Architecture, e os testes são realizados usando Mockito e Lombok.

## Requisitos

- Java 11 ou superior
- Maven 3.6.0 ou superior

## Estrutura do Projeto

A estrutura do projeto é organizada de acordo com os princípios da Clean Architecture:

- **domain**: Contém as entidades e interfaces principais.
- **usecases**: Contém os casos de uso que definem a lógica de negócio.
- **adapters**: Contém os adaptadores de entrada e saída (ex: controladores, gateways).
- **config**: Contém a configuração da aplicação (ex: configuração do Spring).

## Tecnologias Utilizadas

- **Spring Boot**
- **Mockito**
- **Lombok**

## Instalação

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/payment.git
   cd payment
