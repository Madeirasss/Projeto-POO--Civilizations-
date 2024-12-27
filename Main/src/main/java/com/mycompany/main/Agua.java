package com.mycompany.main;

// Classe que representa um terreno do tipo Água
public class Agua extends Terreno {
    // Construtor da classe Água
    public Agua() {
        super("Água", false, 10000); 
    }

    // Método que retorna o rendimento de comida
    @Override
    public int getRendimentoComida() {
        return 0; // Terreno do tipo Água não gera comida
    }

    // Método que retorna o rendimento de produção
    @Override
    public int getRendimentoProducao() {
        return 0; // Terreno do tipo Água não gera produção
    }

    // Método que retorna o rendimento de ouro
    @Override
    public int getRendimentoOuro() {
        return 0; // Terreno do tipo Água não gera ouro
    }
}