/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public abstract class Terreno {
    protected String nome;
    protected boolean acessivel;
    protected int recurso;

    // Construtor da classe base para terrenos
    public Terreno(String nome, boolean acessivel, int recurso) {
        this.nome = nome;
        this.acessivel = acessivel;
        this.recurso = recurso;
    }

    // Método para obter o nome do terreno
    public String getNome() {
        return nome;
    }

    // Método para verificar se o terreno é acessível
    public boolean isAcessivel() {
        return acessivel;
    }

    // Método para obter a quantidade de recurso do terreno
    public int getRecurso() {
        return recurso;
    }

    // Método para obter o símbolo do terreno
    public abstract String getSimbolo();
}