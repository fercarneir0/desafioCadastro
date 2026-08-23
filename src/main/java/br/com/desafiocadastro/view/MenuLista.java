package br.com.desafiocadastro.view;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MenuLista {
    public void menuListaAnimal() {
        Scanner scan = new Scanner(System.in);
        PetController controller = new PetController();
        String mensagem = "Escolha uma opção para listar\n" +
                "1. Listar por nome\n" +
                "2. Listar por tipo do animal\n" +
                "3. Listar por sexo do animal\n" +
                "4. Listar por idade\n" +
                "5. Listar por peso\n" +
                "6. Listar por raça\n" +
                "7. Listar por endereço\n" +
                "8. Retornar";
        int escolha = 0;
        while (escolha != 8) {
            System.out.println(mensagem);
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome que deseja buscar");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    Predicate<Pet> nomeFiltrado = controller.filtroNome(nome);
                    List<Pet> petNomes = controller.filtrarPets(nomeFiltrado);

                    if (petNomes.isEmpty()) {
                        System.out.println("Nenhum animal com esse nome foi encontrado");
                    } else {
                        System.out.println("\nAnimais encontrados:");
                        int i = 0;
                        for (Pet pet : petNomes) {
                            i++;
                            System.out.println("[" + i + "]" + " - " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Selecione o tipo que deseja procurar:\n " + "1 - Cachorro/ 2 - Gato");
                    int tipoAnimal = scan.nextInt();

                    Predicate<Pet> tipoAnimalFiltrado = controller.filtroTipoAnimal(tipoAnimal);
                    List<Pet> petTipo = controller.filtrarPets(tipoAnimalFiltrado);
                    if (petTipo.isEmpty()) {
                        System.out.println("Nenhum animal foi encontrado.");
                    } else {
                        System.out.println("\nAnimais encontrados:");
                        int i = 0;
                        for (Pet pet : petTipo) {
                            i++;
                            System.out.println("[" + i + "]" + " - " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Selecione o sexo que deseja procurar:\n " + "1 - Macho / 2 - Fêmea");
                    int sexoAnimal = scan.nextInt();

                    Predicate<Pet> tipoSexoAnimalFiltrado = controller.filtroSexoAnimal(sexoAnimal);
                    List<Pet> petSexo = controller.filtrarPets(tipoSexoAnimalFiltrado);

                    if (petSexo.isEmpty()) {
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados:");
                        int i = 0;
                        for (Pet pet : petSexo) {
                            i++;
                            System.out.println(i + "." + " " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Digite a idade que deseja procurar: ");
                    double idade = scan.nextDouble();

                    Predicate<Pet> idadeFiltrada = controller.filtroIdadeAnimal(idade);
                    List<Pet> petIdade = controller.filtrarPets(idadeFiltrada);

                    if (petIdade.isEmpty()) {
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados");
                        int i = 0;
                        for (Pet pet : petIdade) {
                            i++;
                            System.out.println(i + ". " + pet.getNome());
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("Digite o peso que deseja procurar: ");
                    double peso = scan.nextDouble();

                    Predicate<Pet> pesoFiltrado = controller.filtroPesoAnimal(peso);
                    List<Pet> petPeso = controller.filtrarPets(pesoFiltrado);

                    if (petPeso.isEmpty()) {
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados: ");
                        int i = 0;
                        for (Pet pet : petPeso) {
                            i++;
                            System.out.println(i + ". " + pet.getNome());
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 6:
                    System.out.println("Digite qual raça deseja procurar: ");
                    scan.nextLine();
                    String raca = scan.nextLine();

                    Predicate<Pet> racaFiltrada = controller.filtroRacaAnimal(raca);
                    List<Pet> petRaca = controller.filtrarPets(racaFiltrada);

                    if (petRaca.isEmpty()) {
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados: ");
                        int i = 0;
                        for (Pet pet : petRaca) {
                            System.out.println(i + ". " + pet.getNome());
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 7:
                    System.out.println("Digite o endereço que deseja procurar: ");
                    scan.nextLine();
                    String endereco = scan.nextLine();

                    Predicate<Pet> enderecoFiltrado = controller.filtroEnderecoAnimal(endereco);
                    List<Pet> petEndereco = controller.filtrarPets(enderecoFiltrado);

                    if (petEndereco.isEmpty()) {
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados: ");
                        int i = 0;
                        for (Pet pet : petEndereco) {
                            System.out.println(i + ". " + pet.getNome());
                        }
                        System.out.println("-------------------------------------");
                    }
                    break;
                case 8:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Por favor, selecione uma opção válida");
                    break;
            }
        }
    }
}
