import java.util.List;

public class ComandoRepetir implements Comando {
    final int vezes;
    final List<Comando> comandos;
    
    public ComandoRepetir(int vezes, List<Comando> comandos) {
        this.vezes = vezes;
        this.comandos = comandos;
    }
    
    @Override
    public void executar(Robo robo) {
        for (int i = 0; i < vezes; i++) {
            for (Comando comando : comandos) {
                comando.executar(robo);
            }
        }
    }
}
