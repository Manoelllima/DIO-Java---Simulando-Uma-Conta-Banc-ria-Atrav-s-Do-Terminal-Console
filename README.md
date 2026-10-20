# Conta Banco

Pequeno projeto de terminal feito em Java para simular operações básicas de uma conta bancária. O programa permite criar uma conta, consultá-la pelo CPF, realizar depósitos e verificar o saldo.

## Requisitos

- Java JDK instalado

## Como executar

Abra o terminal nesta pasta e compile o arquivo:

```bash
javac ContaTerminal.java
```

Em seguida, execute o programa:

```bash
java ContaTerminal
```

## Como usar

No menu inicial:

1. Escolha **Criar conta** e informe seu nome e CPF. A conta é criada com saldo inicial zero e recebe um número aleatório.
2. Escolha **Consultar** e informe o CPF cadastrado.
3. No menu da conta, escolha entre depositar, consultar o saldo ou sair.

## Observações

- Os dados da conta ficam apenas na memória durante a execução; ao fechar o programa, eles são perdidos.
- Esta é uma aplicação de estudo, sem persistência de dados ou validação completa das informações.
