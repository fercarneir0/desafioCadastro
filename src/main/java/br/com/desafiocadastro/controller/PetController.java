package br.com.desafiocadastro.controller;

import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;

import java.util.Scanner;

public class PetController {


    public void cadastrarPet() {
        FileMenu file = new FileMenu();
        Scanner scan = new Scanner(System.in);
        Pet pet = new Pet();

        System.out.println("------ PREENCHA AS INFORMACOES DO PET -----------");
        System.out.println(file.pegarLinhas(0));
        String nome = scan.nextLine();
        pet.setNome(nome);
        System.out.println(nome);

        System.out.println(file.pegarLinhas(1));
        System.out.println("ESCOLHA 1-CACHORRO 2-GATO");
        int codigoTipoAnimal = scan.nextInt();
        try {
            TipoAnimal tipo = TipoAnimal.getTipoPorCodigo(codigoTipoAnimal);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Por favor, tente novamente!");
        }

        System.out.println(file.pegarLinhas(2));
        System.out.println("ESCOLHA 1-MACHO 2-FEMEA");
        int codigoSexo = scan.nextInt();
        try {
            SexoAnimal sexo = SexoAnimal.getTipoPorCodigo(codigoSexo);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Por favor, tente novamente!");
        }

        System.out.println(file.pegarLinhas(3));
        String endereco = scan.next();
        scan.nextLine();
        pet.setEndereco(endereco);

        System.out.println(file.pegarLinhas(4));
        double idade = scan.nextDouble();
        try {
            pet.setIdade(idade);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.print("Por favor, tente novamente!");
        }

        System.out.println(file.pegarLinhas(5));
        double peso = scan.nextDouble();
        try{
            pet.setPeso(peso);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Por favor, tente novamente!");
        }

        System.out.println(file.pegarLinhas(6));
        String raca = scan.nextLine();
        pet.setRaca(raca);
    }
}
