import java.util.ArrayList;
import java.util.Random;

public class Labirinto {
    private char[][] piramide;
    private int base;
    private ArrayList<Tesouro> listaTesouros;
    private ArrayList<Armadilha> listaArmadilhas;

    public Labirinto(int dificuldade) {
        this.base = 2 * dificuldade - 1;
        this.piramide = new char[3][this.base];
        this.listaTesouros = new ArrayList<>();
        this.listaArmadilhas = new ArrayList<>();
        gerarLabirinto();
    }

    @SuppressWarnings("unused")
	public void gerarLabirinto() {
        Random rand = new Random();
        // Inicializando a pirâmide com espaços vazios
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.base; j++) {
                this.piramide[i][j] = ' ';
            }
        }
        // Adicionando posição inicial do aventureiro
        this.piramide[0][this.base / 2] = 'A';

        // Adicionando tesouros e armadilhas aleatoriamente
        for (int i = 0; i < 10; i++) {
            adicionarTesouro();
            adicionarArmadilha();
        }
    }

    public void adicionarTesouro() {
        Random rand = new Random();
        int linha = rand.nextInt(3);
        int coluna = rand.nextInt(this.base);
        if (this.piramide[linha][coluna] == ' ') {
            Tesouro tesouro = new Tesouro("Tesouro", coluna, rand.nextInt(100));
            this.listaTesouros.add(tesouro);
            this.piramide[linha][coluna] = 'T';
        }
    }

    public void adicionarArmadilha() {
        Random rand = new Random();
        int linha = rand.nextInt(3);
        int coluna = rand.nextInt(this.base);
        if (this.piramide[linha][coluna] == ' ') {
            Armadilha armadilha = new Armadilha(coluna, rand.nextInt(50));
            this.listaArmadilhas.add(armadilha);
            this.piramide[linha][coluna] = 'P';
        }
    }

    public void removerTesouro(Tesouro tesouro) {
        this.listaTesouros.remove(tesouro);
        this.piramide[tesouro.getPosicao()][0] = ' ';
    }

    public void printarLabirinto() {
        for (int i = 0; i < 3; i++) {
            // Imprimindo espaços vazios antes do início da pirâmide
            for (int j = 0; j < this.base - this.piramide[i].length; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < this.piramide[i].length; j++) {
                System.out.print(this.piramide[i][j] + ".");
            }
            System.out.println();
        }
    }
    public void atualizarPosicaoAventureiro(int linha, int coluna) {
        // Atualizar a posição do aventureiro na pirâmide
        this.piramide[linha][coluna] = 'A';
        // Remover a posição anterior do aventureiro
        for (int i = 0; i < base; i++) {
            if (this.piramide[linha][i] == 'A') {
                this.piramide[linha][i] = ' ';
                break;
            }
        }
    }

    public boolean isDentroDoLabirinto(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < this.base;
    }

    public ArrayList<Tesouro> getListaTesouros() {
        return this.listaTesouros;
    }

    public ArrayList<Armadilha> getListaArmadilhas() {
        return this.listaArmadilhas;
    }

    public void reiniciarJogo() {
        gerarLabirinto();
    }
}
