# 🏋️‍♂️ PanaGYM - Sistema de Gerenciamento de Academia

Bem-vindo ao repositório do **PanaGYM**, uma plataforma moderna e responsiva focada no gerenciamento e na apresentação institucional de uma academia de alto padrão. 

Este projeto está sendo desenvolvido em etapas e tem como objetivo demonstrar habilidades em estruturação de interfaces web modernas e, no futuro, a integração com um sistema robusto de back-end.

---

## 🚀 Status do Projeto

🚧 **Fase 1: Front-end (Versão Beta / Em Desenvolvimento)** 🚧
A etapa atual consiste na construção de uma Landing Page focada em conversão, apresentando planos, horários e informações da academia.

⏳ **Fase 2: Back-end (Em breve)** ⏳
Integração com API REST para gerenciamento de matrículas e usuários.

---

## 💻 Tecnologias Utilizadas (Fase Atual)

* **HTML5:** Estruturação semântica.
* **CSS3 & Tailwind CSS (v4):** Estilização moderna, ágil e responsiva usando a abordagem *utility-first* via CDN.
* **Glassmorphism:** Efeitos visuais modernos (`backdrop-blur`) para destacar seções premium.

---

## ⚙️ Arquitetura e Decisões Técnicas

Para a concepção visual, o site abandonou frameworks tradicionais de componentes prontos (como Bootstrap) em favor do **Tailwind CSS**. Isso permitiu criar uma identidade visual única (combinando tons escuros de *slate* com destaques em azul/laranja), garantindo alta customização sem inflar o código CSS com classes desnecessárias ou sobrescritas forçadas.

As principais seções do HTML incluem:
* **Header Premium:** Navegação responsiva com efeito `sticky` e fundo translúcido.
* **Hero Section:** Apresentação de alto impacto para prender a atenção do usuário.
* **Grid de Planos:** Cards interativos utilizando `Flexbox` e `Grid` para melhor disposição em telas móveis e desktop, com destaque para o plano principal ("Black").
* **Quadro de Horários:** Design em formato de lista (card) com alinhamento dinâmico (`justify-between`).

---

## 🔮 Próximos Passos (Back-end)

A evolução natural do PanaGYM transformará esta Landing Page em uma aplicação Fullstack. O desenvolvimento do servidor será realizado com:

* **Linguagem:** Java
* **Framework:** Spring Boot
* **Banco de Dados:** (A definir: MySQL / PostgreSQL)
* **Funcionalidades Previstas:**
    * API RESTful para cadastro de novos alunos.
    * Autenticação e Login.
    * Painel administrativo para controle de planos e horários.

---

## 📥 Como executar o projeto localmente (Fase Front-end)

Como a aplicação atualmente roda apenas com HTML estático e o Tailwind via script, não há necessidade de configurar ambientes complexos ou rodar servidores de build como o Node.js.

1.  Clone este repositório:
    ```bash
    git clone [https://github.com/tiagonunes1337/panagym.git](https://github.com/tiagonunes1337/panagym.git)
    ```
2.  Acesse a pasta do projeto.
3.  Basta dar um duplo clique no arquivo `index.html` para abri-lo no seu navegador padrão.

---

<p align="center">
  Desenvolvido com dedicação e foco em performance web. 💻
</p>
