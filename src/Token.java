public class Token {
    final TipoToken tipo;
    final String lexema;
    final Object literal;

    public Token(TipoToken tipo, String lexema, Object literal) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.literal = literal;
    }

    @Override
    public String toString() {
        return "Token{tipo=" + tipo + ", lexema='" + lexema + "', literal=" + literal + "}";
    }
}
