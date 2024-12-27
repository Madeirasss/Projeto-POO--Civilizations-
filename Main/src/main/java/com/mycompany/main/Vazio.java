package com.mycompany.main;

// Classe que representa o terreno Vazio
public class Vazio extends Terreno {
    // Construtor que inicializa o terreno Vazio com nome, acessibilidade e custo de movimento
    public Vazio() {
        super("Vazio", true, 1);
    }

    // Retorna o rendimento de comida do terreno Vazio
    @Override
    public int getRendimentoComida() {
        return 0;
    }

    // Retorna o rendimento de produção do terreno Vazio
    @Override
    public int getRendimentoProducao() {
        return 0;
    }

    // Retorna o rendimento de ouro do terreno Vazio
    @Override
    public int getRendimentoOuro() {
        return 0;
    }
}