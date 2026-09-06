import java.util.ArrayList;
import java.util.List;

public final class AnalisadorLexico {
    private final String fonte;
    private final List<Token> tokens = new ArrayList<Token>();
    private int atual;

    public AnalisadorLexico(String fonte) {
        this.fonte = fonte;
    }

    public List<Token> analisar() {
        while (!estaNoFim()) {
            char caractere = avancar();

            if (Character.isWhitespace(caractere)) {
                continue;
            }

            if (Character.isLetter(caractere) || caractere == '_') {
                identificador();
            } else if (Character.isDigit(caractere)) {
                inteiro();
            } else {
                simbolo(caractere);
            }
        }

        tokens.add(new Token(TipoToken.EOF, "", atual));
        return tokens;
    }

    private void identificador() {
        int inicio = atual - 1;
        while (!estaNoFim()) {
            char caractere = fonte.charAt(atual);
            if (!Character.isLetterOrDigit(caractere) && caractere != '_') {
                break;
            }
            atual++;
        }

        String lexema = fonte.substring(inicio, atual);
        TipoToken tipo = "int".equals(lexema)
            ? TipoToken.PALAVRA_RESERVADA
            : TipoToken.IDENTIFICADOR;
        tokens.add(new Token(tipo, lexema, inicio));
    }

    private void inteiro() {
        int inicio = atual - 1;
        while (!estaNoFim() && Character.isDigit(fonte.charAt(atual))) {
            atual++;
        }
        tokens.add(new Token(
            TipoToken.INTEIRO,
            fonte.substring(inicio, atual),
            inicio
        ));
    }

    private void simbolo(char caractere) {
        TipoToken tipo;

        switch (caractere) {
            case '=':
                tipo = TipoToken.ATRIBUICAO;
                break;
            case '+':
                tipo = TipoToken.SOMA;
                break;
            case '-':
                tipo = TipoToken.SUBTRACAO;
                break;
            case '*':
                tipo = TipoToken.MULTIPLICACAO;
                break;
            case '/':
                tipo = TipoToken.DIVISAO;
                break;
            case '(':
                tipo = TipoToken.ABRE_PARENTESES;
                break;
            case ')':
                tipo = TipoToken.FECHA_PARENTESES;
                break;
            case ';':
                tipo = TipoToken.PONTO_E_VIRGULA;
                break;
            default:
                tipo = TipoToken.ERRO_LEXICO;
                break;
        }

        tokens.add(new Token(tipo, String.valueOf(caractere), atual - 1));
    }

    private char avancar() {
        return fonte.charAt(atual++);
    }

    private boolean estaNoFim() {
        return atual >= fonte.length();
    }
}
