# 🏋️‍♂️ PanaGYM - Sistema de Gerenciamento de Academia

Bem-vindo ao repositório do **PanaGYM**, uma plataforma moderna e responsiva para gerenciamento de matrículas de academia, desenvolvida como projeto de portfólio para praticar desenvolvimento Fullstack com Java e Spring Boot.

---

## 🚀 Status do Projeto

✅ **Fase 1: Front-end (Concluída)**
Landing Page focada em conversão, apresentando planos, unidades e horários da academia.

✅ **Fase 2: Back-end (Concluída)**
Integração com Spring Boot para gerenciamento de matrículas, persistência em banco de dados MySQL e geração de comprovante em PDF.

---

## 💻 Tecnologias Utilizadas

* **HTML5:** Estruturação semântica.
* **CSS3 & Tailwind CSS (v4):** Estilização moderna e responsiva via CDN.
* **JavaScript:** Controle do modal de matrícula, injeção dinâmica do plano e máscaras de CPF, telefone e cartão.
* **Java 17+**
* **Spring Boot:** Framework principal do back-end.
* **Spring Data JPA + Hibernate:** Mapeamento objeto-relacional e persistência.
* **MySQL:** Banco de dados relacional.
* **OpenPDF (LowaGie):** Geração de comprovante de matrícula em PDF no servidor, com logo e layout formatado.
* **Lombok:** Redução de boilerplate nas entidades Java.

---

## ⚙️ Funcionalidades

* Apresentação institucional da academia com seções de planos, unidades e horários.
* Modal de matrícula com seleção de plano (Bronze, Ouro, Diamante).
* Máscaras automáticas nos campos CPF (`000.000.000-00`), telefone (`(00) 00000-0000`) e cartão (`0000 0000 0000 0000`) durante o preenchimento.
* Cadastro de aluno persistido no banco de dados via Spring Data JPA.
* Geração e download automático de comprovante em PDF ao finalizar a matrícula, contendo logo da academia e dados formatados.
* Número do cartão exibido com segurança no PDF (`**** **** **** 1234`).
* Listagem de alunos matriculados (`/matriculas/lista`).
* Remoção de matrícula por ID.

---

## 🗄️ Banco de Dados

O projeto utiliza **MySQL**. Para configurar, execute o script disponível em `BancodeDados.sql` na raiz do repositório:

```sql
CREATE DATABASE panagym;
USE panagym;

CREATE TABLE matricula (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20),
    cpf VARCHAR(14),
    cartao VARCHAR(19) NOT NULL,
    plano VARCHAR(20) NOT NULL
);
```

Configure suas credenciais em `src/main/resources/application.properties`.

---

## 📥 Como executar localmente

**Pré-requisitos:** Java 17+, Maven, MySQL rodando localmente.

1. Clone o repositório:
```bash
git clone https://github.com/tiagonunes1337/panagym.git
```
2. Execute o script `BancodeDados.sql` no seu MySQL.
3. Configure o `application.properties` com seu usuário e senha do banco.
4. Na pasta `spring-petclinic`, rode:
```bash
./mvnw spring-boot:run
```
5. Acesse `http://localhost:8080` no navegador.

---

<p align="center">
  Desenvolvido com dedicação para praticar Java e Spring Boot. 💻
</p>