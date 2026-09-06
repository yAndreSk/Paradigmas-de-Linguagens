public final class Token {
    private final TipoToken tipo;
    private final String lexema;
    private final int posicao;

    public Token(TipoToken tipo, String lexema, int posicao) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.posicao = posicao;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public int getPosicao() {
        return posicao;
    }
}
