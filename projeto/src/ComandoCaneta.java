public class ComandoCaneta implements Comando {
    final TipoToken estado;
    
    public ComandoCaneta(TipoToken estado) {
        this.estado = estado;
    }
    
    @Override
    public void executar(Robo robo) {
        robo.setCaneta(estado);
    }
}
