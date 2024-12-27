package com.mycompany.main;

// Classe que implementa a interface Edificio
public class EdificioImpl implements Edificio {
    // Atributos do edifício
    private String nome; // Nome do edifício
    private int custoProducao; // Custo de produção do edifício
    private int custoManutencao; // Custo de manutenção do edifício
    private String beneficio; // Benefício proporcionado pelo edifício

    // Construtor da classe EdificioImpl
    public EdificioImpl(String nome, int custoProducao, int custoManutencao, String beneficio) {
        this.nome = nome;
        this.custoProducao = custoProducao;
        this.custoManutencao = custoManutencao;
        this.beneficio = beneficio;
    }

    // Método que retorna o custo de produção do edifício
    @Override
    public int getCustoProducao() {
        return custoProducao;
    }

    // Método que retorna o custo de manutenção do edifício
    @Override
    public int getCustoManutencao() {
        return custoManutencao;
    }

    // Método que retorna o benefício proporcionado pelo edifício
    @Override
    public String getBeneficio() {
        return beneficio;
    }

    // Método que retorna o nome do edifício
    @Override
    public String getNome() {
        return nome;
    }
}
