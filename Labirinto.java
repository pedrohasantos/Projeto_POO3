import java.util.ArrayList;
import java.util.Random;

public class Labirinto {
    private char[] labirinto;
    private int tamanho;
    private ArrayList<Tesouro> listaTesouros;
    private ArrayList<Armadilha> listaArmadilhas;

    public Labirinto(int tamanho) {
        this.tamanho = tamanho;
        this.labirinto = new char[tamanho];
        this.listaTesouros = new ArrayList<>();
        this.listaArmadilhas = new ArrayList<>();
        gerarLabirinto();
    }

    public void gerarLabirinto() {
        Random rand = new Random();
        for (int i = 0; i < labirinto.length; i++) {
            labirinto[i] = '.';
        }
        // Adicionar posição inicial do aventureiro
        labirinto[0] = 'A';

        // Adicionar tesouros e armadilhas aleatoriamente
        for (int i = 0; i < 10; i++) {
            adicionarTesouro();
            adicionarArmadilha();
        }
    }

    public void adicionarTesouro() {
        Random rand = new Random();
        int posicao = rand.nextInt(labirinto.length);
        if (labirinto[posicao] == '.') {
            Tesouro tesouro = new Tesouro("Tesouro", posicao, rand.nextInt(100));
            listaTesouros.add(tesouro);
            labirinto[posicao] = 'T';
        }
    }

    public void adicionarArmadilha() {
        Random rand = new Random();
        int posicao = rand.nextInt(labirinto.length);
        if (labirinto[posicao] == '.') {
            Armadilha armadilha = new Armadilha(posicao, rand.nextInt(50));
            listaArmadilhas.add(armadilha);
            labirinto[posicao] = 'P';
        }
    }

    public void removerTesouro(Tesouro tesouro) {
        listaTesouros.remove(tesouro);
        labirinto[tesouro.getPosicao()] = '.';
    }

    public void printarLabirinto() {
        for (int i = 0; i < labirinto.length; i++) {
            System.out.print(labirinto[i] + " ");
        }
        System.out.println();
    }

    public boolean isDentroDoLabirinto(int posicao) {
        return posicao >= 0 && posicao < tamanho;
    }

    public ArrayList<Tesouro> getListaTesouros() {
        return listaTesouros;
    }

    public ArrayList<Armadilha> getListaArmadilhas() {
        return listaArmadilhas;
    }
}
