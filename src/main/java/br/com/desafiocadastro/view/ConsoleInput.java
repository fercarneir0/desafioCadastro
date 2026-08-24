package br.com.desafiocadastro.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    Scanner scan = new Scanner(System.in);

    public String lerString(String mensagem) {
        while(true){
            System.out.println(mensagem);
            try{
                String valor = scan.nextLine();
                return valor;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: " +e.getMessage());
            }
        }
    }

    public double lerDouble(String mensagem){
        while(true){
            System.out.println(mensagem);
            try{
                double valor = scan.nextDouble();
                scan.nextLine();

                return valor;
            } catch (InputMismatchException e){
                System.out.println("Erro: Por favor digite apenas valores válidos!");
                scan.nextLine();
            }
        }
    }

    public int lerInt(String mensagem){
        while(true){
            System.out.println(mensagem);

            try{
                int valor = scan.nextInt();
                scan.nextLine();
                return valor;
            } catch (InputMismatchException e){
                System.out.println("Erro: por favor digite apenas valores válidos");
                scan.nextLine();
            }
        }
    }

    public String lerEndereco(String mensagem){
        while(true){
            System.out.println(mensagem);
            try{
                System.out.println("Digite o número da casa: ");
                String numeroCasa = scan.nextLine();
                System.out.println("Digite a cidade: ");
                String cidade = scan.nextLine();
                System.out.println("Digite a rua: ");
                String rua = scan.nextLine();
                String enderecoCompleto = rua + ", " + cidade + " N." + numeroCasa;
                return enderecoCompleto;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: por favor digite apenas letras, números e pontuação");
                scan.nextLine();
            }
        }
    }
}
