/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Colono extends Unidade {
    public Colono() {
        this.tipo = "Colono";
        this.vida = 50;
        this.forca = 5;
    }

    @Override
    public void mover(Mapa mapa) {
        // Implementação de movimentação
    }

    @Override
    public void atacar(Unidade inimigo) {
        // Colonos não atacam
    }
}
