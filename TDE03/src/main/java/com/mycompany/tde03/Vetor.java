/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tde03;

/**
 *
 * @author T-Gamer
 */
public class Vetor {
    private int size;
    private int[] array;
    private int last;
    
    private int trocas;
    private int iteracoes;
    
    public Vetor(int size) {
        this.size = size;
        this.array = new int[size];
        this.last = 0;
        this.trocas = 0;
        this.iteracoes = 0;
    }
    
    public void insert(int data) {
        if (this.size > this.last) {
            this.array[this.last] = data;
            this.last += 1;
        } else {
            System.out.println("Erro durante inserção, O Vetor está cheio.");
        }
    }
    
    public int getSize() {
        return this.size;
    }
    
    public int getTrocas() {
        return this.trocas;
    }
    
    public int getIteracoes() {
        return this.iteracoes;
    }
    
    public int getData(int i) {
        if (i < this.size && i >= 0) {
            return this.array[i];
        } else {
            return -1;
        }
    }
    
    public void bubbleSort() { // Baseada em um trabalho anterior no semestre
        boolean hasChanged = true;
        
        while (hasChanged) {
            this.iteracoes += 1;
            hasChanged = false;
                    
            for (int i = 0; i < this.size - 1; i++) {
                int Curr = this.array[i];
                int Nex = this.array[i + 1];

                if (Nex < Curr) {
                    this.trocas += 1;
                    hasChanged = true;
                    
                    this.array[i] = Nex;
                    this.array[i + 1] = Curr;
                }
            }
        }
    }
    
    public void mergeSort(Vetor a1, Vetor a2) { // Baseada em um trabalho anterior no semestre
        int j = 0;
        int k = 0;
        
        while (a1.getData(j) != -1 || a2.getData(k) != -1) {
            this.iteracoes += 1;
            
            int valA = a1.getData(j);
            int valB = a2.getData(k);
            
            if (valA != -1 && valB != -1 && valA < valB) { // Caso A menor que B
                this.insert(valA);
                j += 1;
                
            } else if (valB != -1) { // Caso A não existe ou B menor que A
                this.insert(valB);
                this.trocas += 1;
                k += 1;
                
            } else if (valA != -1) { // Caso B não exista
                this.insert(valA);
                j += 1;
                
            }
        }
    }
    
    public void shellSort(int initialIncrement) {
        for (int i = initialIncrement; i > 0; i--) { // Baseada na Função providencia no pdf de ShellSort
            if (i % 2 == 0) {
                continue;
            }
            
            this.iteracoes += 1;
            
            for (int j = i; j < initialIncrement; j++) { 
                int valA = this.array[j]; 
                int Aux;   
                
                for (Aux = j; Aux >= i && this.array[Aux - i] > valA; Aux -= i) {
                    this.array[Aux] = this.array[Aux - i]; 
                }
                
                if (this.getData(Aux) != valA) {
                    this.trocas += 1;
                    this.array[Aux] = valA; 
                }
            } 
        } 
    }
    
    public void print() {
        System.out.printf("Iterações: %d\nTrocas: %d\n", this.iteracoes, this.trocas);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%d -> %d\n", i, this.array[i]);
        }
    }
}
