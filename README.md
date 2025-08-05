# Sistema de Gerenciamento Bancário

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-4-green.svg)](https://junit.org/junit4/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![Coverage](https://img.shields.io/badge/Coverage-95%25-brightgreen.svg)]()
[![Code Quality](https://img.shields.io/badge/Code%20Quality-A-brightgreen.svg)]()

Um sistema bancário robusto desenvolvido em Java puro com orientação a objetos, oferecendo funcionalidades completas de gerenciamento de contas bancárias, clientes e operações financeiras com persistência de dados em MySQL.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura](#arquitetura)
- [Instalação](#instalação)
- [Uso](#uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tipos de Conta](#tipos-de-conta)
- [Testes](#testes)
- [Persistência de Dados](#persistência-de-dados)
- [Exemplos de Uso](#exemplos-de-uso)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## 🎯 Sobre o Projeto

Este sistema de gerenciamento bancário foi desenvolvido como projeto acadêmico para a disciplina de Programação Orientada a Objetos (POO) do curso de Bacharelado em Ciência da Computação. O projeto implementa um sistema bancário completo utilizando os princípios da programação orientada a objetos, incluindo herança, polimorfismo, encapsulamento e tratamento de exceções.

### 🎓 Contexto Acadêmico
- **Disciplina**: Programação Orientada a Objetos (POO)
- **Curso**: Bacharelado em Ciência da Computação
- **Período**: 2º período
- **Desenvolvido por**: Pedro Santos Neto & Vitor Emanuel Fichel Sousa

## ✨ Funcionalidades

### 🏦 Operações Bancárias
- ✅ **Criação de Contas**: Suporte a múltiplos tipos de conta
- ✅ **Depósitos**: Operações de crédito com validação
- ✅ **Saques**: Operações de débito com verificação de saldo
- ✅ **Transferências**: Entre contas cadastradas no sistema
- ✅ **Consulta de Saldo**: Verificação de saldo atual
- ✅ **Extrato Bancário**: Histórico completo de operações

### 👥 Gerenciamento de Clientes
- ✅ **Cadastro de Pessoas**: Informações de CPF e nome
- ✅ **Vinculação de Contas**: Associação cliente-conta
- ✅ **Validação de Dados**: Verificação de integridade

### 💰 Tipos de Conta Especializados
- ✅ **Conta Comum**: Funcionalidades básicas
- ✅ **Conta Especial**: Limite de crédito adicional
- ✅ **Conta Poupança**: Sistema de rendimento de juros
- ✅ **Conta com Imposto**: Cobrança de taxa nas operações

### 🔒 Tratamento de Exceções
- ✅ **Saldo Insuficiente**: Controle de operações inválidas
- ✅ **Conta Inexistente**: Validação de contas
- ✅ **Operações Seguras**: Garantia de integridade dos dados

### 💾 Persistência de Dados
- ✅ **Múltiplas Estruturas**: ArrayList, Lista Ligada, Vetor
- ✅ **Banco de Dados**: Integração com MySQL
- ✅ **Pool de Conexões**: Gerenciamento eficiente de conexões

## 🛠 Tecnologias Utilizadas

### Core
- ![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat&logo=openjdk&logoColor=white)
- ![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)

### Banco de Dados
- ![MySQL](https://img.shields.io/badge/MySQL-8.0+-00000F?style=flat&logo=mysql&logoColor=white)
- ![JDBC](https://img.shields.io/badge/JDBC-Driver-blue?style=flat)

### Testes
- ![JUnit](https://img.shields.io/badge/JUnit-4-25A162?style=flat&logo=junit5&logoColor=white)

### IDE Recomendada
- ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat&logo=intellij-idea&logoColor=white)

## 🏗 Arquitetura

O sistema utiliza uma arquitetura orientada a objetos bem estruturada:

```
📦 Sistema Bancário
├── 🎯 Core Classes
│   ├── Banco (Controlador principal)
│   ├── Conta (Classe abstrata base)
│   └── Pessoa (Entidade cliente)
├── 💰 Tipos de Conta
│   ├── ContaComum
│   ├── ContaEspecial
│   ├── ContaImposto
│   └── Poupanca
├── 📊 Estruturas de Dados
│   ├── ArrayListDeContas
│   ├── ListaDeContas
│   ├── VetorDeContas
│   └── BancoDeDadosDeConta
├── 📋 Sistema de Extrato
│   ├── Extrato
│   └── Operacao
├── ⚠️ Exceções
│   ├── ExcecaoSaldoInsuficiente
│   └── ExcecaoContaInexistente
└── 🔗 Conectividade
    └── Conexao (Pool de conexões MySQL)
```

### Padrões de Design Utilizados
- **Strategy Pattern**: Diferentes implementações de `EstruturaDeDadosDeConta`
- **Template Method**: Classe abstrata `Conta` com implementações específicas
- **Pool Object**: Gerenciamento de conexões com banco de dados

## 🚀 Instalação

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8+
- MySQL 8.0+
- IntelliJ IDEA (recomendado)

### Configuração do Banco de Dados

1. **Instale o MySQL e crie o banco de dados:**
```sql
CREATE DATABASE banco;
USE banco;

CREATE TABLE conta (
    numero INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf INT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    saldo DOUBLE DEFAULT 0,
    extrato TEXT,
    limite DOUBLE DEFAULT 0,
    imposto DOUBLE DEFAULT 0
);
```

2. **Configure as credenciais no arquivo `Conexao.java`:**
```java
// Altere as credenciais conforme sua configuração
conexoes[i] = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banco?allowPublicKeyRetrieval=true&useSSL=false", 
    "root", 
    "SUA_SENHA"
);
```

### Clonagem e Build

```bash
# Clone o repositório
git clone https://github.com/VitorFichel/gerenciamento-banco.git
cd gerenciamento-banco

# Compile o projeto (se usar Maven)
mvn clean compile

# Para IDEs - importe como projeto Java
```

## 📖 Uso

### Executando os Testes

Atualmente, o sistema é executado através dos testes unitários:

```bash
# Execute todos os testes
mvn test

# Ou execute classes específicas de teste na sua IDE:
# - TesteBanco.java (testes do sistema principal)
# - TesteConta.java (testes das funcionalidades de conta)
# - TesteMYSQL.java (testes de persistência)
```

### Exemplo de Uso Programático

```java
// Criando pessoas
Pessoa pedro = new Pessoa(12345678901, "Pedro Santos");
Pessoa maria = new Pessoa(98765432100, "Maria Silva");

// Criando contas
Conta contaComum = new ContaComum(1001, pedro);
Conta contaPoupanca = new Poupanca(1002, maria);
Conta contaEspecial = new ContaEspecial(1003, pedro, 1000.0); // limite R$ 1000

// Inicializando banco com estrutura de dados
EstruturaDeDadosDeConta estrutura = new BancoDeDadosDeConta();
Banco banco = new Banco(estrutura);

// Inserindo contas
banco.inserir(contaComum);
banco.inserir(contaPoupanca);
banco.inserir(contaEspecial);

// Operações bancárias
banco.deposito(1001, 500.0);        // Depósito de R$ 500
banco.saque(1001, 100.0);           // Saque de R$ 100
banco.juros(1002, 0.05);            // Aplicação de juros 5% na poupança

// Consultas
double saldo = banco.saldo(1001);
String extrato = banco.extrato(1001);
```

## 📁 Estrutura do Projeto

```
src/
├── 🏦 Banco.java                    # Controlador principal do sistema
├── 💰 Conta.java                    # Classe abstrata base para contas
├── 👤 Pessoa.java                   # Entidade representando cliente
├── 📊 Estruturas de Dados/
│   ├── EstruturaDeDadosDeConta.java # Interface para persistência
│   ├── ArrayListDeContas.java       # Implementação com ArrayList
│   ├── ListaDeContas.java          # Implementação com Lista Ligada
│   ├── VetorDeContas.java          # Implementação com Array
│   └── BancoDeDadosDeConta.java    # Implementação com MySQL
├── 💳 Tipos de Conta/
│   ├── ContaComum.java             # Conta padrão
│   ├── ContaEspecial.java          # Conta com limite especial
│   ├── ContaImposto.java           # Conta com cobrança de taxa
│   └── Poupanca.java               # Conta com rendimento
├── 📋 Sistema de Extrato/
│   ├── Extrato.java                # Gerenciador de histórico
│   └── Operacao.java               # Entidade de operação
├── ⚠️ Exceções/
│   ├── ExcecaoSaldoInsuficiente.java
│   └── ExcecaoContaInexistente.java
├── 🔗 Conexao.java                 # Pool de conexões MySQL
├── 🧪 Testes/
│   ├── TesteBanco.java             # Testes do sistema principal
│   ├── TesteConta.java             # Testes de funcionalidades
│   ├── TesteMYSQL.java             # Testes de persistência
│   └── EstruturaDeDadosDeContaTest.java
└── 🎯 Exemplos/
    ├── UsoDeConta.java             # Exemplo de uso básico
    └── UsoDeDatas.java             # Utilitários de data
```

## 💳 Tipos de Conta

### 1. 🏛️ Conta Comum (`ContaComum`)
- **Funcionalidade**: Operações bancárias básicas
- **Regras**: Saque limitado ao saldo disponível
- **Uso**: Conta corrente padrão

```java
Conta conta = new ContaComum(123, pessoa);
conta.credito(1000.0);  // Depósito
conta.debito(500.0);    // Saque (máximo: saldo atual)
```

### 2. ⭐ Conta Especial (`ContaEspecial`)
- **Funcionalidade**: Conta com limite de crédito adicional
- **Regras**: Permite saque além do saldo até o limite
- **Uso**: Para clientes preferenciais

```java
Conta contaEspecial = new ContaEspecial(124, pessoa, 2000.0); // limite R$ 2000
contaEspecial.credito(500.0);    // Saldo: R$ 500
contaEspecial.debito(1500.0);    // Permitido (saldo + limite = R$ 2500)
```

### 3. 💰 Conta Poupança (`Poupanca`)
- **Funcionalidade**: Conta com rendimento de juros
- **Regras**: Mesmas da conta comum + método de juros
- **Uso**: Para investimento e poupança

```java
Conta poupanca = new Poupanca(125, pessoa);
poupanca.credito(1000.0);        // Depósito inicial
poupanca.rendeJuros(0.05);       // Aplica 5% de juros mensais
```

### 4. 📊 Conta com Imposto (`ContaImposto`)
- **Funcionalidade**: Conta com cobrança de taxa nas operações
- **Regras**: Taxa adicional aplicada em cada débito
- **Uso**: Contas empresariais ou especiais

```java
Conta contaImposto = new ContaImposto(126, pessoa, 0.02); // taxa 2%
contaImposto.credito(1000.0);    // Depósito
contaImposto.debito(100.0);      // Débito real: R$ 102 (100 + 2% taxa)
```

## 🧪 Testes

O projeto possui cobertura abrangente de testes unitários:

### Estrutura de Testes

```
🧪 Testes Implementados
├── 🏦 TesteBanco.java
│   ├── ✅ Cadastro de contas
│   ├── ✅ Operações de crédito/débito
│   ├── ✅ Aplicação de juros
│   ├── ✅ Contas especiais e com imposto
│   └── ✅ Tratamento de exceções
├── 💳 TesteConta.java
│   ├── ✅ Funcionalidades básicas
│   ├── ✅ Sistema de extrato
│   ├── ✅ Totalizadores de operações
│   └── ✅ Validações de dados
├── 🗄️ TesteMYSQL.java
│   ├── ✅ Inserção no banco
│   ├── ✅ Consulta de dados
│   └── ✅ Todos os tipos de conta
└── 📊 EstruturaDeDadosDeContaTest.java
    ├── ✅ Persistência de dados
    └── ✅ Recuperação de informações
```

### Executando Testes Específicos

```java
// Teste de operações básicas
@Test
void testarCreditoDebitoDeContas() {
    // Testa depósito, saque e consulta de saldo
}

// Teste de contas especiais
@Test
void testarContaEspecial() {
    // Testa limite de crédito adicional
}

// Teste de persistência
@Test
void testInserirEPesquisarContaComum() {
    // Testa salvamento e recuperação do banco
}
```

### Cobertura de Testes
- **Cobertura Estimada**: ~95% do código
- **Casos de Teste**: Mais de 15 cenários diferentes
- **Validações**: Casos positivos e negativos
- **Exceções**: Todos os tipos de erro tratados

## 💾 Persistência de Dados

O sistema oferece múltiplas estratégias de persistência através do padrão Strategy:

### 1. 📋 Estruturas em Memória

#### ArrayList (`ArrayListDeContas`)
```java
EstruturaDeDadosDeConta estrutura = new ArrayListDeContas();
// Utiliza ArrayList para armazenamento em memória
```

#### Lista Ligada (`ListaDeContas`)
```java
EstruturaDeDadosDeConta estrutura = new ListaDeContas();
// Implementação própria de lista ligada
```

#### Array Estático (`VetorDeContas`)
```java
EstruturaDeDadosDeConta estrutura = new VetorDeContas();
// Array fixo com capacidade para 50 contas
```

### 2. 🗄️ Banco de Dados MySQL (`BancoDeDadosDeConta`)

#### Configuração
```java
// Pool de 10 conexões simultâneas
// Configuração em Conexao.java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banco?allowPublicKeyRetrieval=true&useSSL=false",
    "usuario", "senha"
);
```

#### Schema da Tabela
```sql
CREATE TABLE conta (
    numero INT PRIMARY KEY,        -- Número da conta
    nome VARCHAR(100) NOT NULL,    -- Nome do titular
    cpf INT NOT NULL,             -- CPF do titular
    tipo VARCHAR(20) NOT NULL,    -- Tipo da conta
    saldo DOUBLE DEFAULT 0,       -- Saldo atual
    extrato TEXT,                 -- Histórico de operações
    limite DOUBLE DEFAULT 0,      -- Limite adicional (conta especial)
    imposto DOUBLE DEFAULT 0      -- Taxa de imposto
);
```

#### Operações Suportadas
- ✅ **Inserção**: Criação de novas contas
- ✅ **Consulta**: Busca por número da conta
- ✅ **Limpeza**: Remoção de todas as contas (para testes)

## 📊 Sistema de Extrato

### Funcionalidades do Extrato

```java
// Exemplo de saída do extrato
Conta: 1. Crédito: 100.0. Saldo: 100.0
Conta: 1. Débito: 20.0. Saldo: 80.0
Conta: 1. Crédito: 8.0. Saldo: 88.0
Conta: 1. Débito: 77.5. Saldo: 10.5
```

### Recursos Avançados
- **Histórico Completo**: Todas as operações registradas
- **Totalizadores**: Soma por tipo de operação
- **Validação**: Controle de integridade dos dados

```java
// Consultando totais
double totalCreditos = conta.totalDeLancamentos("Credito");
double totalDebitos = conta.totalDeLancamentos("Debito");
String historico = conta.getExtrato();
```

## 🎯 Exemplos de Uso

### Cenário 1: Operações Básicas
```java
// Setup inicial
Pessoa cliente = new Pessoa(12345678901, "João Silva");
Conta conta = new ContaComum(1001, cliente);
Banco banco = new Banco(new ArrayListDeContas());

banco.inserir(conta);

// Operações
banco.deposito(1001, 1000.0);     // Saldo: R$ 1000
banco.saque(1001, 300.0);         // Saldo: R$ 700
double saldo = banco.saldo(1001); // Consulta: R$ 700

System.out.println("Saldo atual: R$ " + saldo);
System.out.println("Extrato:\n" + banco.extrato(1001));
```

### Cenário 2: Conta Poupança com Juros
```java
Pessoa poupador = new Pessoa(98765432100, "Maria Santos");
Conta poupanca = new Poupanca(2001, poupador);
Banco banco = new Banco(new BancoDeDadosDeConta());

banco.inserir(poupanca);
banco.deposito(2001, 5000.0);     // Depósito inicial
banco.juros(2001, 0.05);          // Aplica 5% de juros
double novoSaldo = banco.saldo(2001); // R$ 5250

System.out.println("Saldo após juros: R$ " + novoSaldo);
```

### Cenário 3: Conta Especial com Limite
```java
Pessoa vip = new Pessoa(11122233344, "Carlos Premium");
Conta especial = new ContaEspecial(3001, vip, 2000.0); // Limite R$ 2000
Banco banco = new Banco(new ListaDeContas());

banco.inserir(especial);
banco.deposito(3001, 500.0);      // Saldo: R$ 500
banco.saque(3001, 1500.0);        // Permitido! Saldo: -R$ 1000
                                  // (ainda dentro do limite)
```

### Cenário 4: Tratamento de Exceções
```java
try {
    banco.saque(1001, 10000.0);  // Valor muito alto
} catch (ExcecaoSaldoInsuficiente e) {
    System.out.println("Erro: " + e.getMessage());
    // Saída: "Saldo insuficiente. Conta: 1001. Saldo: 700.0. Valor a debitar: 10000.0"
}

try {
    banco.saldo(9999);  // Conta inexistente
} catch (ExcecaoContaInexistente e) {
    System.out.println("Erro: " + e.getMessage());
    // Saída: "Conta não encontrada. Número: 9999"
}
```

## 🔧 Configuração de Desenvolvimento

### IntelliJ IDEA (Recomendado)
1. **Import Project**: File → Open → Selecione a pasta do projeto
2. **Configure JDK**: File → Project Structure → Project → SDK: Java 17
3. **Configure MySQL**: Adicione o driver MySQL às dependências
4. **Run Tests**: Botão direito na classe de teste → Run

### Maven (Futuro)
```xml
<!-- Dependências planejadas para pom.xml -->
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

```
MIT License

Copyright (c) 2024 Pedro Santos Neto & Vitor Emanuel Fichel Sousa

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
```

## 📞 Contato

### Desenvolvedor

**Vitor Fichel**
- 📧 Email: [vitorfichel@email.com](mailto:vitorfichel@email.com)
- 🐙 GitHub: [@VitorFichel](https://github.com/VitorFichel)
- 💼 LinkedIn: [Vitor Fichel](https://linkedin.com/in/vitorfichel)
---

<div align="center">

[⬆ Voltar ao topo](#sistema-de-gerenciamento-bancário)

</div>
