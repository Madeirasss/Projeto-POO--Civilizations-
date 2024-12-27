package com.mycompany.main;

// Classe que representa um edifício do tipo Fazenda
public class Fazenda implements Edificio {
    // Atributos da Fazenda
    private String nome; // Nome da Fazenda
    private int custoProducao; // Custo de produção da Fazenda
    private int custoManutencao; // Custo de manutenção da Fazenda
    private String beneficio; // Benefício proporcionado pela Fazenda

    // Construtor da classe Fazenda
    public Fazenda() {
        this.nome = "Fazenda";
        this.custoProducao = 20;
        this.custoManutencao = 2;
        this.beneficio = "Mais produção de comida";
    }

    // Método que retorna o custo de produção da Fazenda
    @Override
    public int getCustoProducao() {
        return custoProducao;
    }

    // Método que retorna o custo de manutenção da Fazenda
    @Override
    public int getCustoManutencao() {
        return custoManutencao;
    }

    // Método que retorna o benefício proporcionado pela Fazenda
    @Override
    public String getBeneficio() {
        return beneficio;
    }

    // Método que retorna o nome da Fazenda
    @Override
    public String getNome() {
        return nome;
    }
}
