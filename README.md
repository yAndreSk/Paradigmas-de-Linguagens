# Paradigmas de Linguagens

Repositório de atividades da disciplina **Paradigmas de Linguagens de Programação**.

## Organização das aulas

| Aula | Conteúdo | Arquivos principais |
| --- | --- | --- |
| [Aula 000](Aula000/) | Pesquisa sobre Delphi/Object Pascal, paradigmas e primeiros programas | `Atividade.md`, `OlaMundo.pas` e `Tabuada.pas` |
| [Aula 002](Aula002/) | História, evolução e paradigmas das linguagens de programação | `Atividade.md` |
| [Aula 003](Aula003/) | Gramática formal e derivação de uma instrução em C# | `Atividade.md` e `Exemplo.cs` |
| [Aula 004](Aula004/) | Análise léxica e sintática de uma atribuição | `README.md` e código Java em `src/` |

> A numeração segue a sequência das atividades disponibilizadas na disciplina; por isso não há uma pasta `Aula001` neste repositório.

## Como executar os exemplos

### Object Pascal

Com o Free Pascal instalado:

```bash
fpc Aula000/OlaMundo.pas
fpc Aula000/Tabuada.pas
```

### C#

O arquivo `Aula003/Exemplo.cs` pode ser executado em uma instalação do .NET SDK ou em um compilador C# on-line.

### Java

Dentro da pasta `Aula004`:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Também é possível informar outra sentença para análise:

```bash
java -cp out Main "int resultado = valor + 92;"
```
