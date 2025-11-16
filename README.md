# 💸 Conversor de Moedas - Challenge ONE (Oracle Next Education)

## 🌟 Descrição do Projeto
Este projeto é a solução desenvolvida para o **Challenge ONE: Conversor de Moedas** do programa **Oracle Next Education (ONE)**, em parceria com a Alura. Trata-se de uma aplicação de linha de comando (CLI) em Java que permite aos usuários realizar conversões de moedas em tempo real através de um menu interativo.

O foco principal do projeto foi demonstrar a integração com uma API externa (via HTTP) e o tratamento de dados (JSON parsing) dentro de um ambiente Java.

---

## ✨ Funcionalidades e Requisitos Atendidos
* **Menu de Opções Fixas:** Permite a escolha rápida de pares de moedas populares (USD/BRL, USD/ARS, USD/COP, etc.).
* **Integração HTTP:** Faz requisições **GET** para a **ExchangeRate-API** para obter taxas de câmbio atuais.
* **Histórico de Sessão:** Armazena todas as conversões bem-sucedidas em uma lista (`ArrayList`) e exibe o resumo completo ao sair da aplicação.
* **Tratamento de Exceções:** Implementação robusta de `try-catch` para lidar com:
    * Erros de rede (`IOException`, `InterruptedException`).
    * Erros de API (parsing de JSON).
    * Entradas inválidas do usuário (`NumberFormatException`).

---

## 🛠️ Tecnologias Utilizadas
* **Linguagem:** Java 17+
* **HTTP Client:** `java.net.http.HttpClient` (API nativa)
* **Parsing JSON:** Biblioteca **Gson**
* **API de Câmbio:** [ExchangeRate-API](https://www.exchangerate-api.com/)

---
