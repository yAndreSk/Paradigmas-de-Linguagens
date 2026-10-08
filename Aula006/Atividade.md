# Aula 006 - Tipos de dados e comportamento das linguagens

Resolução dos seis exemplos da atividade. Os resultados podem variar em casos de comportamento indefinido ou detalhes de implementação, conforme indicado.

## 1. JavaScript

### Código
```javascript
console.log(0.1 * 3 === 0.3);
console.log(9007199254740993);
```

### Saída
```text
false
9007199254740992
```

**Explicação:** números de ponto flutuante são representados em binário e alguns decimais não têm representação exata. Além disso, o tipo `Number` representa inteiros com exatidão apenas até `Number.MAX_SAFE_INTEGER` (2⁵³ − 1). O literal maior é arredondado.

## 2. Python

### Código
```python
p = "maçã"
print(len(p), len(p.encode()))
```

### Saída
```text
4 5
```

**Explicação:** `len(p)` conta os caracteres Unicode da string. Já `encode()` converte a string para bytes UTF-8: o caractere `ç` ocupa dois bytes, então o total é cinco.

## 3. Go

### Código
```go
package main
import "fmt"

func main() {
    var b byte = 255
    b++
    fmt.Println(b)
}
```

### Saída
```text
0
```

**Explicação:** `byte` é um alias de `uint8`, que possui oito bits. A aritmética de inteiros sem sinal transborda de forma modular; depois de 255, o valor volta a 0.

## 4. Java

O vetor tem três posições, com índices válidos de 0 a 2. Ao tentar acessar `v[3]`, o programa lança `ArrayIndexOutOfBoundsException`. O acesso inválido interrompe o fluxo normal, a menos que a exceção seja tratada.

## 5. Rust

Quando o código faz `let t = s` com uma `String`, a propriedade do valor é movida para `t`. A variável `s` não pode mais ser usada depois do movimento. Tentar imprimi-la causa erro de compilação por uso de valor movido. Se for necessário manter os dois valores, pode-se usar `s.clone()`.

## 6. C

Em uma `union`, os membros compartilham a mesma região de memória. Se `1.0` for gravado no membro `float` e os mesmos bits forem lidos pelo membro `int`, em plataformas comuns o resultado costuma ser `1065353216`. Porém, interpretar um membro diferente do último gravado depende das regras da linguagem e da implementação; não é uma forma portátil de conversão numérica. Para converter o valor, use um cast apropriado, não uma leitura alternativa da união.

## Conclusão

Os exemplos mostram diferenças importantes entre linguagens: precisão numérica, representação de texto, limites de tipos inteiros, verificação de índices, propriedade de memória e representação binária. Entender essas regras ajuda a prever saídas e evitar erros difíceis de encontrar.
