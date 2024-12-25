/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetopoo;

import java.util.Random;

/**
 *
 * @author andre
 */
public class Mapa {
    private final Terreno[][] grid;
    private final int largura;
    private final int altura;

    // Construtor que define as dimensões do mapa
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.grid = new Terreno[altura][largura];
    }

    public void definirTerreno(int x, int y, Terreno terreno) {
        if (x >= 0 && x < altura && y >= 0 && y < largura) {
            grid[x][y] = terreno;
        }
    }

    public void exibir() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (grid[i][j] != null) {
                    System.out.print(grid[i][j].getSimbolo() + " ");
                } else {
                    System.out.print("X ");  // Se o terreno estiver vazio
                }
            }
            System.out.println();
        }
    }

    public void gerarMapaAleatorio() {
        Random random = new Random();
        Class<?>[] terrenos = {Planicie.class, Floresta.class, Montanha.class};

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                try {
                    int index = random.nextInt(terrenos.length);
                    grid[i][j] = (Terreno) terrenos[index].getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}