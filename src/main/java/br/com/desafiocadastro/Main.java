package br.com.desafiocadastro;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;
import br.com.desafiocadastro.view.ConsoleInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        PetController controller = new PetController();

        controller.cadastrarPet(pet);
    }
}
