# Aula 003 - Derivação de código a partir da gramática de C#

## 1. Linguagem escolhida

A linguagem escolhida foi **C# (C Sharp)**, desenvolvida pela Microsoft. Sua especificação apresenta as regras sintáticas utilizadas para formar programas válidos.

## 2. Fonte da gramática

- [C# language specification - Grammar](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/language-specification/grammar)
- [C# language specification - Statements](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/language-specification/statements)

A especificação usa uma notação gramatical semelhante à EBNF. Para manter a derivação legível, foi selecionado apenas o subconjunto necessário para uma declaração de variável local.

## 3. Produções selecionadas

```text
<statement> ::= <declaration_statement>

<declaration_statement> ::= <local_variable_declaration> ;

<local_variable_declaration> ::=
    <explicitly_typed_local_variable_declaration>

<explicitly_typed_local_variable_declaration> ::=
    <type> <variable_declarator>

<variable_declarator> ::= <identifier> = <initializer>
<initializer> ::= <expression>
<type> ::= int
<identifier> ::= resultado
<expression> ::= <integer_literal>
<integer_literal> ::= 5
```

## 4. Código gerado

A sentença escolhida é:

```csharp
int resultado = 5;
```

Ela declara a variável `resultado`, do tipo `int`, e atribui a ela o valor inicial `5`. O arquivo [`Exemplo.cs`](Exemplo.cs) mostra a sentença dentro de um programa completo.

## 5. Derivação passo a passo

```text
<statement>
⇒ <declaration_statement>
⇒ <local_variable_declaration> ;
⇒ <explicitly_typed_local_variable_declaration> ;
⇒ <type> <variable_declarator> ;
⇒ int <variable_declarator> ;
⇒ int <identifier> = <initializer> ;
⇒ int resultado = <initializer> ;
⇒ int resultado = <expression> ;
⇒ int resultado = <integer_literal> ;
⇒ int resultado = 5 ;
```

Quando todos os símbolos não terminais são substituídos, resta a sentença válida `int resultado = 5;`.

## 6. Terminais e não terminais

### Não terminais

```text
<statement>
<declaration_statement>
<local_variable_declaration>
<explicitly_typed_local_variable_declaration>
<type>
<variable_declarator>
<identifier>
<initializer>
<expression>
<integer_literal>
```

### Terminais

```text
int
resultado
=
5
;
```

Os terminais são os elementos presentes na sentença final; os não terminais representam categorias que ainda precisam ser expandidas por uma produção.
