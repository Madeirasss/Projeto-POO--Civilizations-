package com.mycompany.main;

import java.util.List;

public class Mapa {
    private final int largura;
    private final int altura;
    private final Terreno[][] celulas;

    // Construtor que inicializa o mapa com a largura e altura especificadas
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.celulas = new Terreno[altura][largura];
        inicializarMapa();
    }

    // Retorna a largura do mapa
    public int getLargura() {
        return largura;
    }

    // Retorna a altura do mapa
    public int getAltura() {
        return altura;
    }

    // Inicializa o mapa com terrenos aleatórios
    private void inicializarMapa() {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                // Gerar terreno aleatório
                celulas[i][j] = gerarTerrenoAleatorio();
            }
        }
    }

    // Gera um terreno aleatório
    private Terreno gerarTerrenoAleatorio() {
        int tipo = (int) (Math.random() * 4);
        return switch (tipo) {
            case 0 -> new Floresta();
            case 1 -> new Montanha();
            case 2 -> new Agua();
            default -> new Vazio();
        };
    }

    // Retorna o terreno na posição especificada, implementando mapa circular no eixo X
    public Terreno getTerreno(int x, int y) {
        x = (x + largura) % largura; // Implementação do mapa circular no eixo X
        return celulas[y][x];
    }

    // Mostra o mapa visualmente, incluindo cidades e unidades
    public void mostrarMapa(List<Cidade> cidades, List<Unidade> unidades) {
        char[][] mapaVisual = new char[altura][largura];

        // Preencher o mapa visual com terrenos
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                Terreno terreno = celulas[i][j];
                if (terreno instanceof Floresta) {
                    mapaVisual[i][j] = 'T';
                } else if (terreno instanceof Montanha) {
                    mapaVisual[i][j] = 'M';
                } else if (terreno instanceof Agua) {
                    mapaVisual[i][j] = '~';
                } else if (terreno instanceof Vazio) {
                    mapaVisual[i][j] = 'X';
                }
            }
        }

        // Adicionar cidades ao mapa visual
        for (Cidade cidade : cidades) {
            mapaVisual[cidade.getY()][cidade.getX()] = 'C'; // 'C' para cidade
        }

        // Adicionar unidades ao mapa visual
        for (Unidade unidade : unidades) {
            mapaVisual[unidade.getY()][unidade.getX()] = 'U'; // 'U' para unidade
        }

        // Exibir o mapa visual
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                System.out.print(mapaVisual[i][j] + " ");
            }
            System.out.println();
        }
    }
}