package br.com.desafiocadastro.view;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuInicial {


    public void menu() {
        PetController controller = new PetController();
        Scanner scan = new Scanner(System.in);
        String menu = "1. Cadastrar novo pet\n"
                + "2. Alterar os dados do pet cadastrado\n"
                + "3. Deletear um pet cadastrado\n"
                + "4. Listar todos os pets cadastrados\n"
                + "5. Listar pet por algum critério (idade, nome, raça)\n"
                + "6. Sair";
        int escolha = 0;
        while (escolha != 6) {
            System.out.println(menu);
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    Pet novoPet = new Pet();
                    controller.cadastrarPet(novoPet);
                    break;
                case 2:
                    System.out.println("alterar dados");
                    break;
                case 3:
                    System.out.println("deletar pet");
                    break;
                case 4:
                    controller.listarPets();
                    break;
                case 5:

                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        }
    }
}
