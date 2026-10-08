# Aula 008 - Subprogramas e parâmetros

## 1. Python: parâmetro padrão mutável

### Código
```python
def adicionar(item, lista=[]):
    lista.append(item)
    return lista

print(adicionar(1))
print(adicionar(2))
```

### Saída
```text
[1]
[1, 2]
```

**Explicação:** o valor padrão é criado uma vez, quando a função é definida. Como a lista é mutável, as chamadas compartilham o mesmo objeto. Uma alternativa segura é usar `None` como padrão e criar a lista dentro da função.

## 2. Java: passagem de parâmetros

### Saída
```text
0 5
```

**Explicação:** Java sempre passa argumentos por valor. Para o parâmetro `int n`, a função recebe uma cópia do número, então atribuir `n = 0` não altera a variável original. Para o array, a cópia é da referência; os dois lados continuam apontando para o mesmo array, então `v[0] = 0` é visível fora do método.

## 3. Python: closures e late binding

### Código
```python
fs = [lambda: i for i in range(3)]
print([f() for f in fs])
```

### Saída
```text
[2, 2, 2]
```

**Explicação:** cada lambda captura a variável `i`, não uma cópia do valor atual. Quando as funções são chamadas, o laço terminou e `i` vale 2. Para capturar o valor de cada iteração, pode-se escrever `lambda i=i: i`.

## 4. C: variável local estática

### Código
```c
#include <stdio.h>

int contador(void) {
    static int n = 0;
    return ++n;
}

int main(void) {
    contador();
    contador();
    printf("%d\n", contador());
}
```

### Saída
```text
3
```

**Explicação:** a variável `static` local é inicializada uma vez e mantém seu valor entre as chamadas da função. Seu escopo continua restrito a `contador`, mas seu tempo de vida é o do programa.

## 5. Rust: ownership e move

O exemplo que passa um `Vec` por valor para a função transfere a propriedade do vetor. Depois da chamada, a variável original não pode ser usada; tentar imprimi-la gera erro de compilação por valor movido. Para manter acesso ao vetor, a função pode receber uma referência (`&Vec<i32>` ou, preferencialmente, uma fatia `&[i32]`) ou pode-se clonar o vetor.

A função que dobra os valores produz, para a entrada `[1, 2, 3]`, o vetor `[2, 4, 6]`.

## 6. Python: escopo global

### Código
```python
total = 0

def adiciona(x):
    global total
    total = total + x
    return total

print(adiciona(5))
```

### Saída
```text
5
```

**Explicação:** a declaração `global total` informa que a função deve usar a variável definida no escopo global. Sem essa declaração, a atribuição tornaria `total` local e a leitura do lado direito antes da atribuição causaria `UnboundLocalError`.

## Conclusão

Os exemplos abordam parâmetros padrão mutáveis, passagem por valor, closures, duração de variáveis, ownership e escopo. São regras que afetam diretamente o resultado e a segurança dos programas.
