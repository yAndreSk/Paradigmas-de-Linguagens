# Aula 009 - Vinculação e polimorfismo

## 1. Java: sobrescrita e despacho dinâmico

**Saída:** `au`

Se uma variável do tipo `Animal` aponta para um objeto `Cachorro` e o método `som()` é sobrescrito em `Cachorro`, a chamada usa a implementação do objeto real. Isso é despacho dinâmico.

## 2. C++: método não virtual

**Saída:** `A`

Se `f()` não é declarado como `virtual` na classe base, a chamada por um ponteiro `A*` é vinculada estaticamente ao método de `A`, mesmo que o objeto real seja da classe `B`. Declarando `virtual` em `A`, a chamada passa a usar a implementação de `B`.

## 3. Java: campos e métodos

**Saída:** `A B`

Campos não usam despacho dinâmico: `x.nome` é resolvido pelo tipo declarado da referência (`A`) e imprime `A`. Já `x.getNome()` é uma chamada de método sobrescrito e é despachada para a classe real (`B`), imprimindo `B`.

## 4. Python: atributo de classe

**Saída:** `1 2 2`

O atributo `total` pertence à classe e é compartilhado pelas instâncias. Ao criar `a`, o total passa a 1 e esse valor é copiado para `a.id`. Ao criar `b`, o total passa a 2 e é copiado para `b.id`. Por isso, `a.id` é 1, `b.id` é 2 e `a.total` consulta o atributo da classe, que vale 2.

## 5. Java: método estático escondido

**Saída:** `A`

Métodos `static` pertencem à classe e não participam do despacho dinâmico. Se `B` declara outro método estático com o mesmo nome, ele esconde o método de `A`, mas a chamada `x.quem()` é resolvida pelo tipo declarado de `x`, que é `A`.

## 6. Go: embedding não é herança

**Saída:** `faz... au`

A estrutura `Cao` embute `Animal`, promovendo seus métodos. A chamada `Cao{}.Falar()` executa o método promovido de `Animal`; dentro dele, o receptor continua sendo `Animal`, então `a.Som()` chama `Animal.Som()` e retorna `...`. Já `Cao{}.Som()` chama diretamente o método de `Cao`, que retorna `au`.

Embedding em Go é composição com promoção de métodos, não herança com despacho virtual.

## Conclusão

Os exemplos diferenciam vinculação estática e dinâmica, sobrescrita de métodos, ocultação de métodos estáticos, resolução de campos e composição em Go. É importante separar o tipo declarado da referência do tipo real do objeto.
