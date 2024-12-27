package com.mycompany.main;

// Classe que representa uma unidade militar, que pode levar dano
public class Militar extends Unidade implements LevarDano {
    private int forcaCombate;
    private int vida;

    // Construtor que inicializa a unidade militar com posição inicial, força de combate e vida
    public Militar(int xInicial, int yInicial) {
        super("Unidade Militar", 2, xInicial, yInicial, 5);
        this.forcaCombate = 50;
        this.vida = 20;
    }

    // Retorna a força de combate da unidade militar
    public int getForcaCombate() {
        return forcaCombate;
    }

    // Retorna a vida da unidade militar
    public int getVida() {
        return vida;
    }

    // Método que aplica dano à unidade militar
    @Override
    public void levarDano(int dano) {
        vida -= dano;
        System.out.println(getNome() + " recebeu " + dano + " de dano. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(getNome() + " foi destruída!");
        }
    }

    // Método que permite a unidade militar atacar uma cidade
    public void atacar(Cidade cidade) {
        System.out.println(getNome() + " ataca " + cidade.getNome() + "!");
        cidade.levarDano(this.forcaCombate);
    }

    // Método que realiza a ação da unidade militar
    @Override
    public void realizarAcao() {
        System.out.println(getNome() + " está em posição defensiva.");
    }
}