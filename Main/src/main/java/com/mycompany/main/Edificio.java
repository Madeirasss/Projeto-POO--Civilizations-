package com.mycompany.main;

// Interface que representa um edifício
public interface Edificio {
    // Método que retorna o custo de produção do edifício
    int getCustoProducao();

    // Método que retorna o custo de manutenção do edifício
    int getCustoManutencao();

    // Método que retorna o benefício proporcionado pelo edifício
    String getBeneficio();

    // Método que retorna o nome do edifício
    String getNome();
}
