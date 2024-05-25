public class Tesouro {
    private String nome;
    private int posicao;
    private int pontos;

    public Tesouro(String nome, int posicao, int pontos) {
        this.nome = nome;
        this.posicao = posicao;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public int getPontos() {
        return pontos;
    }
}
