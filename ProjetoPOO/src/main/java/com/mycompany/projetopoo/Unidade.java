/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

/**
 *
 * @author andre
 */
public abstract class Unidade {
    protected String tipo; // Alterado de private para protected
    protected int vida;
    protected int forca;

    public abstract void mover(Mapa mapa);

    public abstract void atacar(Unidade inimigo);

    // Getters (caso prefira manter os atributos privados)
    public String getTipo() {
        return tipo;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }
}