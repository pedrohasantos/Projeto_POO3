import java.util.ArrayList;
import java.util.Random;

public class Aventureiro {
    private String nome;
    private int posicao;
    private int energia;
    private ArrayList<Tesouro> tesourosColetados;

    public Aventureiro(String nome) {
        this.nome = nome;
        this.posicao = 0; // Posição inicial
        this.energia = 10; // Energia inicial
        this.tesourosColetados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void mover(Labirinto labirinto, int base) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        Random rand = new Random();
        int novaPosicao = posicao + rand.nextInt(6) + 1; // Movendo aleatoriamente de 1 a 6 posições

        try {
            if (labirinto.isDentroDoLabirinto(novaPosicao, 0)) {
                this.posicao = novaPosicao;
                System.out.println(nome + " se moveu para a posição " + novaPosicao + ". Energia restante: " + energia);
                labirinto.atualizarPosicaoAventureiro(novaPosicao, base / 2); // Aventureiro move apenas para a direita, mantendo a mesma coluna
            } else {
                throw new Exception("Movimento inválido! Fora do labirinto.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void descansar() {
        if(energia>=10){
            System.out.println("você ja esta descansado, deixe de preguiça e siga seu caminho");
        }
        else{
            this.energia += 2;
            System.out.println(nome + " descansou e recuperou 2 de energia. Energia atual: " + energia);
        }
    }

    public void interagir(Labirinto labirinto) {
        System.out.println("Interagindo...");
    }
}
