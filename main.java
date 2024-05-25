import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo, bravo aventureiro, será que esse é seu nome mesmo ??\nDigite seu nome: ");
            System.out.println("Escolha a dificuldade do labirinto (1-Fácil, 2-Médio, 3-Difícil): ");
            Aventureiro aventureiro = scanner.nextString();
            int escolha = scanner.nextInt();
            int tamanho = 20;
            
            switch (escolha) {
                case 1:
                    tamanho = 20;
                    break;
                case 2:
                    tamanho = 30;
                    break;
                case 3:
                    tamanho = 40;
                    break;
                default:
                    System.out.println("Opção inválida! Usando dificuldade fácil.");
                    break;
            }

            Labirinto labirinto = new Labirinto(tamanho);

            while (aventureiro.getEnergia() > 0) {
                labirinto.printarLabirinto();
                System.out.println("Escolha sua ação aventureiro: \n1. Mover-se\n2. Descansar\n3. Interagir\n4. Sair");
                int ops = scanner.nextInt();

                switch (ops) {
                    case 1:
                        aventureiro.mover(labirinto);
                        break;
                    case 2:
                        aventureiro.descansar();
                        break;
                    case 3:
                        aventureiro.interagir(labirinto);
                        break;
                    case 4:
                        System.out.println("Saindo do jogo...");
                        return;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }

            System.out.println("Você morreu!\n\n\n Reiniciando o jogo...");
        }
    }
}
