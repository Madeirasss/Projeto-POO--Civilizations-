package com.mycompany.main;

// Classe que representa um terreno do tipo Floresta
public class Floresta extends Terreno {
    // Construtor da classe Floresta
    public Floresta() {
        super("Floresta", true, 2); // Chama o construtor da classe Terreno com os parâmetros nome, podeConstruir e custo
    }

    // Método que retorna o rendimento de comida
    @Override
    public int getRendimentoComida() {
        return 5; // Valor de exemplo para rendimento de comida
    }

    // Método que retorna o rendimento de produção
    @Override
    public int getRendimentoProducao() {
        return 2; // Valor de exemplo para rendimento de produção
    }

    // Método que retorna o rendimento de ouro
    @Override
    public int getRendimentoOuro() {
        return 1; // Valor de exemplo para rendimento de ouro
    }
}
