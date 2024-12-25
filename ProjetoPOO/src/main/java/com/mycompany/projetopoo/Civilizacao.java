/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;
/**
 *
 * @author andre
 */
import java.util.ArrayList;
import java.util.List;

public class Civilizacao {
    private final String nome;                // Nome é imutável, pode ser final
    private final List<Cidade> cidades;       // Lista de cidades pode ser manipulada, mas o campo não muda
    private final List<Unidade> unidades;     // Lista de unidades segue a mesma lógica
    private int ouro;                         // Ouro é mutável

    // Construtor
    public Civilizacao(String nome, int ouroInicial) {
        this.nome = nome;
        this.ouro = ouroInicial;
        this.cidades = new ArrayList<>();
        this.unidades = new ArrayList<>();
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public List<Unidade> getUnidades() {
        return unidades;
    }

    public int getOuro() {
        return ouro;
    }

    // Métodos para manipular ouro
    public void adicionarOuro(int quantidade) {
        this.ouro += quantidade;
    }

    public void gastarOuro(int quantidade) throws IllegalArgumentException {
        if (quantidade > ouro) {
            throw new IllegalArgumentException("Ouro insuficiente!");
        }
        this.ouro -= quantidade;
    }

    // Métodos para manipular cidades
    public void adicionarCidade(Cidade cidade) {
        this.cidades.add(cidade);
    }

    public void removerCidade(Cidade cidade) {
        this.cidades.remove(cidade);
    }

    // Métodos para manipular unidades
    public void adicionarUnidade(Unidade unidade) {
        this.unidades.add(unidade);
    }

    public void removerUnidade(Unidade unidade) {
        this.unidades.remove(unidade);
    }

    // Método para exibir informações da civilização
    @Override
    public String toString() {
        return "Civilizacao: " + nome + ", Ouro: " + ouro + ", Cidades: " + cidades.size() + ", Unidades: " + unidades.size();
    }
}

