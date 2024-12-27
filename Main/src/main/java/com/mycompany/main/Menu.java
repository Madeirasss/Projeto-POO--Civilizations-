package com.mycompany.main;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class Menu {
    // Método abstrato para mostrar as opções do menu
    protected abstract void mostrarOpcoes();
    // Método abstrato para processar a escolha do usuário
    protected abstract void processarEscolha(int escolha);

    // Exibe as opções do menu e processa a escolha do usuário
    public void exibirOpcoes() {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;
        boolean escolhaValida = false;

        while (!escolhaValida) {
            try {
                // Mostrar as opções do menu
                mostrarOpcoes();
                System.out.print("Escolha uma opção: ");
                // Ler a escolha do usuário
                escolha = scanner.nextInt();
                escolhaValida = true;
            } catch (InputMismatchException e) {
                // Tratamento de erro para entrada inválida
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next(); // Limpar a entrada inválida
            } catch (NoSuchElementException e) {
                // Tratamento de erro para entrada inexistente
                System.out.println("Erro de entrada! Por favor, tente novamente.");
                scanner.next(); // Limpar a entrada inválida
            }
        }

        // Processar a escolha do usuário
        processarEscolha(escolha);
    }
}