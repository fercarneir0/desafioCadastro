package br.com.desafiocadastro.view;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class MenuLista {
    Scanner scan = new Scanner(System.in);
    PetController controller;
    DecimalFormat df = new DecimalFormat("0.#");
    public MenuLista(PetController controller) {
        this.controller = controller;
    }

    public void menuListaUmCriterio() {
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
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            i++;
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
                            i++;
                            System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                                    " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
                        }
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
    public void menuListaDoisCriterios(){
        System.out.println("Escolha a primeira opção\n" +
                "1. Listar por nome\n" +
                "2. Listar por tipo do animal\n" +
                "3. Listar por sexo do animal\n" +
                "4. Listar por idade\n" +
                "5. Listar por peso\n" +
                "6. Listar por raça\n" +
                "7. Listar por endereço\n");

        int opcao1 = scan.nextInt();
        Predicate<Pet> filtro1 = criarFiltro(opcao1);

        System.out.println("Escolha a segunda opção\n" +
                "1. Listar por nome\n" +
                "2. Listar por tipo do animal\n" +
                "3. Listar por sexo do animal\n" +
                "4. Listar por idade\n" +
                "5. Listar por peso\n" +
                "6. Listar por raça\n" +
                "7. Listar por endereço\n");

        int opcao2 = scan.nextInt();
        Predicate<Pet> filtro2 = criarFiltro(opcao2);


        Predicate<Pet> filtroFinal = filtro1.and(filtro2);

        List<Pet> encontrados = controller.filtrarPets(filtroFinal);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum animal encontrado\n");
        } else {
            System.out.println("\nAnimais encontrados:");
            int i = 0;

            for (Pet pet : encontrados) {
                i++;
                System.out.println(i + ". " + pet.getNome() + " - " + pet.getTipoAnimal() + " - " + pet.getSexoAnimal() + " - " + pet.getEndereco() +
                        " - " + df.format(pet.getIdade()) + " anos - " + pet.getRaca());
            }
        }
    }

    public Predicate<Pet> criarFiltro(int opcao) {

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome que deseja buscar: ");
                scan.nextLine();
                String nome = scan.nextLine();

                return controller.filtroNome(nome);
            case 2:
                System.out.println("Selecione o tipo de animal: 1 - Cachorro / 2 - Gato");
                int tipoAnimal = scan.nextInt();

                return controller.filtroTipoAnimal(tipoAnimal);
            case 3:
                System.out.println("Selecione o sexo do animal: 1 - Macho / 2 - Fêmea");
                int sexoAnimal = scan.nextInt();

                return controller.filtroSexoAnimal(sexoAnimal);
            case 4:
                System.out.println("Digite a idade que deseja buscar: ");
                double idadeAnimal = scan.nextDouble();

                return controller.filtroIdadeAnimal(idadeAnimal);
            case 5:
                System.out.println("Digite o peso que deseja buscar: ");
                double pesoAnimal = scan.nextDouble();

                return controller.filtroPesoAnimal(pesoAnimal);
            case 6:
                System.out.println("Digite a raça que deseja buscar: ");
                scan.nextLine();
                String racaAnimal = scan.nextLine();

                return controller.filtroRacaAnimal(racaAnimal);
            case 7:
                System.out.println("Digite o endereço que deseja buscar: ");
                scan.nextLine();
                String enderecoAnimal = scan.nextLine();

                return controller.filtroEnderecoAnimal(enderecoAnimal);
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }
}
