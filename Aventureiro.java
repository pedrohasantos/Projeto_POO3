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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public ArrayList<Tesouro> getTesourosColetados() {
        return tesourosColetados;
    }

    public void mover(Labirinto labirinto) {
        if (energia <= 0) {
            System.out.println("Energia insuficiente para mover.");
            return;
        }

        Random rand = new Random();
        int novaPosicao = posicao + rand.nextInt(6) + 1;

        try {
            if (labirinto.isDentroDoLabirinto(novaPosicao)) {
                this.posicao = novaPosicao;
                this.energia -= 1;
                System.out.println(nome + " se moveu para a posição " + novaPosicao + ". Energia restante: " + energia);

                // Verificar armadilha
                for (Armadilha armadilha : labirinto.getListaArmadilhas()) {
                    if (armadilha.getPosicao() == novaPosicao) {
                        System.out.println("Você caiu em uma armadilha! Dano: " + armadilha.getDano());
                        this.energia -= 1;
                        if (this.energia <= 0) {
                            System.out.println("Você morreu!");
                            reiniciarJogo(labirinto);
                            return;
                        }
                        break;
                    }
                }

                // Verificar tesouro
                for (Tesouro tesouro : labirinto.getListaTesouros()) {
                    if (tesouro.getPosicao() == novaPosicao) {
                        System.out.println("Você encontrou um tesouro: " + tesouro.getNome());
                        break;
                    }
                }
            } else {
                throw new Exception("Movimento inválido! Fora do labirinto.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void descansar() {
        this.energia += 2;
        System.out.println(nome + " descansou e recuperou 2 de energia. Energia atual: " + energia);
    }

    public void interagir(Labirinto labirinto) {
        for (Tesouro tesouro : labirinto.getListaTesouros()) {
            if (tesouro.getPosicao() == posicao) {
                tesourosColetados.add(tesouro);
                labirinto.removerTesouro(tesouro);
                System.out.println(nome + " coletou " + tesouro.getNome());
                return;
            }
        }
        System.out.println("Nenhum tesouro para coletar nesta posição.");
    }

    private void reiniciarJogo(Labirinto labirinto) {
        this.posicao = 0;
        this.energia = 10;
        this.tesourosColetados.clear();
        labirinto.gerarLabirinto();
        System.out.println("O jogo foi reiniciado. Boa sorte, " + nome + "!");
    }
}
