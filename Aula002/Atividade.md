# Aula 002 - História e evolução das linguagens

## 1. A genealogia das linguagens não é uma escada de progresso

A genealogia das linguagens não representa uma sequência em que cada novidade torna todas as anteriores inúteis. Uma linguagem costuma preservar ideias já conhecidas, adaptar conceitos para um novo contexto e conviver com suas antecessoras.

Dois fatores históricos ajudam a explicar isso:

1. **Necessidades diferentes:** Fortran foi direcionada ao cálculo científico, enquanto COBOL priorizou o processamento de dados comerciais. Uma não substituiu a outra porque resolviam problemas distintos.
2. **Reaproveitamento de conceitos:** ALGOL influenciou a estrutura sintática de Pascal e C. Essas linguagens seguiram caminhos próprios, mas conservaram conceitos de blocos, controle de fluxo e organização do programa.

## 3. Short Code, Speedcoding e A-0/A-1/A-2

O **Short Code** representava expressões matemáticas por códigos simbólicos, interpretados durante a execução. O **Speedcoding** oferecia pseudoinstruções e uma forma de máquina virtual para facilitar cálculos em computadores IBM. Já os sistemas **A-0, A-1 e A-2**, associados a Grace Hopper, expandiam chamadas simbólicas usando rotinas de máquina previamente disponíveis.

Chamá-los simplesmente de compiladores modernos seria impreciso. Short Code e Speedcoding dependiam principalmente de interpretação, enquanto os sistemas A realizavam uma ligação/expansão de sub-rotinas. Um compilador moderno costuma traduzir uma linguagem-fonte completa, realizar análises e produzir um programa-alvo independente.

## 4. A aceitação do Fortran

Programadores da época escreviam diretamente em código de máquina e desconfiavam que uma tradução automática produziria programas lentos. Como o tempo de processamento dos computadores era caro, o compilador Fortran precisava gerar código próximo do desempenho obtido manualmente.

Ao mesmo tempo, programar em uma linguagem de nível mais alto reduzia muito o tempo, o esforço e o custo de desenvolvimento. A adoção do Fortran cresceu quando ficou claro que essa economia podia ser obtida sem uma perda significativa de desempenho.

## 8. BASIC e PL/I

O **BASIC** buscou ampliar o acesso à programação por meio de comandos simples e fácil aprendizado. Seu compromisso de projeto foi trocar parte da expressividade e da estrutura necessária a grandes sistemas por simplicidade para iniciantes.

O **PL/I** tentou atender, em uma única linguagem, aplicações científicas, comerciais e de sistemas. O compromisso foi o inverso: ganhou abrangência e muitos recursos, mas se tornou maior, mais complexa e mais difícil de dominar.

## 10. Ortogonalidade e ALGOL 68

Ortogonalidade é a possibilidade de combinar recursos de uma linguagem de maneira uniforme, com poucas exceções. No ALGOL 68, tipos e construções podiam ser combinados de forma bastante regular.

Regularidade, porém, não significa simplicidade. Uma linguagem pode ter regras consistentes e ainda oferecer tantas combinações e conceitos que seu aprendizado se torne difícil. Portanto, uma linguagem muito ortogonal não é automaticamente fácil de usar.

## 11. Influência de ALGOL, Pascal e C e o contraste com Prolog

Uma cadeia possível é **ALGOL → Pascal** e **ALGOL → C**. ALGOL consolidou a programação estruturada em blocos. Pascal adotou essa tradição com foco didático, tipos claros e estruturas bem definidas. C também herdou blocos e controle estruturado, mas acrescentou operações de baixo nível e uma sintaxe mais compacta.

Essa linhagem é predominantemente imperativa: o programa descreve uma sequência de comandos que altera o estado da memória. Prolog segue uma proposta declarativa. Nele, o programador informa fatos e regras, e o mecanismo de inferência procura provar uma consulta.

## 12. Pequena base em Prolog

Em linguagem Prolog, uma base simples poderia ser:

```prolog
pai(carlos, joao).
pai(joao, ana).

avo(X, Z) :- pai(X, Y), pai(Y, Z).

?- avo(carlos, ana).
```

Os dois primeiros elementos são fatos, `avo` é uma regra e a última linha é uma consulta. Isso representa programação lógica porque não armazena apenas dados: o sistema combina fatos e regras, realiza inferências e conclui que Carlos é avô de Ana.

## 13. Ada e os sistemas críticos

Ada foi projetada para sistemas em que uma falha pode causar consequências graves, como aviônica, defesa e transporte. Sua tipagem forte ajuda a detectar incompatibilidades; os pacotes promovem encapsulamento e separação de responsabilidades; e os recursos de concorrência permitem coordenar tarefas simultâneas de forma controlada.

Esses mecanismos favorecem verificação, manutenção e previsibilidade. Embora aumentem o rigor e possam tornar a linguagem extensa, são adequados a domínios que valorizam confiabilidade acima de rapidez informal de desenvolvimento.

## 15. A mudança de contexto da linguagem Java

Java foi inicialmente pensada para dispositivos eletrônicos de consumo. Quando esse mercado não se desenvolveu como esperado e a Web ganhou importância, sua portabilidade e a ideia de executar o mesmo bytecode em diferentes plataformas encontraram um novo uso nos navegadores, especialmente por meio de applets.

O caso mostra que uma tecnologia pode ser reposicionada quando o contexto muda: características antes destinadas a um domínio passam a resolver necessidades de outro, alterando o público e acelerando a adoção da linguagem.

## 18. XSLT e JSP

O **XSLT** recebe um documento XML e uma folha de transformação. Um processador aplica templates e regras para produzir outro documento, como XML, HTML ou texto.

O **JSP** recebe uma página com marcação e elementos processados no servidor. Essa página é traduzida para um servlet, executada com os dados da requisição e gera conteúdo, normalmente HTML, enviado ao navegador.

Ambas são híbridas porque misturam marcação com mecanismos de programação. XSLT inclui seleção, templates e controle da transformação; JSP combina a estrutura de uma página com expressões, tags e lógica executada no servidor.
