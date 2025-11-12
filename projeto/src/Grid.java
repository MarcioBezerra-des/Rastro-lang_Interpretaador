public class Grid {
    char[][] tela;
    
    public Grid() {
        tela = new char[50][50];
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                tela[i][j] = '.';
            }
        }
    }
    
    public void desenhar(int x, int y) {
        try {
            tela[y][x] = '*';
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
    
    public void imprimir() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                System.out.print(tela[i][j]);
            }
            System.out.println();
        }
    }
}
