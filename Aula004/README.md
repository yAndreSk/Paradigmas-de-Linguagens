# Aula 004 - Análise léxica e sintática

Esta atividade implementa duas etapas básicas de um compilador para sentenças de declaração e atribuição com expressões aritméticas.

## Análise léxica

O analisador separa a entrada em lexemas e os classifica nos seguintes tokens:

- palavra reservada `int`;
- identificadores;
- números inteiros;
- atribuição (`=`);
- operadores aritméticos (`+`, `-`, `*` e `/`);
- parênteses;
- ponto e vírgula;
- erro léxico para caracteres não reconhecidos.

Identificadores podem começar com uma letra ou `_` e, depois, conter letras, números ou `_`. Assim, `total_1mb` é válido, enquanto `valor#` contém o caractere inválido `#`.

## Análise sintática

O analisador sintático usa descida recursiva e verifica a gramática simplificada:

```text
programa    → declaração EOF
declaração  → "int"? IDENTIFICADOR "=" expressão ";"
expressão   → termo (("+" | "-") termo)*
termo       → fator (("*" | "/") fator)*
fator       → IDENTIFICADOR | INTEIRO | "(" expressão ")"
```

A divisão em `expressão`, `termo` e `fator` garante que multiplicação e divisão tenham precedência sobre soma e subtração.

## Execução

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Sem argumentos, o programa analisa `total_1mb = valor + 92;`. Uma entrada diferente pode ser passada entre aspas:

```bash
java -cp out Main "int total = (valor + 10) * 2;"
```

Exemplo com erro léxico:

```bash
java -cp out Main "int valor# = 1;"
```
