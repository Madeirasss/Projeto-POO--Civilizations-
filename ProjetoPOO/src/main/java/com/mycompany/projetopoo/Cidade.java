/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Cidade {
    private final String nome; // Nome da cidade não muda, pode ser final
    private int populacao;     // População pode mudar, não é final
    private int recursos;      // Recursos podem mudar, não é final

    // Construtor para inicializar a cidade
    public Cidade(String nome, int populacaoInicial, int recursosIniciais) {
        this.nome = nome;
        this.populacao = populacaoInicial;
        this.recursos = recursosIniciais;
    }

    // Métodos getters para acessar os campos
    public String getNome() {
        return nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public int getRecursos() {
        return recursos;
    }

    // Métodos setters ou atualizadores para modificar os campos
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }

    // Método para adicionar recursos
    public void adicionarRecurso(Recurso recurso) {
        // Supondo que a cidade tenha um recurso global de ouro
        if (recurso.getTipo().equals("Ouro")) {
            this.recursos += recurso.getQuantidade();
        }
    }

    // Método para consumir recursos
    public void consumirRecursos(int quantidade) throws IllegalArgumentException {
        if (quantidade > recursos) {
            throw new IllegalArgumentException("Recursos insuficientes!");
        }
        this.recursos -= quantidade;
    }

    // Método para exibir informações da cidade
    @Override
    public String toString() {
        return "Cidade: " + nome + ", Populacao: " + populacao + ", Recursos: " + recursos;
    }
}
