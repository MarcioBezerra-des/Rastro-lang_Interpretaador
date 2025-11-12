import java.util.List;

public class Interpretador {
    private final Robo robo;
    private final Grid grid;
    
    public Interpretador() {
        this.robo = new Robo();
        this.grid = new Grid();
    }
    
    public void interpretar(List<Comando> ast) {
        for (Comando cmd : ast) {
            cmd.executar(robo);
            if (robo.isCanetaBaixa()) {
                grid.desenhar(robo.getX(), robo.getY());
            }
        }
        grid.imprimir();
    }
}
