/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Montanha extends Terreno {
    public Montanha() {
        super("Montanha", false, 0);  // Montanha é inacessível e não tem recurso
    }

    // Símbolo para a montanha
    @Override
    public String getSimbolo() {
        return "^";
    }

    // Override
    public int getBonusRecursos() {
        return 0; // Sem bônus, inacessível
    }
}