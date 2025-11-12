public class ComandoMover implements Comando {
    final TipoToken direcao;
    final int passos;
    
    public ComandoMover(TipoToken direcao, int passos) {
        this.direcao = direcao;
        this.passos = passos;
    }
    
    @Override
    public void executar(Robo robo) {
        robo.mover(direcao, passos);
    }
}
