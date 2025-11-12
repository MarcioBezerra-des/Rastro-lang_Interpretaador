import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Compilador {
    public static void main(String[] args) throws java.io.IOException {
        if (args.length != 1) {
            System.out.println("Uso: java Compilador [arquivo.rastro]");
            System.exit(1);
        }
        
        byte[] bytes = Files.readAllBytes(Paths.get(args[0]));
        String codigoFonte = new String(bytes);
        
        AnalisadorLexico lexico = new AnalisadorLexico(codigoFonte);
        List<Token> tokens = lexico.scanTokens();
        
        AnalisadorSintatico sintatico = new AnalisadorSintatico(tokens);
        List<Comando> ast = sintatico.parse();
        
        Interpretador interpretador = new Interpretador();
        interpretador.interpretar(ast);
    }
}
