package com.mycompany.main;

public class Main {
    public static void main(String[] args) {
        // Configuração inicial do mapa com dimensões 15x10
        Mapa mapa = new Mapa(15, 10); 
        // Criação de uma nova civilização chamada "Império Romano"
        Civilizacao civilizacao = new Civilizacao("Império Romano");

        // Adicionando uma unidade inicial do tipo Colono na posição (2, 2)
        civilizacao.adicionarUnidade(new Colono(2, 2));

        // Adicionando uma cidade na posição (5, 5)
        civilizacao.adicionarCidade(new Cidade("Inimigo", 5,5,true));

        // Criando o jogo com a civilização e definindo a condição de vitória (1000 de ouro)
        Jogo jogo = new Jogo(civilizacao, 1000); // Vitória ao acumular 1000 de ouro

        // Ciclo principal do jogo
        MenuPrincipal menuPrincipal = new MenuPrincipal(mapa, civilizacao);
        while (true) {
            // Exibindo opções do menu principal
            menuPrincipal.exibirOpcoes();
            // Verificando se a condição de vitória foi atingida
            jogo.verificarCondicaoDeVitoria();
            // Verificando o estado das cidades da civilização
            civilizacao.verificarCidades();
        }
    }
}