package br.com.desafiocadastro.view;

import java.util.Scanner;

public class ConsoleInput {
    Scanner scan = new Scanner(System.in);

    public ConsoleInput(Scanner scan) {
        this.scan = scan;
    }

    public String lerString(String mensagem) {
        System.out.println(mensagem);
        return scan.nextLine();
    }

    public double lerDouble(String mensagem){
        while(true){
            System.out.println(mensagem);
            try{
                double valor = scan.nextDouble();
                scan.nextLine();
                return valor;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: Por favor digite apenas valores válidos!");
            }
        }
    }
}
