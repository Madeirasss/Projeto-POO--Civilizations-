package com.mycompany.main;

// Classe abstrata que representa uma unidade
public abstract class Unidade {
    private final String nome;
    private int x; // Coordenada X no mapa
    private int y; // Coordenada Y no mapa
    private final int movimento; // Quantidade de movimentos por turno
    private int pontosMovimento;

    // Construtor que inicializa a unidade com nome, movimento, posição inicial e pontos de movimento
    public Unidade(String nome, int movimento, int xInicial, int yInicial, int pontosMovimento) {
        this.nome = nome;
        this.movimento = movimento;
        this.x = xInicial;
        this.y = yInicial;
        this.pontosMovimento = pontosMovimento;
    }

    // Retorna o nome da unidade
    public String getNome() {
        return nome;
    }

    // Retorna a coordenada X da unidade
    public int getX() {
        return x;
    }

    // Retorna a coordenada Y da unidade
    public int getY() {
        return y;
    }

    // Move a unidade para uma nova posição
    public void mover(int novoX, int novoY) {
        this.x = novoX;
        this.y = novoY;
    }

    // Retorna os pontos de movimento da unidade
    public int getPontosMovimento() {
        return pontosMovimento;
    }

    // Define os pontos de movimento da unidade
    public void setPontosMovimento(int pontosMovimento) {
        this.pontosMovimento = pontosMovimento;
    }

    // Verifica se a unidade pode se mover, subtraindo o custo de movimento dos pontos de movimento
    public void podeMover(int custoMovimento) {
        if (pontosMovimento >= custoMovimento) {
            pontosMovimento -= custoMovimento;
        } else {
            System.out.println("Movimento insuficiente.");
        }
    }

    // Método abstrato para realizar a ação da unidade
    public abstract void realizarAcao();

    // Método para a unidade receber dano
    public void receberDano(int dano) {
        System.out.println(nome + " recebeu " + dano + " de dano.");
    }

    // Retorna uma representação em string da unidade
    @Override
    public String toString() {
        return nome + " [Posição: (" + x + ", " + y + "), Movimento: " + movimento + "]";
    }
}