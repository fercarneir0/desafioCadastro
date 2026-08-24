package br.com.desafiocadastro.view;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;
import br.com.desafiocadastro.domain.model.Pet;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuInicial {


    public void menu() {
        PetController controller = new PetController();
        Scanner scan = new Scanner(System.in);
        Pet pet = new Pet();
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
                    controller.cadastrarPet(pet);
                    break;
                case 2:
                    System.out.println("alterar dados");
                    break;
                case 3:
                    controller.removerPet(pet);
                    break;
                case 4:
                    controller.listarPets();
                    break;
                case 5:
                    MenuLista menuLista = new MenuLista(controller);
                    String mensagem = ("Selecione quantos critérios deseja para fazer a listagem: \n" +
                            "1 - Um critério\n" +
                            "2 - Dois critérios\n");
                    System.out.println(mensagem);
                    int subEscolha = scan.nextInt();
                    switch (subEscolha) {
                        case 1:
                            menuLista.menuListaUmCriterio();
                            break;
                        case 2:
                            menuLista.menuListaDoisCriterios();
                            break;
                        default:
                            System.out.println("Escolha uma opção válida!");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Finalizando o programa! :D");
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        }
    }
}
