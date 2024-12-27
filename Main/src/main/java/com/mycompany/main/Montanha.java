package com.mycompany.main;

// Classe que representa o terreno Montanha
public class Montanha extends Terreno {
    // Construtor que inicializa o terreno Montanha com nome, acessibilidade e custo de movimento
    public Montanha() {
        super("Montanha", true, 3);
    }

    // Retorna o rendimento de comida do terreno Montanha
    @Override
    public int getRendimentoComida() {
        return 3; // Retorna 3 de comida
    }

    // Retorna o rendimento de produção do terreno Montanha
    @Override
    public int getRendimentoProducao() {
        return 3; // Retorna 3 de Produção
    }

    // Retorna o rendimento de ouro do terreno Montanha
    @Override
    public int getRendimentoOuro() {
        return 5; // Retorna 5 de Ouro
    }
}
