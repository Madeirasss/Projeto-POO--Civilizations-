package com.mycompany.main;

// Classe que representa o tesouro de uma civilização
public class Tesouro {
    private int ouro;

    // Construtor que inicializa o tesouro com zero ouro
    public Tesouro() {
        this.ouro = 0;
    }

    // Retorna a quantidade de ouro no tesouro
    public int getOuro() {
        return ouro;
    }

    // Adiciona uma quantidade de ouro ao tesouro
    public void adicionarOuro(int quantidade) {
        if (quantidade > 0) {
            this.ouro += quantidade;
        }
    }

    // Paga a manutenção, subtraindo o custo do tesouro, e lança exceção se o tesouro for insuficiente
    public void pagarManutencao(int custo) throws IllegalArgumentException {
        if (custo > ouro) {
            throw new IllegalArgumentException("Tesouro insuficiente para pagar a manutenção!");
        }
        this.ouro -= custo;
    }

    // Retorna uma representação em string do tesouro
    @Override
    public String toString() {
        return "Tesouro: " + ouro + " de ouro.";
    }
}