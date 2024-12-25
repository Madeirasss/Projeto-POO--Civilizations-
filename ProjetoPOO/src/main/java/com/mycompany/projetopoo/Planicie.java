/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Planicie extends Terreno {
    public Planicie() {
        super("Planície", true, 2);  // A planície é acessível e tem 2 de recurso
    }

    // Símbolo para a planície
    @Override
    public String getSimbolo() {
        return ".";
    }

    // Override
    public int getBonusRecursos() {
        return 1; // Bônus de recurso padrão
    }
}
