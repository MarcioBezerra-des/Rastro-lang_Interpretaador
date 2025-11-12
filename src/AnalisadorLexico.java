import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalisadorLexico {
    private static final Map<String, TipoToken> palavrasChave;
    
    static {
        palavrasChave = new HashMap<>();
        palavrasChave.put("CANETA", TipoToken.CANETA);
        palavrasChave.put("MOVER", TipoToken.MOVER);
        palavrasChave.put("REPETIR", TipoToken.REPETIR);
        palavrasChave.put("CIMA", TipoToken.CIMA);
        palavrasChave.put("BAIXO", TipoToken.BAIXO);
        palavrasChave.put("FRENTE", TipoToken.FRENTE);
        palavrasChave.put("DIREITA", TipoToken.DIREITA);
        palavrasChave.put("ESQUERDA", TipoToken.ESQUERDA);
    }
    
    private final String codigoFonte;
    private final List<Token> tokens = new ArrayList<>();
    private int inicio = 0;
    private int atual = 0;
    
    public AnalisadorLexico(String codigoFonte) {
        this.codigoFonte = codigoFonte;
    }
    
    public List<Token> scanTokens() {
        while (!estaNoFim()) {
            inicio = atual;
            scanToken();
        }
        
        tokens.add(new Token(TipoToken.FIM_DE_ARQUIVO, "", null));
        return tokens;
    }
    
    private void scanToken() {
        char c = avancar();
        switch (c) {
            case '{':
                adicionarToken(TipoToken.ABRE_CHAVE);
                break;
            case '}':
                adicionarToken(TipoToken.FECHA_CHAVE);
                break;
            case ' ':
            case '\r':
            case '\t':
                break;
            case '\n':
                break;
            case '/':
                if (conferir('/')) {
                    while (olhar() != '\n' && !estaNoFim()) avancar();
                }
                break;
            default:
                if (eDigito(c)) {
                    numero();
                } else if (eLetra(c)) {
                    identificador();
                } else {
                    throw new RuntimeException("Caractere inesperado.");
                }
                break;
        }
    }
    
    private void numero() {
        while (eDigito(olhar())) avancar();
        
        String texto = codigoFonte.substring(inicio, atual);
        adicionarToken(TipoToken.NUMERO, Integer.parseInt(texto));
    }
    
    private void identificador() {
        while (eLetraOuDigito(olhar())) avancar();
        
        String texto = codigoFonte.substring(inicio, atual);
        TipoToken tipo = palavrasChave.get(texto);
        
        if (tipo == null) {
            throw new RuntimeException("Palavra-chave desconhecida.");
        }
        
        adicionarToken(tipo);
    }
    
    private boolean conferir(char esperado) {
        if (estaNoFim()) return false;
        if (codigoFonte.charAt(atual) != esperado) return false;
        
        atual++;
        return true;
    }
    
    private char olhar() {
        if (estaNoFim()) return '\0';
        return codigoFonte.charAt(atual);
    }
    
    private char avancar() {
        return codigoFonte.charAt(atual++);
    }
    
    private void adicionarToken(TipoToken tipo) {
        adicionarToken(tipo, null);
    }
    
    private void adicionarToken(TipoToken tipo, Object literal) {
        String texto = codigoFonte.substring(inicio, atual);
        tokens.add(new Token(tipo, texto, literal));
    }
    
    private boolean estaNoFim() {
        return atual >= codigoFonte.length();
    }
    
    private boolean eDigito(char c) {
        return c >= '0' && c <= '9';
    }
    
    private boolean eLetra(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_';
    }
    
    private boolean eLetraOuDigito(char c) {
        return eLetra(c) || eDigito(c);
    }
}
