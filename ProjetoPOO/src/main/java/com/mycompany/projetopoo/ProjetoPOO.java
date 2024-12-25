/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetopoo;

import java.util.Scanner;

/**
 *
 * @author andre
 */
public class ProjetoPOO {
    public static void main(String[] args) {
        // Teste da classe Recurso
        System.out.println("=== Teste da Classe Recurso ===");
        Recurso ouro = new Recurso("Ouro", 1000);
        System.out.println(ouro);

        ouro.adicionarQuantidade(500);
        System.out.println("Apos adicionar quantidade: " + ouro.getQuantidade());

        try {
            ouro.consumirQuantidade(1200);
            System.out.println("Apos consumo: " + ouro.getQuantidade());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ouro.consumirQuantidade(500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Teste da classe Cidade
        System.out.println("\n=== Teste da Classe Cidade ===");
        Cidade cidade1 = new Cidade("Menfis", 2000, 500);
        Cidade cidade2 = new Cidade("Tebas", 1500, 300);
        System.out.println("Cidade criada: " + cidade1);
        System.out.println("Cidade criada: " + cidade2);

        // Teste da classe Civilizacao
        System.out.println("\n=== Teste da Classe Civilizacao ===");
        Civilizacao civ = new Civilizacao("Egito", 1000);
        System.out.println("Civilizacao criada: " + civ);

        civ.adicionarCidade(cidade1);
        civ.adicionarCidade(cidade2);
        System.out.println("Apos adicionar cidades: " + civ);

        Unidade soldado = new Soldado();
        Unidade colono = new Colono();
        civ.adicionarUnidade(soldado);
        civ.adicionarUnidade(colono);
        System.out.println("Apos adicionar unidades: " + civ);

        civ.adicionarOuro(200);
        System.out.println("Apos adicionar ouro: " + civ);

        try {
            civ.gastarOuro(800);
            System.out.println("Apos gastar ouro: " + civ);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Teste da classe Mapa com 20x20
        System.out.println("\n=== Teste da Classe Mapa ===");
        Mapa mapa = new Mapa(20, 20); // Mapa agora tem 20x20

        // Preencher o mapa com diferentes terrenos
        mapa.gerarMapaAleatorio();

        // Informações finais
        System.out.println("\nInformacoes Finais:");
        System.out.println(civ);

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Cycle
        while (true) {
            // Display the menu
            System.out.println("\n=== Menu ===");
            System.out.println("1. Exibir mapa");
            System.out.println("2. Adicionar cidade ao mapa");
            System.out.println("3. Adicionar recurso");
            System.out.println("4. Consumir recurso");
            System.out.println("5. Gastar ouro da civilizacao");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opcao: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    // Display the map
                    System.out.println("\n=== Mapa ===");
                    mapa.exibir();
                    break;
                case "2":
                    // Add a city to the map
                    System.out.println("\nAdicionando cidade ao mapa:");
                    mapa.definirTerreno(10, 10, new Terreno("Cidade: Menfis", true, 3) {
                        @Override
                        public String getSimbolo() {
                            return "C"; // Símbolo de cidade
                        }
                    });
                    break;
                case "3":
                    // Add resource
                    System.out.println("\nAdicionando recurso:");
                    System.out.print("Quantidade a adicionar: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ouro.adicionarQuantidade(quantidadeAdicionar);
                    System.out.println("Quantidade atual de ouro: " + ouro.getQuantidade());
                    break;
                case "4":
                    // Consume resource
                    System.out.println("\nConsumindo recurso:");
                    System.out.print("Quantidade a consumir: ");
                    int quantidadeConsumir = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    try {
                        ouro.consumirQuantidade(quantidadeConsumir);
                        System.out.println("Quantidade atual de ouro: " + ouro.getQuantidade());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    // Spend civilization gold
                    System.out.println("\nGastando ouro da civilizacao:");
                    System.out.print("Quantidade a gastar: ");
                    int quantidadeGastar = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    try {
                        civ.gastarOuro(quantidadeGastar);
                        System.out.println("Quantidade atual de ouro da civilizacao: " + civ.getOuro());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "6":
                    // Exit the cycle
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
            // Informações finais
            System.out.println("\nInformacoes Finais:");
            System.out.println(civ);
        }
    }
}

