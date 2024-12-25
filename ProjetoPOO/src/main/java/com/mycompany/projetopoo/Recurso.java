/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Recurso {
    private final String tipo;  // Tipo do recurso é imutável, pode ser final
    private int quantidade;     // Quantidade pode variar

    // Construtor
    public Recurso(String tipo, int quantidadeInicial) {
        this.tipo = tipo;
        this.quantidade = quantidadeInicial;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    // Setters
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Métodos para manipular a quantidade
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void consumirQuantidade(int quantidade) throws IllegalArgumentException {
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente do recurso: " + tipo);
        }
        this.quantidade -= quantidade;
    }

    // Método para exibir informações do recurso
    @Override
    public String toString() {
        return "Recurso: " + tipo + ", Quantidade: " + quantidade;
    }
}
