package com.mycompany.main;

// Classe que representa um recurso com nome e quantidade
public class Recurso {
    private String nome;
    private int quantidade;

    // Construtor que inicializa o recurso com nome e quantidade inicial
    public Recurso(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidade = 0;
    }

    // Retorna o nome do recurso
    public String getNome() {
        return nome;
    }

    // Retorna a quantidade do recurso
    public int getQuantidade() {
        return quantidade;
    }
    // Define a quantidade do recurso
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Adiciona uma quantidade ao recurso
    public void adicionar(int valor) {
        this.quantidade += valor;
    }

    // Consome uma quantidade do recurso, lançando exceção se a quantidade for insuficiente
    public void consumir(int valor) throws IllegalArgumentException {
        if (valor > quantidade) {
            throw new IllegalArgumentException("Quantidade insuficiente do recurso: " + nome);
        }
        this.quantidade -= valor;
    }

    // Remove uma quantidade do recurso, lançando exceção se a quantidade for insuficiente
    public void remover(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade insuficiente.");
        }
    }

    // Retorna uma representação em string do recurso
    @Override
    public String toString() {
        return nome + ": " + quantidade;
    }
}