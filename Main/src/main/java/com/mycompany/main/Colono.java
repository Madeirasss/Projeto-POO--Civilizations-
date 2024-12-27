package com.mycompany.main;

// Classe que representa uma unidade do tipo Colono
public class Colono extends Unidade {
    // Construtor da classe Colono
    public Colono(int xInicial, int yInicial) {
        super("Unidade Colono", 1, xInicial, yInicial, 5); // Chama o construtor da classe Unidade com os parâmetros nome, vida, xInicial, yInicial e movimento
    }

    // Método para fundar uma cidade
    public Cidade fundarCidade(String nome) {
        System.out.println(getNome() + " fundou a cidade " + nome + "!");
        return new Cidade(nome, getX(), getY(),false); // Cria uma nova cidade nas coordenadas atuais do Colono
    }

    // Método para realizar a ação do Colono
    @Override
    public void realizarAcao() {
        System.out.println(getNome() + " está pronto para fundar uma cidade.");
    }
}