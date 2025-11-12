public class Robo {
    int x = 0;
    int y = 0;
    boolean canetaBaixa = false;
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean isCanetaBaixa() {
        return canetaBaixa;
    }
    
    public void setCaneta(TipoToken estado) {
        if (estado == TipoToken.BAIXO) {
            canetaBaixa = true;
        } else if (estado == TipoToken.CIMA) {
            canetaBaixa = false;
        }
    }
    
    public void mover(TipoToken direcao, int passos) {
        if (direcao == TipoToken.FRENTE) {
            y += passos;
        } else if (direcao == TipoToken.CIMA) {
            y -= passos;
        } else if (direcao == TipoToken.DIREITA) {
            x += passos;
        } else if (direcao == TipoToken.ESQUERDA) {
            x -= passos;
        }
    }
}
