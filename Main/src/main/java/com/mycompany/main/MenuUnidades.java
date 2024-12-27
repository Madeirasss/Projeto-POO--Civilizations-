package com.mycompany.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuUnidades extends Menu {
    private Civilizacao civilizacao;
    private Mapa mapa;
    private Scanner scanner = new Scanner(System.in);
    private MenuPrincipal menuPrincipal;

    // Construtor que inicializa a civilização, o mapa e o menu principal
    public MenuUnidades(Civilizacao civilizacao, Mapa mapa, MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        this.civilizacao = civilizacao;
        this.mapa = mapa;
    }

    @Override
    protected void mostrarOpcoes() {
        // Exibir opções do menu de gerenciamento de unidades
        System.out.println("\n--- Gerenciar Unidades ---");
        System.out.println("1. Listar unidades");
        System.out.println("2. Mover unidade");
        System.out.println("3. Atacar com unidade militar");
        System.out.println("4. Criar cidade com colono");
        System.out.println("5. Voltar ao menu principal");
    }

    @Override
    protected void processarEscolha(int escolha) {
        // Processar a escolha do usuário
        switch (escolha) {
            case 1 -> listarUnidades();
            case 2 -> moverUnidade();
            case 3 -> atacarComUnidadeMilitar();
            case 4 -> criarCidade();
            case 5 -> voltar();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Método para listar todas as unidades da civilização
    private void listarUnidades() {
        System.out.println("\n--- Lista de Unidades ---");
        int i = 1;
        // Iterar sobre todas as unidades da civilização e exibir suas informações
        for (Unidade unidade : civilizacao.getUnidades()) {
            System.out.println(i++ + ". " + unidade.getNome() + " na posição (" + unidade.getX() + ", " + unidade.getY() + ")");
        }
    }

    // Método para mover uma unidade
    private void moverUnidade() {
        System.out.println("\n--- Mover Unidade ---");
        listarUnidades();
        System.out.print("Escolha a unidade para mover: ");
        int escolhaUnidade = scanner.nextInt();
        Unidade unidadeEscolhida = civilizacao.getUnidades().get(escolhaUnidade - 1);
    
        System.out.print("Escolha a nova posição X: ");
        int novoX = scanner.nextInt();
        System.out.print("Escolha a nova posição Y: ");
        int novoY = scanner.nextInt();
    
        // Calcular o custo total de movimento para a nova posição
        int custoMovimentoTotal = calcularCustoMovimentoTotal(unidadeEscolhida.getX(), unidadeEscolhida.getY(), novoX, novoY);
    
        // Verificar se a unidade tem pontos de movimento suficientes
        if (unidadeEscolhida.getPontosMovimento() >= custoMovimentoTotal) {
            unidadeEscolhida.podeMover(custoMovimentoTotal);
            unidadeEscolhida.mover(novoX, novoY);
            System.out.println(unidadeEscolhida.getNome() + " movida para (" + novoX + ", " + novoY + ").");
        } else {
            System.out.println("Movimento insuficiente para a unidade " + unidadeEscolhida.getNome() + ".");
        }
    }
    
    // Método para calcular o custo total de movimento
    private int calcularCustoMovimentoTotal(int xInicial, int yInicial, int xFinal, int yFinal) {
        int custoMovimentoTotal = 0;
        int xAtual = xInicial;
        int yAtual = yInicial;
    
        // Calcular o custo de movimento para cada passo até a posição final
        while (xAtual != xFinal || yAtual != yFinal) {
            if (xAtual < xFinal) {
                xAtual++;
            } else if (xAtual > xFinal) {
                xAtual--;
            }
    
            if (yAtual < yFinal) {
                yAtual++;
            } else if (yAtual > yFinal) {
                yAtual--;
            }
    
            Terreno terrenoAtual = mapa.getTerreno(xAtual, yAtual);
            custoMovimentoTotal += terrenoAtual.getCustoMovimento();
        }
    
        return custoMovimentoTotal;
    }

    // Método para atacar com uma unidade militar
private void atacarComUnidadeMilitar() {
    System.out.println("\n--- Atacar com Unidade Militar ---");
    listarUnidades();
    System.out.print("Escolha a unidade militar para atacar: ");
    
    int escolhaUnidade = -1;
    try {
        escolhaUnidade = scanner.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Por favor, insira um número.");
        scanner.next(); // Limpar a entrada inválida
        return;
    }

    // Verificar se a escolha é válida
    if (escolhaUnidade < 1 || escolhaUnidade > civilizacao.getUnidades().size()) {
        System.out.println("Unidade inválida. Por favor, escolha uma unidade válida.");
        return;
    }

    Unidade unidadeEscolhida = civilizacao.getUnidades().get(escolhaUnidade - 1);

    // Verificar se a unidade escolhida é militar
    if (unidadeEscolhida instanceof Militar) {
        System.out.print("Escolha o alvo (1 para cidade, 2 para outra unidade militar): ");
        
        int alvo = -1;
        try {
            alvo = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            scanner.next(); // Limpar a entrada inválida
            return;
        }

        scanner.nextLine(); // Consumir o newline pendente

        if (alvo == 1) {
            System.out.println("Escolha a cidade inimiga para atacar:");
            List<Cidade> cidades = civilizacao.getCidades();
            // Listar todas as cidades inimigas
            for (int i = 0; i < cidades.size(); i++) {
                if (cidades.get(i).isInimigo()) {
                    System.out.println((i + 1) + ". " + cidades.get(i).getNome());
                }
            }
            int escolhaCidade = -1;
            try {
                escolhaCidade = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpar a entrada inválida
                return;
            }

            // Verificar se a escolha é válida
            if (escolhaCidade < 1 || escolhaCidade > cidades.size()) {
                System.out.println("Cidade inválida. Por favor, escolha uma cidade válida.");
                return;
            }

            Cidade cidadeInimiga = cidades.get(escolhaCidade - 1);
            System.out.println("A cidade " + cidadeInimiga.getNome() + " foi atacada por " + unidadeEscolhida.getNome() + "!");
            ((Militar) unidadeEscolhida).atacar(cidadeInimiga);
        } else if (alvo == 2) {
            System.out.println("Funcionalidade: Ataque a outra unidade militar não implementada!");
        } else {
            System.out.println("Opção inválida.");
        }
    } else {
        System.out.println("A unidade selecionada não é militar.");
    }
}

    // Método para criar uma cidade com um colono
    private void criarCidade() {
        System.out.println("\n--- Criar Cidade com Colono ---");
        listarUnidades();
        System.out.print("Escolha o colono para criar uma cidade: ");
        int escolhaUnidade = scanner.nextInt();
        Unidade unidadeEscolhida = civilizacao.getUnidades().get(escolhaUnidade - 1);

        // Verificar se a unidade escolhida é um colono
        if (unidadeEscolhida instanceof Colono) {
            Terreno terrenoAtual = mapa.getTerreno(unidadeEscolhida.getX(), unidadeEscolhida.getY());
            // Verificar se o terreno atual é vazio
            if (terrenoAtual instanceof Vazio) {
                // Verificar a distância mínima entre cidades
                if (verificarDistancia(unidadeEscolhida.getX(), unidadeEscolhida.getY())) {
                    System.out.print("Digite o nome da nova cidade: ");
                    scanner.nextLine(); // Consumir o newline pendente
                    String nomeCidade = scanner.nextLine();
                    Cidade novaCidade = new Cidade(nomeCidade, unidadeEscolhida.getX(), unidadeEscolhida.getY(), false);
                    civilizacao.adicionarCidade(novaCidade);
                    civilizacao.getUnidades().remove(unidadeEscolhida); // Remover o colono após criar a cidade
                    System.out.println("Cidade " + nomeCidade + " criada na posição (" + unidadeEscolhida.getX() + ", " + unidadeEscolhida.getY() + ").");
                } else {
                    System.out.println("Não é possível adicionar a cidade na posição (" + unidadeEscolhida.getX() + ", " + unidadeEscolhida.getY() + "). Distância mínima não respeitada.");
                }
            } else {
                System.out.println("O colono só pode fundar uma cidade em um terreno vazio.");
            }
        } else {
            System.out.println("A unidade selecionada não é um colono.");
        }
    }

    // Método para verificar a distância mínima entre cidades
    private boolean verificarDistancia(int x, int y) {
        // Iterar sobre todas as cidades da civilização e verificar a distância
        for (Cidade cidade : civilizacao.getCidades()) {
            int distanciaX = Math.abs(cidade.getX() - x);
            int distanciaY = Math.abs(cidade.getY() - y);
            if (distanciaX <= 2 && distanciaY <= 2) {
                return false;
            }
        }
        return true;
    }

    // Método para voltar ao menu principal
    private void voltar() {
        System.out.println("Voltando ao menu principal...");
        menuPrincipal.exibirOpcoes();
    }
}