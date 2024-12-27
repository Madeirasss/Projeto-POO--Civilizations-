package com.mycompany.main;

public class MenuPrincipal extends Menu {
    private Mapa mapa;
    private Civilizacao civilizacao;

    // Construtor que inicializa o mapa e a civilização
    public MenuPrincipal(Mapa mapa, Civilizacao civilizacao) {
        this.mapa = mapa;
        this.civilizacao = civilizacao;
    }

    @Override
    protected void mostrarOpcoes() {
        // Exibir opções do menu principal
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Ver mapa");
        System.out.println("2. Gerenciar unidades");
        System.out.println("3. Gerenciar cidades");
        System.out.println("4. Gerenciar edifícios");
        System.out.println("5. Progresso da civilização");
        System.out.println("6. Finalizar turno");
        System.out.println("0. Sair do jogo");
    }

    @Override
    protected void processarEscolha(int escolha) {
        // Processar a escolha do usuário
        switch (escolha) {
            case 1 -> exibirMapa();
            case 2 -> gerenciarUnidades();
            case 3 -> gerenciarCidades();
            case 4 -> gerenciarEdificios();
            case 5 -> exibirProgresso();
            case 6 -> {
                System.out.println("\nFinalizando turno...");
                civilizacao.realizarTurno();
            }
            case 0 -> sair();
            default -> System.out.println("Opção inválida! Tente novamente.");
        }
    }

    // Método para exibir o mapa
    private void exibirMapa() {
        System.out.println("\n--- Mapa ---");
        mapa.mostrarMapa(civilizacao.getCidades(), civilizacao.getUnidades());
        System.out.println("Legenda: T (Floresta), M (Montanha), ~ (Água), X (Vazio), C (Cidade), U (Unidade)");
    }

    // Método para gerenciar unidades
    private void gerenciarUnidades() {
        System.out.println("\n--- Gerenciar Unidades ---");
        MenuUnidades menuUnidades = new MenuUnidades(civilizacao, mapa, this); // Passar menuPrincipal
        menuUnidades.exibirOpcoes();
    }

    // Método para gerenciar cidades
    private void gerenciarCidades() {
        System.out.println("\n--- Gerenciar Cidades ---");
        MenuGerenciarCidades menuGerenciarCidades = new MenuGerenciarCidades(civilizacao, mapa, this); // Passar menuPrincipal
        menuGerenciarCidades.exibirOpcoes();
    }

    // Método para gerenciar edifícios
    private void gerenciarEdificios() {
        if (civilizacao.getCidades().isEmpty()) {
            // Verificar se há cidades disponíveis
            System.out.println("Não há cidades disponíveis para gerenciar edifícios.");
            return;
        }

        System.out.println("\n--- Gerenciar Edifícios ---");
        Cidade cidade = civilizacao.getCidades().get(0); // Exemplo: pegar a primeira cidade
        MenuGerenciarEdificio menuGerenciarEdificio = new MenuGerenciarEdificio(cidade);
        menuGerenciarEdificio.exibirOpcoes();
    }

    // Método para exibir o progresso da civilização
    private void exibirProgresso() {
        System.out.println("\n--- Progresso da Civilização ---");
        System.out.println(civilizacao);
    }

    // Método para sair do jogo
    private void sair() {
        System.out.println("Saindo do jogo. Até mais!");
        System.exit(0);
    }
}