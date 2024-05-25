public class Armadilha {
    private int posicao;
    private int dano;

    public Armadilha(int posicao, int dano) {
        this.posicao = posicao;
        this.dano = dano;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}
