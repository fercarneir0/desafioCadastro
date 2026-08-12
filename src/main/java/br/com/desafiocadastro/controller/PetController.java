package br.com.desafiocadastro.controller;

import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;

import java.util.Scanner;

public class PetController {


    public void cadastrarPet(){
        FileMenu file = new FileMenu();
        Scanner scan = new Scanner(System.in);
        Pet pet = new Pet();

        System.out.println("------ PREENCHA AS INFORMACOES DO PET -----------");
        System.out.println(file.pegarLinhas(0));
        String nome = scan.next();
        pet.setNome(nome);
        System.out.println(file.pegarLinhas(1));
        System.out.println("ESCOLHA 1-CACHORRO 2-GATO");
        int codigoTipoAnimal = scan.nextInt();
        TipoAnimal tipo = TipoAnimal.getTipoPorCodigo(codigoTipoAnimal);
        System.out.println(file.pegarLinhas(2));
        System.out.println("ESCOLHA 1-MACHO 2-FEMEA");
        int codigoSexo = scan.nextInt();
        SexoAnimal sexo = SexoAnimal.getTipoPorCodigo(codigoSexo);
    }
}
