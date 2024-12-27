package com.mycompany.main;

// Classe que representa um Mercado, implementando a interface Edificio
public class Mercado implements Edificio {
    private String nome;
    private int custoProducao;
    private int custoManutencao;
    private String beneficio;

    // Construtor que inicializa os atributos do Mercado
    public Mercado() {
        this.nome = "Mercado";
        this.custoProducao = 30;
        this.custoManutencao = 3;
        this.beneficio = "Mais produção de ouro";
    }

    // Retorna o custo de produção do Mercado
    @Override
    public int getCustoProducao() {
        return custoProducao;
    }

    // Retorna o custo de manutenção do Mercado
    @Override
    public int getCustoManutencao() {
        return custoManutencao;
    }

    // Retorna o benefício do Mercado
    @Override
    public String getBeneficio() {
        return beneficio;
    }

    // Retorna o nome do Mercado
    @Override
    public String getNome() {
        return nome;
    }
}