package com.mycompany.main;

import java.util.Scanner;

public class MenuGerenciarEdificio extends Menu {
    private Cidade cidade;
    private Scanner scanner;

    // Construtor que inicializa a cidade e o scanner
    public MenuGerenciarEdificio(Cidade cidade) {
        this.cidade = cidade;
        this.scanner = new Scanner(System.in);
    }

    @Override
    protected void mostrarOpcoes() {
        // Exibir opções do menu de gerenciamento de edifícios
        System.out.println("\n--- Menu de Gerenciamento de Edifícios ---");
        System.out.println("1. Construir Edifício");
        System.out.println("2. Demolir Edifício");
        System.out.println("3. Voltar");
    }

    @Override
    protected void processarEscolha(int escolha) {
        // Processar a escolha do usuário
        switch (escolha) {
            case 1 -> construirEdificio();
            case 2 -> demolirEdificio();
            case 3 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Opção inválida.");
        }
    }

    // Método para construir um edifício na cidade
    private void construirEdificio() {
        if (cidade == null) {
            // Verificar se há cidades disponíveis
            System.out.println("Não há cidades disponíveis para construir edifícios.");
            return;
        }

        // Exibir opções de tipos de edifícios
        System.out.println("Escolha o tipo de edifício:");
        System.out.println("1. Mercado (Custo: 30 produção, Benefício: Mais produção de ouro)");
        System.out.println("2. Fazenda (Custo: 20 produção, Benefício: Mais produção de comida)");
        System.out.print("Escolha uma opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Edificio edificio;
        // Criar o edifício com base na escolha do usuário
        switch (tipo) {
            case 1 -> edificio = new Mercado();
            case 2 -> edificio = new Fazenda();
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        // Construir o edifício na cidade
        cidade.construirEdificio(edificio.getNome(), edificio);
    }

    // Método para demolir um edifício na cidade
    private void demolirEdificio() {
        if (cidade == null) {
            // Verificar se há cidades disponíveis
            System.out.println("Não há cidades disponíveis para demolir edifícios.");
            return;
        }

        // Exibir lista de edifícios para demolir
        System.out.println("Escolha o edifício para demolir:");
        int i = 1;
        // Listar todos os edifícios da cidade
        for (String nomeEdificio : cidade.getEdificios().keySet()) {
            System.out.println(i++ + ". " + nomeEdificio);
        }
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Verificar se a escolha é válida e demolir o edifício
        if (escolha > 0 && escolha <= cidade.getEdificios().size()) {
            String nomeEdificio = (String) cidade.getEdificios().keySet().toArray()[escolha - 1];
            cidade.demolirEdificio(nomeEdificio);
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
