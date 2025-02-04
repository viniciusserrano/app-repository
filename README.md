# API Imobiliária

API para gerenciamento e integração de dados do setor imobiliário, construída com **Spring Boot** e **MongoDB**. Este projeto utiliza uma arquitetura em camadas e segue princípios de modularidade e boas práticas de desenvolvimento.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**: Linguagem principal.
- **Spring Boot 3.4.x**: Framework para construção da API.
- **MongoDB**: Banco de dados NoSQL utilizado.
- **Docker e Docker Compose**: Para gerenciar contêineres e o ambiente de desenvolvimento.
- **Lombok**: Para reduzir o código boilerplate.
- **Maven**: Gerenciador de dependências.

---

## 🚀 Funcionalidades

- **Cadastro de Imóveis**:
  - Permite cadastrar informações detalhadas sobre os imóveis, como descrição, preço e localização.
- **Listagem de Imóveis**:
  - Exibe os imóveis disponíveis para venda ou locação.
- **Atualização de Imóveis**:
  - Atualiza as informações de um imóvel existente.
- **Filtragem Avançada**:
  - Busca imóveis com base em parâmetros como bairro, cidade, e tipo de segmento.

---

## 📂 Estrutura do Projeto

```plaintext
api-imobiliaria
├── admin             # Gerenciamento administrativo
├── config            # Configurações gerais do projeto (Spring, MongoDB, etc.)
├── imobiliaria
│   └── imoveis       # Módulo principal (Imóveis)
│       ├── model     # Entidades e DTOs
│       ├── repository # DAO (acesso ao MongoDB)
│       ├── service   # Regras de negócio
│       └── resource  # Endpoints REST
└── local             # Configurações locais (exemplo: Docker)


⚙️ Configuração e Execução
Pré-requisitos
Java 21 ou superior.
Docker e Docker Compose.
Maven 3.8.x.

📜 Licença
Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

✨ Autor
Vinicius Gomes Serrano Segalio - Desenvolvedor Java.
LinkedIn: [Seu LinkedIn](https://www.linkedin.com/in/viniciusgserrano/)
GitHub: [Seu GitHub](https://viniciusserrano.github.io/)
