/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Soldado extends Unidade {
    public Soldado() {
        this.tipo = "Soldado";
        this.vida = 100;
        this.forca = 20;
    }

    @Override
    public void mover(Mapa mapa) {
        // Implementação de movimentação
    }

    @Override
    public void atacar(Unidade inimigo) {
        // Implementação de ataque
    }
}