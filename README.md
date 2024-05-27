
# Labirinto Aventureiro

## Descrição

"Labirinto Aventureiro" é um jogo de console onde o jogador assume o papel de um aventureiro explorando um labirinto cheio de tesouros e armadilhas. O jogador deve navegar pelo labirinto, coletar tesouros, evitar armadilhas e gerenciar sua energia para sobreviver e explorar o máximo possível.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

1. **Armadilha**: Representa uma armadilha no labirinto.
2. **Tesouro**: Representa um tesouro no labirinto.
3. **Aventureiro**: Representa o aventureiro controlado pelo jogador.
4. **Labirinto**: Representa o labirinto do jogo.
5. **Main**: Contém o método principal (`main`) que inicia o jogo.

## Conceitos de POO Utilizados

### Classes e Objetos
- As classes modelam diferentes entidades do jogo, e objetos dessas classes representam instâncias dessas entidades.

### Encapsulamento
- Atributos privados e métodos públicos (`getters` e `setters`) protegem os dados internos das classes.
- Exemplo:
  ```java
  private int posicao;
  private int dano;

  public int getPosicao() {
      return posicao;
  }

  public int getDano() {
      return dano;
  }
  ```

### Construtores
- Inicializam os objetos com valores específicos no momento de sua criação.
- Exemplo:
  ```java
  public Armadilha(int posicao, int dano) {
      this.posicao = posicao;
      this.dano = dano;
  }
  ```

### Abstração
- As classes abstraem os detalhes específicos de implementação e fornecem interfaces claras para interagir com os objetos.

### Associação e Composição
- As classes se relacionam entre si. Exemplo: `Labirinto` mantém listas de `Tesouro` e `Armadilha`, e `Aventureiro` possui uma lista de objetos `Tesouro`.
- Exemplo:
  ```java
  private ArrayList<Tesouro> tesourosColetados;

  public Labirinto(int base) {
      this.base = base;
      this.piramide = new char[3][this.base];
      this.listaTesouros = new ArrayList<>();
      this.listaArmadilhas = new ArrayList<>();
      gerarLabirinto();
  }
  ```

### Manipulação de Coleções
- Uso da classe `ArrayList` para armazenar e manipular coleções de objetos.

## Como Executar

1. **Pré-requisitos**:
   - Java Development Kit (JDK) instalado.

2. **Compilação**:
   ```bash
   javac *.java
   ```

3. **Execução**:
   ```bash
   java Main
   ```

## Funcionalidades do Jogo

- Movimentação do aventureiro
- Descanso para recuperar energia
- Interação com o ambiente (futuramente)
- Escolha de dificuldade do labirinto
- Reinício automático após a morte do aventureiro

## Exemplo de Uso

1. **Iniciar o jogo**: O jogador é saudado e solicitado a digitar seu nome.
2. **Escolher dificuldade**: O jogador escolhe a dificuldade do labirinto.
3. **Jogar**: O jogador pode escolher entre mover-se, descansar, interagir (funcionalidade futura) ou sair.
4. **Reinício**: Se o aventureiro perder toda a energia, o jogo reinicia automaticamente.

## Contribuição
Malu de Faria Neves Bezerra, Pedro Marques, Renan Duarte, Pedro Afonso, Rafael Angelim
 

## Licença

Este projeto é de domínio público e pode ser usado e modificado livremente.
