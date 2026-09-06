import java.util.List;

public final class AnalisadorSintatico {
    private final List<Token> tokens;
    private int atual;

    public AnalisadorSintatico(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void analisar() {
        programa();
    }

    private void programa() {
        declaracao();
        consumir(TipoToken.EOF, "Era esperado o fim da entrada");
    }

    private void declaracao() {
        corresponder(TipoToken.PALAVRA_RESERVADA);
        consumir(TipoToken.IDENTIFICADOR, "Era esperado um identificador");
        consumir(TipoToken.ATRIBUICAO, "Era esperado '=' depois do identificador");
        expressao();
        consumir(TipoToken.PONTO_E_VIRGULA, "Era esperado ';' ao final da declaração");
    }

    private void expressao() {
        termo();
        while (corresponder(TipoToken.SOMA, TipoToken.SUBTRACAO)) {
            termo();
        }
    }

    private void termo() {
        fator();
        while (corresponder(TipoToken.MULTIPLICACAO, TipoToken.DIVISAO)) {
            fator();
        }
    }

    private void fator() {
        if (corresponder(TipoToken.IDENTIFICADOR, TipoToken.INTEIRO)) {
            return;
        }

        if (corresponder(TipoToken.ABRE_PARENTESES)) {
            expressao();
            consumir(TipoToken.FECHA_PARENTESES, "Era esperado ')' depois da expressao");
            return;
        }

        Token token = verAtual();
        throw erro(token, "Era esperado um identificador, um inteiro ou '('");
    }

    private boolean corresponder(TipoToken... tipos) {
        for (TipoToken tipo : tipos) {
            if (verificar(tipo)) {
                avancar();
                return true;
            }
        }
        return false;
    }

    private Token consumir(TipoToken tipo, String mensagem) {
        if (verificar(tipo)) {
            return avancar();
        }
        throw erro(verAtual(), mensagem);
    }

    private boolean verificar(TipoToken tipo) {
        return verAtual().getTipo() == tipo;
    }

    private Token avancar() {
        if (verAtual().getTipo() != TipoToken.EOF) {
            atual++;
        }
        return tokens.get(atual - 1);
    }

    private Token verAtual() {
        return tokens.get(atual);
    }

    private IllegalArgumentException erro(Token token, String mensagem) {
        String encontrado = token.getTipo() == TipoToken.EOF
            ? "fim da entrada"
            : "'" + token.getLexema() + "'";
        return new IllegalArgumentException(
            mensagem + " na posicao " + token.getPosicao() +
            "; encontrado " + encontrado
        );
    }
}
