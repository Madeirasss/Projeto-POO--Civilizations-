package com.mycompany.main;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

// Classe que representa uma civilização
public class Civilizacao {
    // Atributos da civilização
    private String nome; // Nome da civilização
    private Tesouro tesouro; // Tesouro da civilização
    private List<Cidade> cidades; // Lista de cidades da civilização
    private List<Unidade> unidades; // Lista de unidades da civilização

    // Construtor da classe Civilizacao
    public Civilizacao(String nome) {
        this.nome = nome;
        this.tesouro = new Tesouro();
        this.cidades = new ArrayList<>();
        this.unidades = new ArrayList<>();
    }

    // Métodos getters
    public List<Cidade> getCidades() {
        return cidades; // Retorna a lista de cidades
    }

    public Tesouro getTesouro() {
        return tesouro; // Retorna o tesouro
    }

    public List<Unidade> getUnidades() {
        return unidades; // Retorna a lista de unidades
    }

    // Método para adicionar uma unidade
    public void adicionarUnidade(Unidade unidade) {
        unidades.add(unidade); // Adiciona a unidade à lista de unidades
    }

    // Método para mover uma unidade
    public void moverUnidade(Unidade unidade, int novoX, int novoY) {
        unidade.mover(novoX, novoY); // Move a unidade para as novas coordenadas
        System.out.println(unidade.getNome() + " moveu-se para (" + novoX + ", " + novoY + ").");
    }

    // Método para coletar ouro das cidades
    public void coletarOuro() {
        for (Cidade cidade : cidades) {
            tesouro.adicionarOuro(cidade.getOuro().getQuantidade()); // Adiciona o ouro das cidades ao tesouro
        }
    }

    // Método para realizar ações de turno
    public void realizarTurno() {
        System.out.println("\n--- Início do Turno ---");
        for (Unidade unidade : unidades) {
            unidade.realizarAcao(); // Realiza a ação da unidade
        }
        for (Cidade cidade : cidades) {
            cidade.realizarTurno(); // Realiza as ações de turno da cidade
        }
        coletarOuro(); // Coleta o ouro das cidades
        System.out.println("\n--- Fim do Turno ---");
        System.out.println("Tesouro atual: " + tesouro.getOuro() + " de ouro.");
    }

    // Método para adicionar uma cidade
    public void adicionarCidade(Cidade cidade) {
        cidades.add(cidade); // Adiciona a cidade à lista de cidades
        System.out.println("Cidade " + cidade.getNome() + " foi adicionada na posição (" + cidade.getX() + ", " + cidade.getY() + ").");
    }

    // Método para remover uma cidade
    public void removerCidade(Cidade cidade) {
        cidades.remove(cidade); // Remove a cidade da lista de cidades
        System.out.println("A cidade " + cidade.getNome() + " foi removida do mapa.");
    }

    // Método para verificar as cidades
    public void verificarCidades() {
        Iterator<Cidade> iterator = cidades.iterator();
        while (iterator.hasNext()) {
            Cidade cidade = iterator.next();
            if (cidade.getVida() <= 0) {
                System.out.println("A cidade " + cidade.getNome() + " foi destruída!");
                iterator.remove(); // Remove a cidade destruída da lista de cidades
            }
        }
    }

    // Método toString para representar a civilização como string
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Civilizacao: " + nome + "\n");
        for (Cidade cidade : cidades) {
            builder.append(cidade).append("\n"); // Adiciona as cidades à representação da civilização
        }
        for (Unidade unidade : unidades) {
            builder.append(unidade).append("\n"); // Adiciona as unidades à representação da civilização
        }
        builder.append(tesouro); // Adiciona o tesouro à representação da civilização
        return builder.toString();
    }
}