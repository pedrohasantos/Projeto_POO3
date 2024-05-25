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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void efeito() {
        // Efeito padrão do tesouro, pode ser sobrescrito por subclasses
    }
}

class TesouroEspecial extends Tesouro {
    public TesouroEspecial(String nome, int posicao, int pontos) {
        super(nome, posicao, pontos);
    }

    @Override
    public void efeito() {
        // Implementar efeito especial
        System.out.println("Efeito especial ativado!");
    }
}
