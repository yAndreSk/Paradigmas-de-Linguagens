# Aula 007 - Expressões, atribuição e estruturas de controle

Material complementar baseado nos slides da aula. O foco é entender como precedência, conversões, curto-circuito e estruturas de controle afetam a execução.

## Principais conceitos

- **Precedência e associatividade:** definem como uma expressão é agrupada. Use parênteses quando houver risco de ambiguidade.
- **Ordem de avaliação:** efeitos colaterais podem fazer com que a ordem de avaliação altere o resultado.
- **Conversão de tipos:** conversões implícitas podem perder precisão ou esconder erros.
- **Curto-circuito:** em expressões booleanas, a segunda parte pode não ser avaliada quando o resultado já é conhecido.
- **Atribuição:** em algumas linguagens é uma expressão; em outras, é apenas uma instrução.
- **Seleção e repetição:** `switch`, `if`, `for` e `while` têm regras diferentes entre linguagens. Atenção a `break`, sombreamento de variáveis e laços sem progresso.

## Estudos de caso dos slides

### 1. JavaScript: percorrer valores ou chaves

O `for...in` percorre as chaves/índices de um array. Somar essas chaves pode concatenar strings e produzir `0012`, em vez da soma dos valores. Para percorrer valores, use `for...of`.

### 2. Python: valor padrão zero

Uma expressão como `d or 10` substitui o desconto zero por 10, pois zero é considerado falso. Se apenas a ausência do valor deve ativar o padrão, use `10 if d is None else d`.

### 3. Java: queda entre casos de switch

Em um `switch` tradicional, a ausência de `break` pode executar os casos seguintes. Inclua `break` quando necessário ou use a sintaxe moderna com `->`.

### 4. C: ponto e vírgula após if

Em `if (condicao); { ... }`, o ponto e vírgula forma uma instrução vazia controlada pelo `if`, enquanto o bloco seguinte executa independentemente. Remova o ponto e vírgula e use chaves para deixar o fluxo explícito.

### 5. Go: sombreamento de variável

Dentro de um bloco, `x := ...` pode declarar uma nova variável local em vez de alterar a variável externa. Para modificar a variável existente, use `x = ...`.

### 6. Java: divisão inteira

A expressão `7 / 10` entre inteiros resulta em `0`; converter esse resultado depois para `double` não recupera a parte decimal. Use `7 * 100.0 / 10` ou converta um dos operandos antes da divisão.

## Conclusão

A indentação não muda as regras sintáticas por si só em linguagens como C e Java. Parênteses, chaves, tipos explícitos e atenção aos valores falsos ajudam a evitar bugs e tornam o código mais previsível.
