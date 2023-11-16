/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tde03;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author T-Gamer
 */
public class TDE03 {

    public static void main(String[] args) {
        // Criar Randomizador
        Random randomizer;
        
        // Criar Scanner para input
        Scanner scanner = new Scanner(System.in);
        
        // Variavel de Seleção
        int item;
        boolean debug = false;
        
        while (true) {
            System.out.println("\nSelecione o Tamanho do Conjunto de Dados:");
            System.out.println("\n (1) - 50");
            System.out.println("\n (2) - 500");
            System.out.println("\n (3) - 1.000");
            System.out.println("\n (4) - 5.000");
            System.out.println("\n (5) - 10.000");
            
            item = scanner.nextInt();
            
            if (item < 1 || item > 5) {
                System.out.println("Opção invalida.");
                continue;
            }
            
            switch (item) {
                case 1:
                    item = 50;
                    break;
                case 2:
                    item = 500;
                    break;
                case 3:
                    item = 1000;
                    break;
                case 4:
                    item = 5000;
                    break;
                case 5:
                    item = 10000;
                    break;
            }
            
            break;
        }
        
        System.out.printf("\nTAMANHO: %d\n", item);
        
        // Bubble Sort
        System.out.println("\nBubble Sort:");
        
        long runTime = System.nanoTime();
        int iteracoes = 0;
        int trocas = 0;
        
        for (int i = 0; i < 5; i++) {
            Vetor vetorBubble = new Vetor(item);
            
            randomizer = new Random(101);
        
            for (int k = 0; k < item; k++) {
                int randNum = randomizer.nextInt(999999999);
                vetorBubble.insert(randNum);
            }
            
            vetorBubble.bubbleSort();
            
            trocas += vetorBubble.getTrocas();
            iteracoes += vetorBubble.getIteracoes();
            
            if (i == 4 && debug) {
                vetorBubble.print();
            }
        }
        
        runTime = (System.nanoTime() - runTime) / 5;
        trocas /= 5;
        iteracoes /= 5;
        
        System.out.printf("Tempo de Execução Médio: %d\nIterações: %d\nTrocas: %d\n", runTime, iteracoes, trocas);
        
        // Merge Sort
        System.out.println("\nMerge Sort:");
        
        randomizer = new Random(101);
        
        Vetor va = new Vetor(item / 2);
        Vetor vb = new Vetor(item / 2);
        
        for (int k = 0; k < item / 2; k++) {
            va.insert(randomizer.nextInt(999999999));
            vb.insert(randomizer.nextInt(999999999));
        }

        va.bubbleSort();
        vb.bubbleSort();
        
        long runTimeMerge = System.nanoTime();
        int iteracoesMerge = 0;
        int trocasMerge = 0;
        
        for (int i = 0; i < 5; i++) {
            Vetor vetorMerge = new Vetor(item);
            vetorMerge.mergeSort(va, vb);
            
            trocasMerge += vetorMerge.getTrocas();
            iteracoesMerge += vetorMerge.getIteracoes();
            
            if (i == 4 && debug) {
                vetorMerge.print();
            }
        }
        
        runTimeMerge = (System.nanoTime() - runTimeMerge) / 5;
        trocasMerge /= 5;
        iteracoesMerge /= 5;
        
        System.out.printf("Tempo de Execução Médio: %d\nIterações: %d\nTrocas: %d\n", runTimeMerge, iteracoesMerge, trocasMerge);
        
        // Shell Sort
        System.out.println("\nShell Sort:");
        
        long runTimeShell = System.nanoTime();
        int iteracoesShell = 0;
        int trocasShell = 0;
        
        for (int i = 0; i < 5; i++) {
            Vetor vetorBubble = new Vetor(item);
            
            randomizer = new Random(101);
        
            for (int k = 0; k < item; k++) {
                int randNum = randomizer.nextInt(999999999);
                vetorBubble.insert(randNum);
            }
            
            vetorBubble.shellSort(item-1);
            
            trocasShell += vetorBubble.getTrocas();
            iteracoesShell += vetorBubble.getIteracoes();
            
            if (i == 4 && debug) {
                vetorBubble.print();
            }
        }
        
        runTimeShell = (System.nanoTime() - runTimeShell) / 5;
        trocasShell /= 5;
        iteracoesShell /= 5;
        
        System.out.printf("Tempo de Execução Médio: %d\nIterações: %d\nTrocas: %d\n", runTimeShell, iteracoesShell, trocasShell);
    }
}
