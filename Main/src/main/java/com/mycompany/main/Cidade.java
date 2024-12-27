package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Classe que representa uma cidade
public class Cidade implements LevarDano {
    // Atributos da cidade
    private String nome; // Nome da cidade
    private int populacao; // População da cidade
    private Recurso comida; // Recurso de comida
    private Recurso producao; // Recurso de produção
    private Recurso ouro; // Recurso de ouro
    private int vida; // Vida da cidade
    private List<Terreno> terrenosTrabalhados; // Lista de terrenos trabalhados
    private int x; // Coordenada x da cidade
    private int y; // Coordenada y da cidade
    private Map<String, Edificio> edificios; // Mapa de edifícios construídos na cidade
    private Map<String, Recurso> recursos; // Mapa de recursos da cidade
    private boolean inimigo; // Adicionado atributo para verificar se a cidade é inimiga

    // Construtor da classe Cidade
    public Cidade(String nome, int x, int y, boolean inimigo) {
        this.nome = nome;
        this.populacao = 1;
        this.comida = new Recurso("Comida", 0);
        this.producao = new Recurso("Produção", 0);
        this.ouro = new Recurso("Ouro", 0);
        this.vida = 50;
        this.terrenosTrabalhados = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.edificios = new HashMap<>();
        this.recursos = new HashMap<>();
        this.recursos.put("Comida", comida);
        this.recursos.put("Produção", producao);
        this.recursos.put("Ouro", ouro);
        this.inimigo = inimigo;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome; // Retorna o nome da cidade
    }

    public int getPopulacao() {
        return populacao; // Retorna a população da cidade
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao; // Define a população da cidade
    }

    public int getX() {
        return x; // Retorna a coordenada x da cidade
    }

    public int getY() {
        return y; // Retorna a coordenada y da cidade
    }

    public Recurso getComida() {
        return comida; // Retorna o recurso de comida
    }

    public Recurso getProducao() {
        return producao; // Retorna o recurso de produção
    }

    public Recurso getOuro() {
        return ouro; // Retorna o recurso de ouro
    }

    public int getVida() {
        return vida; // Retorna a vida da cidade
    }

    public boolean isInimigo() {
        return inimigo; // Retorna se a cidade é inimiga
    }

