/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public class Floresta extends Terreno {
    public Floresta() {
        super("Floresta", true, 1);  // A floresta é acessível e tem 1 de recurso
    }

    // Símbolo para a floresta
    @Override
    public String getSimbolo() {
        return "T";
    }
}