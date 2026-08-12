package br.com.desafiocadastro.controller;

import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;
import br.com.desafiocadastro.view.ConsoleInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PetController {
    FileMenu file;
    ConsoleInput input;

    public void cadastrarPet() {
    }

    public void cadastrarNome(Pet pet) {
        String nomeDigitado = input.lerString(file.pegarLinhas(0));

        while (true) {
            try {
                pet.setNome(nomeDigitado);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor tente novamente\n");
            }
        }
    }

    public void cadastrarTipo(Pet pet) {
        while (true) {
            int codigoDigitado = input.lerInt(file.pegarLinhas(1));

            try {
                TipoAnimal animalEscolhido = TipoAnimal.getTipoPorCodigo(codigoDigitado);
                pet.setTipoAnimal(animalEscolhido);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }

    public void cadastrarSexo(Pet pet){
        while(true){
            int codigoDigitado = input.lerInt(file.pegarLinhas(2));

            try{
                SexoAnimal sexoEscolhido = SexoAnimal.getTipoPorCodigo(codigoDigitado);
                pet.setSexoAnimal(sexoEscolhido);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }

    public void cadastrarIdade(Pet pet) {
        while (true) {
            double idadeDigitada = input.lerDouble(file.pegarLinhas(4));

            try {
                pet.setIdade(idadeDigitada);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }

    public void cadastrarPeso(Pet pet) {
        while (true) {
            double pesoDigitado = input.lerDouble(file.pegarLinhas(5));

            try {
                pet.setPeso(pesoDigitado);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }

    public void cadastrarRaca(Pet pet) {
        while (true) {
            String racaDigitada = input.lerString(file.pegarLinhas(6));

            try {
                pet.setRaca(racaDigitada);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }
}
