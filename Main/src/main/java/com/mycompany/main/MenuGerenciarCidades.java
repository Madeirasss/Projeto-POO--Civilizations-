package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGerenciarCidades extends Menu {
    private Civilizacao civilizacao;
    private Mapa mapa;
    private MenuPrincipal menuPrincipal; // Adicionar campo para menuPrincipal
    private Scanner scanner = new Scanner(System.in);

    // Construtor que inicializa a civilização, o mapa e o menu principal
    public MenuGerenciarCidades(Civilizacao civilizacao, Mapa mapa, MenuPrincipal menuPrincipal) {
        this.civilizacao = civilizacao;
        this.mapa = mapa;
        this.menuPrincipal = menuPrincipal; // Inicializar menuPrincipal
    }

    @Override
    protected void mostrarOpcoes() {
        System.out.println("\n--- Gerenciar Cidades ---");
        int i = 1;
        // Listar todas as cidades da civilização
        for (Cidade cidade : civilizacao.getCidades()) {
            if (!cidade.isInimigo()) {
            System.out.println(i++ + ". " + cidade.getNome() + " na posição (" + cidade.getX() + ", " + cidade.getY() + ")");
            }
        }

        // Opção para voltar ao menu principal
        System.out.println(i + ". Voltar ao menu principal");
    }

    @Override
    protected void processarEscolha(int escolha) {
        // Filtrar cidades não inimigas
        List<Cidade> cidadesNaoInimigas = new ArrayList<>();
        for (Cidade cidade : civilizacao.getCidades()) {
            if (!cidade.isInimigo()) {
                cidadesNaoInimigas.add(cidade);
            }
        }

        // Verificar se a escolha é válida e processar a escolha correspondente
        if (escolha > 0 && escolha <= cidadesNaoInimigas.size()) {
            Cidade cidadeEscolhida = cidadesNaoInimigas.get(escolha - 1);
            mostrarOpcoesCidade(cidadeEscolhida);
        } else if (escolha == cidadesNaoInimigas.size() + 1) {
            voltar();
        } else {
            System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Mostra as opções de gerenciamento de uma cidade específica
    private void mostrarOpcoesCidade(Cidade cidade) {
        System.out.println("\n--- Gerenciar " + cidade.getNome() + " ---");
        System.out.println("1. Gerenciar Terrenos");
        System.out.println("2. Ver Status da Cidade");
        System.out.println("3. Usar Ouro para Acelerar Produção");
        System.out.println("4. Adicionar Unidade");
        System.out.println("5. Voltar");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> gerenciarTerrenos(cidade);
            case 2 -> verStatusCidade(cidade);
            case 3 -> usarOuroAcelerarProducao(cidade);
            case 4 -> adicionarUnova();
            case 5 -> voltar();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Gerencia os terrenos de uma cidade específica
    private void gerenciarTerrenos(Cidade cidade) {
        System.out.println("\n--- Gerenciar Terrenos de " + cidade.getNome() + " ---");
        System.out.println("População: " + cidade.getPopulacao());
        System.out.println("Terrenos trabalhados: " + cidade.getTerrenosTrabalhados().size());
        System.out.println("1. Adicionar terreno trabalhado");
        System.out.println("2. Remover terreno trabalhado");
        System.out.println("3. Voltar");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1 -> adicionarTerrenoTrabalhado(cidade);
            case 2 -> removerTerrenoTrabalhado(cidade);
            case 3 -> voltar();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Adiciona um terreno trabalhado a uma cidade específica

    private void adicionarTerrenoTrabalhado(Cidade cidade) {
        System.out.println("\n--- Adicionar Terreno Trabalhado ---");
        System.out.println("Terrenos disponíveis dentro de 3 casas:");
        for (int i = -3; i <= 3; i++) {
            for (int j = -3; j <= 3; j++) {
                int x = cidade.getX() + i;
                int y = cidade.getY() + j;
                try {
                    if (x >= 0 && x < mapa.getLargura() && y >= 0 && y < mapa.getAltura()) {
                        Terreno terreno = mapa.getTerreno(x, y);
                        if (terreno.isAcessivel() && !cidade.getTerrenosTrabalhados().contains(terreno)) {
                            System.out.println("Terreno em (" + x + ", " + y + "): " + terreno.getNome());
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Erro ao acessar terreno em (" + x + ", " + y + "): " + e.getMessage());
                }
            }
        }
        // Solicitar ao usuário para escolher a posição do terreno
        System.out.print("Escolha a posição X do terreno: ");
        int x = scanner.nextInt();
        System.out.print("Escolha a posição Y do terreno: ");
        int y = scanner.nextInt();
        try {
            Terreno terreno = mapa.getTerreno(x, y);
            cidade.adicionarTerrenoTrabalhado(terreno);
            System.out.println("Terreno em (" + x + ", " + y + ") adicionado.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao adicionar terreno em (" + x + ", " + y + "): " + e.getMessage());
        }
    }

    // Remove um terreno trabalhado de uma cidade específica
    private void removerTerrenoTrabalhado(Cidade cidade) {
        System.out.println("\n--- Remover Terreno Trabalhado ---");
        int i = 1;
        // Listar terrenos trabalhados pela cidade
        for (Terreno terreno : cidade.getTerrenosTrabalhados()) {
            System.out.println(i++ + ". Terreno em (" + terreno.getX() + ", " + terreno.getY() + "): " + terreno.getNome());
        }
        // Solicitar ao usuário para escolher o terreno a ser removido
        System.out.print("Escolha o terreno para remover: ");
        int escolha = scanner.nextInt();
        Terreno terreno = cidade.getTerrenosTrabalhados().get(escolha - 1);
        cidade.removerTerrenoTrabalhado(terreno);
        System.out.println("Terreno em (" + terreno.getX() + ", " + terreno.getY() + ") removido.");
    }

    // Mostra o status de uma cidade específica
    private void verStatusCidade(Cidade cidade) {
        System.out.println("\n--- Status da Cidade " + cidade.getNome() + " ---");
        System.out.println("População: " + cidade.getPopulacao());
        System.out.println("Produçã: " + cidade.getProducao());
        System.out.println("Comida: " + cidade.getComida());
        System.out.println("Terrenos trabalhados: " + cidade.getTerrenosTrabalhados().size());
        System.out.println("1. Voltar");

        int escolha = scanner.nextInt();
        if (escolha == 1) {
            voltar();
        } else {
            System.out.println("Opção inválida! Tente novamente.");
        } 
    }

    // Usa ouro para acelerar a produção em uma cidade específica
    private void usarOuroAcelerarProducao(Cidade cidade) {
        System.out.println("\n--- Usar Ouro para Acelerar Produção em " + cidade.getNome() + " ---");
        System.out.println("Ouro disponível: " + cidade.getOuro());
        System.out.println("Custo para acelerar produção: 20 ouro");
        System.out.println("1. Usar Ouro");
        System.out.println("2. Voltar");

        int escolha = scanner.nextInt();
        if (escolha == 1) {
            if (cidade.getOuro().getQuantidade() >= 20) {
                cidade.usarOuro(20);
                cidade.receberRecurso(cidade.getProducao().getNome(), 10);
                System.out.println("Produção acelerada.");
            } else {
                System.out.println("Ouro insuficiente.");
            }
        } else if (escolha == 2) {
            voltar();
        } else {
            System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Adiciona uma nova unidade
    private void adicionarUnova() {
        System.out.println("\n--- Adicionar Unidade ---");
    System.out.println("Custo para adicionar Unidade: 10 de produção");
    System.out.println("1. Adicionar Colono");
    System.out.println("2. Adicionar Militar");
    System.out.println("0. Voltar");

    int escolha = scanner.nextInt();
    scanner.nextLine(); // Consumir o newline pendente

    if (escolha == 1 || escolha == 2) {
        System.out.println("Escolha a cidade para adicionar a unidade:");
        List<Cidade> cidadesNaoInimigas = new ArrayList<>();
        for (Cidade cidade : civilizacao.getCidades()) {
            if (!cidade.isInimigo()) {
                cidadesNaoInimigas.add(cidade);
            }
        }

        for (int i = 0; i < cidadesNaoInimigas.size(); i++) {
            System.out.println((i + 1) + ". " + cidadesNaoInimigas.get(i).getNome());
        }

        int escolhaCidade = scanner.nextInt();
        scanner.nextLine(); // Consumir o newline pendente

        if (escolhaCidade > 0 && escolhaCidade <= cidadesNaoInimigas.size()) {
            Cidade cidade = cidadesNaoInimigas.get(escolhaCidade - 1);
            if (cidade.getProducao().getQuantidade() >= 10) {
                if (escolha == 1) {
                    civilizacao.adicionarUnidade(new Colono(cidade.getX() + 1, cidade.getY()));
                    System.out.println("Colono adicionado.");
                } else if (escolha == 2) {
                    civilizacao.adicionarUnidade(new Militar(cidade.getX() + 1, cidade.getY()));
                    System.out.println("Militar adicionado.");
                }
                cidade.getProducao().setQuantidade(cidade.getProducao().getQuantidade() - 10);
            } else {
                System.out.println("Produção insuficiente.");
            }
        } else {
            System.out.println("Cidade inválida! Tente novamente.");
        }
    } else if (escolha == 0) {
        voltar();
    } else {
        System.out.println("Opção inválida! Tente novamente.");
    }
    }

    // Volta ao menu principal
    private void voltar() {
        System.out.println("Voltando ao menu principal...");
        menuPrincipal.exibirOpcoes(); 
    }
}