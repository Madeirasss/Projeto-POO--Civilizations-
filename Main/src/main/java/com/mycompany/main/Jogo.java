package com.mycompany.main;

// Classe que representa o jogo
public class Jogo {
    // Atributos do jogo
    private Civilizacao civilizacao; // Civilização do jogador
    private int ouroParaVitoria; // Quantidade de ouro necessária para vencer

    // Construtor da classe Jogo
    public Jogo(Civilizacao civilizacao, int ouroParaVitoria) {
        this.civilizacao = civilizacao;
        this.ouroParaVitoria = ouroParaVitoria;
    }

    // Método para verificar a condição de vitória
    public void verificarCondicaoDeVitoria() {
        if (civilizacao.getTesouro().getOuro() >= ouroParaVitoria) {
            System.out.println("Parabéns! Você venceu acumulando " + ouroParaVitoria + " de ouro!");
            System.exit(0); // Encerra o jogo
        }
    
        System.out.println("O jogo continua! Complete os objetivos para vencer."); // Mensagem de continuação do jogo
    }
}