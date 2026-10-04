# Projeto Entregas

Sistema de gerenciamento de entregas com autenticação e cadastro de mercadorias.

## 📋 Requisitos

- Java 17+
- Maven 3.6+

## 🚀 Como Executar

### 1. Compilar o projeto

```bash
mvn clean package
```

### 2. Configurar variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto:

```bash
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

### 3. Executar a aplicação

```bash
java -jar target/projeto-entregas-1.0.0.jar
```

## 📦 Arquitetura

O projeto segue uma arquitetura em 3 camadas:

- **Model**: Entidades de domínio (Mercadoria, Endereco)
- **Repository**: Acesso a dados
- **Service**: Lógica de negócio (LoginService, EntregaService)

## 🎯 Funcionalidades

- ✅ Autenticação de usuário
- ✅ Cadastro de mercadorias com endereço
- ✅ Listagem de entregas
- ✅ Validação de dados obrigatórios

## 📁 Estrutura do Projeto

```
src/main/java/br/edu/entregas/
├── Main.java
├── model/
│ ├── Mercadoria.java
│ └── Endereco.java
├── service/
│ ├── LoginService.java
│ └── EntregaService.java
├── repository/
│ └── MercadoriaRepository.java
└── util/
└── Validador.java
```

## 🧪 Exemplo de Uso

1. Autenticar usuário (configure as credenciais no `.env`)
2. Cadastrar uma mercadoria com endereço de entrega
3. Listar as mercadorias cadastradas

## 📝 Notas

- Dados são armazenados em memória (não persistem)
- O endereço de entrega é obrigatório no cadastro
- **Segurança**: Nunca commite credenciais — use `.env` no `.gitignore`
