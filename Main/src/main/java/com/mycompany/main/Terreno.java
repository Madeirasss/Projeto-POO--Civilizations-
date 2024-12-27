package com.mycompany.main;

// Classe abstrata que representa um terreno
public abstract class Terreno {
    private int x;
    private int y;
    private final String nome;
    private final boolean acessivel;
    private int custoMovimento;

    // Construtor que inicializa o terreno com nome, acessibilidade e custo de movimento
    public Terreno(String nome, boolean acessivel, int custoMovimento) {
        this.nome = nome;
        this.acessivel = acessivel;
        this.custoMovimento = custoMovimento;
    }

    // Retorna o nome do terreno
    public String getNome() {
        return nome;
    }

    // Retorna se o terreno é acessível
    public boolean isAcessivel() {
        return acessivel;
    }

    // Retorna a coordenada X do terreno
    public int getX() {
        return x;
    }

    // Retorna a coordenada Y do terreno
    public int getY() {
        return y;
    }

    // Retorna o custo de movimento do terreno
    public int getCustoMovimento() {
        return custoMovimento;
    }

    // Define o custo de movimento do terreno
    public void setCustoMovimento(int custoMovimento) {
        this.custoMovimento = custoMovimento;
    }

    // Métodos abstratos para obter o rendimento de comida, produção e ouro do terreno
    public abstract int getRendimentoComida();
    public abstract int getRendimentoProducao();
    public abstract int getRendimentoOuro();

    // Retorna uma representação em string do terreno
    @Override
    public String toString() {
        return nome;
    }
}
