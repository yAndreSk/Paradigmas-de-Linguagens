import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String entrada = args.length == 0
            ? "total_1mb = valor + 92;"
            : String.join(" ", args);

        System.out.println("ENTRADA: " + entrada);
        System.out.println();

        List<Token> tokens = new AnalisadorLexico(entrada).analisar();
        imprimirTokens(tokens);

        for (Token token : tokens) {
            if (token.getTipo() == TipoToken.ERRO_LEXICO) {
                System.out.println();
                System.out.println(
                    "ERRO: caractere desconhecido '" + token.getLexema() +
                    "' na posicao " + token.getPosicao() + "."
                );
                System.exit(1);
            }
        }

        try {
            new AnalisadorSintatico(tokens).analisar();
            System.out.println();
            System.out.println("RESULTADO: sentenca aceita pela gramatica.");
        } catch (IllegalArgumentException erro) {
            System.out.println();
            System.out.println("ERRO SINTATICO: " + erro.getMessage() + ".");
            System.exit(2);
        }
    }

    private static void imprimirTokens(List<Token> tokens) {
        System.out.printf("%-20s %-22s %s%n", "LEXEMA", "TOKEN", "POSICAO");
        System.out.println("--------------------------------------------------------");

        for (Token token : tokens) {
            if (token.getTipo() != TipoToken.EOF) {
                System.out.printf(
                    "%-20s %-22s %d%n",
                    token.getLexema(),
                    token.getTipo(),
                    token.getPosicao()
                );
            }
        }
    }
}
