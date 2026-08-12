package br.com.desafiocadastro;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileMenu fileMenu = new FileMenu();
        PetController pet = new PetController();

        pet.cadastrarPet();
    }
}
