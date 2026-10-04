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

### 2. Executar a aplicação
```bash
java -jar target/projeto-entregas-1.0.0.jar
```

## 🔐 Credenciais Padrão

- **Usuário:** admin
- **Senha:** 12345678

## 📦 Arquitetura

O projeto segue uma arquitetura em **3 camadas**:

- **Model** (`br.edu.entregas.model`): Entidades de domínio (Mercadoria, Endereco)
- **Repository** (`br.edu.entregas.repository`): Acesso a dados
- **Service** (`br.edu.entregas.service`): Lógica de negócio (LoginService, EntregaService)

## 🎯 Funcionalidades

- ✅ Autenticação de usuário
- ✅ Cadastro de mercadorias com endereço
- ✅ Listagem de entregas
- ✅ Validação de dados obrigatórios

## 📁 Estrutura do Projeto

src/main/java/br/edu/entregas/
├── Main.java # Ponto de entrada
├── model/
│ ├── Mercadoria.java # Entidade de mercadoria
│ └── Endereco.java # Record de endereço
├── service/
│ ├── LoginService.java # Autenticação
│ └── EntregaService.java # Lógica de entregas
├── repository/
│ └── MercadoriaRepository.java # Persistência em memória
└── util/
└── Validador.java # Utilitários de validação

## 🧪 Exemplo de Uso

O sistema aguarda entrada de dados para:
1. Autenticar usuário (admin/12345678)
2. Cadastrar uma mercadoria com endereço de entrega
3. Listar as mercadorias cadastradas

## 📝 Notas

- Dados são armazenados em memória (não persistem)
- O endereço de entrega é obrigatório no cadastro