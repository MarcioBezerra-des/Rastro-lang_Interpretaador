import java.util.List;
import java.util.ArrayList;

public class AnalisadorSintatico {
    private final List<Token> tokens;
    private int atual = 0;
    
    public AnalisadorSintatico(List<Token> tokens) {
        this.tokens = tokens;
    }
    
    public List<Comando> parse() {
        List<Comando> comandos = new ArrayList<>();
        while (!estaNoFim()) {
            comandos.add(comando());
        }
        return comandos;
    }
    
    private Comando comando() {
        if (conferir(TipoToken.MOVER)) {
            return cmdMover();
        }
        if (conferir(TipoToken.CANETA)) {
            return cmdCaneta();
        }
        if (conferir(TipoToken.REPETIR)) {
            return cmdRepetir();
        }
        throw new RuntimeException("Comando esperado.");
    }
    
    private Comando cmdMover() {
        consumir(TipoToken.MOVER, "Esperado 'MOVER'.");
        TipoToken direcao = direcao();
        Token numero = consumir(TipoToken.NUMERO, "Esperado número.");
        return new ComandoMover(direcao, (Integer) numero.literal);
    }
    
    private Comando cmdCaneta() {
        consumir(TipoToken.CANETA, "Esperado 'CANETA'.");
        if (conferir(TipoToken.CIMA)) {
            avancar();
            return new ComandoCaneta(TipoToken.CIMA);
        }
        if (conferir(TipoToken.BAIXO)) {
            avancar();
            return new ComandoCaneta(TipoToken.BAIXO);
        }
        throw new RuntimeException("Esperado 'CIMA' ou 'BAIXO'.");
    }
    
    private Comando cmdRepetir() {
        consumir(TipoToken.REPETIR, "Esperado 'REPETIR'.");
        Token numero = consumir(TipoToken.NUMERO, "Esperado número.");
        consumir(TipoToken.ABRE_CHAVE, "Esperado '{'.");
        List<Comando> comandos = new ArrayList<>();
        while (!conferir(TipoToken.FECHA_CHAVE) && !estaNoFim()) {
            comandos.add(comando());
        }
        consumir(TipoToken.FECHA_CHAVE, "Esperado '}'.");
        return new ComandoRepetir((Integer) numero.literal, comandos);
    }
    
    private TipoToken direcao() {
        if (conferir(TipoToken.FRENTE)) {
            avancar();
            return TipoToken.FRENTE;
        }
        if (conferir(TipoToken.DIREITA)) {
            avancar();
            return TipoToken.DIREITA;
        }
        if (conferir(TipoToken.ESQUERDA)) {
            avancar();
            return TipoToken.ESQUERDA;
        }
        if (conferir(TipoToken.CIMA)) {
            avancar();
            return TipoToken.CIMA;
        }
        throw new RuntimeException("Direção esperada.");
    }
    
    private boolean conferir(TipoToken tipo) {
        if (estaNoFim()) return false;
        return olhar().tipo == tipo;
    }
    
    private Token olhar() {
        return tokens.get(atual);
    }
    
    private Token avancar() {
        if (!estaNoFim()) atual++;
        return anterior();
    }
    
    private Token anterior() {
        return tokens.get(atual - 1);
    }
    
    private boolean estaNoFim() {
        return olhar().tipo == TipoToken.FIM_DE_ARQUIVO;
    }
    
    private Token consumir(TipoToken tipo, String mensagem) {
        if (conferir(tipo)) return avancar();
        throw new RuntimeException(mensagem);
    }
}
