package com.mycompany.main;

// Classe que representa uma unidade do tipo Construtor
public class Construtor extends Unidade {
    // Construtor da classe Construtor
    public Construtor(int xInicial, int yInicial) {
        super("Unidade Construtora", 1, xInicial, yInicial, 2); // Chama o construtor da classe Unidade com os parâmetros nome, vida, xInicial, yInicial e movimento
    }

    // Método para construir uma melhoria no terreno
    public void construir(String melhoria) {
        System.out.println(getNome() + " constrói uma " + melhoria + " no terreno.");
    }

    // Método para realizar a ação do Construtor
    @Override
    public void realizarAcao() {
        construir("estrada"); // Constrói uma estrada como ação padrão
    }
}