    // Método para aplicar dano à cidade
    @Override
    public void levarDano(int dano) {
        vida -= dano; // Reduz a vida da cidade pelo valor do dano
        System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + vida);
        if (vida <= 0) {
            System.out.println(nome + " foi destruída!");
            edificios.clear(); // Remove todos os edifícios da cidade
        }
    }

    // Métodos para gerenciar terrenos trabalhados
    public List<Terreno> getTerrenosTrabalhados() {
        return terrenosTrabalhados; // Retorna a lista de terrenos trabalhados
    }

    public void adicionarTerrenoTrabalhado(Terreno terreno) {
        if (terrenosTrabalhados.size() < populacao) {
            terrenosTrabalhados.add(terreno); // Adiciona um terreno à lista de terrenos trabalhados
        } else {
            System.out.println("Todos os cidadãos já estão trabalhando.");
        }
    }

    public void removerTerrenoTrabalhado(Terreno terreno) {
        terrenosTrabalhados.remove(terreno); // Remove um terreno da lista de terrenos trabalhados
    }

    // Método para realizar ações de turno
    public void realizarTurno() {
        for (Terreno terreno : terrenosTrabalhados) {
            comida.adicionar(terreno.getRendimentoComida()); // Adiciona o rendimento de comida dos terrenos trabalhados
            producao.adicionar(terreno.getRendimentoProducao()); // Adiciona o rendimento de produção dos terrenos trabalhados
            ouro.adicionar(terreno.getRendimentoOuro()); // Adiciona o rendimento de ouro dos terrenos trabalhados
        }

        for (Edificio edificio : edificios.values()) {
            ouro.remover(edificio.getCustoManutencao()); // Remove o custo de manutenção dos edifícios
            aplicarBeneficio(edificio); // Aplica os benefícios dos edifícios
        }

        int consumoComida = calcularConsumoComida(); // Calcula o consumo de comida
        if (comida.getQuantidade() >= consumoComida) {
            comida.remover(consumoComida); // Remove o consumo de comida
            crescerPopulacao(); // Cresce a população se houver comida suficiente
        } else {
            reduzirPopulacao(); // Reduz a população se não houver comida suficiente
        }
    }
    
    // Método para calcular o consumo de comida
    private int calcularConsumoComida() {
        return this.populacao * 2; // Exemplo: cada unidade de população consome 2 unidades de comida por turno
    }

    // Método para crescer a população
    private void crescerPopulacao() {
        if (comida.getQuantidade() > 10) { // Exemplo: se houver mais de 10 unidades de comida, a população cresce
            this.populacao++;
            comida.remover(10); // Consome 10 unidades de comida para crescer a população
        }
    }

    // Método para reduzir a população
    private void reduzirPopulacao() {
        if (this.populacao > 1) {
            this.populacao--; // Reduz a população se for maior que 1
        }
    }

    // Método para usar ouro
    public void usarOuro(int quantidade) {
        if (ouro.getQuantidade() >= quantidade) {
            ouro.remover(quantidade); // Remove a quantidade de ouro especificada
        } else {
            throw new IllegalArgumentException("Ouro insuficiente.");
        }
    }

    // Método para construir um edifício
    public void construirEdificio(String nome, Edificio edificio) {
        if (!edificios.containsKey(nome)) {
            if (producao.getQuantidade() >= edificio.getCustoProducao()) {
                producao.remover(edificio.getCustoProducao()); // Remove o custo de produção do edifício
                edificios.put(nome, edificio); // Adiciona o edifício ao mapa de edifícios
                aplicarBeneficio(edificio); // Aplica os benefícios do edifício
                System.out.println("Edifício " + nome + " construído.");
            } else {
                System.out.println("Produção insuficiente para construir " + nome + ".");
            }
        } else {
            System.out.println("Edifício " + nome + " já existe.");
        }
    }

    // Método para demolir um edifício
    public void demolirEdificio(String nome) {
        if (edificios.containsKey(nome)) {
            Edificio edificio = edificios.remove(nome); // Remove o edifício do mapa de edifícios
            removerBeneficio(edificio); // Remove os benefícios do edifício
            System.out.println("Edifício " + nome + " demolido.");
        } else {
            System.out.println("Edifício " + nome + " não existe.");
        }
    }

    // Método para obter um edifício
    public Edificio getEdificio(String nome) {
        return edificios.get(nome); // Retorna o edifício pelo nome
    }

    // Método para obter todos os edifícios
    public Map<String, Edificio> getEdificios() {
        return edificios; // Retorna o mapa de edifícios
    }

    // Método para enviar recursos para outra cidade
    public void enviarRecurso(Cidade destino, String tipoRecurso, int quantidade) {
        Recurso recurso = this.recursos.get(tipoRecurso);
        if (recurso != null && recurso.getQuantidade() >= quantidade) {
            recurso.remover(quantidade); // Remove a quantidade de recurso especificada
            destino.receberRecurso(tipoRecurso, quantidade); // Envia o recurso para a cidade de destino
            System.out.println("Enviou " + quantidade + " de " + tipoRecurso + " para " + destino.getNome());
        } else {
            System.out.println(tipoRecurso + " insuficiente para enviar.");
        }
    }

    // Método para receber recursos de outra cidade
    public void receberRecurso(String tipoRecurso, int quantidade) {
        Recurso recurso = this.recursos.get(tipoRecurso);
        if (recurso != null) {
            recurso.adicionar(quantidade); // Adiciona a quantidade de recurso especificada
        } else {
            recurso = new Recurso(tipoRecurso, quantidade); // Cria um novo recurso se não existir
            this.recursos.put(tipoRecurso, recurso);
        }
    }

    // Método para aplicar benefícios de um edifício
    private void aplicarBeneficio(Edificio edificio) {
        String beneficio = edificio.getBeneficio();
        switch (beneficio) {
            case "Produção militar mais rápida":
                // Implementar lógica para produção militar mais rápida
                break;
            case "Mais produção de ouro":
                ouro.adicionar(ouro.getQuantidade()); // Duplicar a produção de ouro
                break;
            case "Mais produção de comida":
                comida.adicionar(comida.getQuantidade()); // Duplicar a produção de comida
                break;
            // Adicionar mais casos conforme necessário
        }
    }

    // Método para remover benefícios de um edifício
    private void removerBeneficio(Edificio edificio) {
        String beneficio = edificio.getBeneficio();
        switch (beneficio) {
            case "Produção militar mais rápida":
                break;
            case "Mais produção de ouro":
                ouro.remover(ouro.getQuantidade() / 2); // Reverter a duplicação da produção de ouro
                break;
            case "Mais produção de comida":
                comida.remover(comida.getQuantidade() / 2); // Reverter a duplicação da produção de comida
                break;
            // Adicionar mais casos conforme necessário
        }
    }

    // Método toString para representar a cidade como string
    @Override
    public String toString() {
        return "Cidade: " + nome + " | População: " + populacao + " | Vida: " + vida + " | " + comida + " | " + producao + " | " + ouro + " | Edifícios: " + edificios.keySet();
    }
}