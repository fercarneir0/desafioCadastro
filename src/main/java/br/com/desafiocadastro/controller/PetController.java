package br.com.desafiocadastro.controller;

import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;
import br.com.desafiocadastro.view.ConsoleInput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


public class PetController {
    private List<Pet> pets = new ArrayList<>();
    FileMenu file = new FileMenu();
    ConsoleInput input = new ConsoleInput();


    public void cadastrarPet(Pet pet) {
        try {
            cadastrarNome(pet);
            cadastrarTipo(pet);
            cadastrarSexo(pet);
            cadastrarEndereco(pet);
            cadastrarIdade(pet);
            cadastrarPeso(pet);
            cadastrarRaca(pet);

            pets.add(pet);
            gerarArquivo(pet);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Não foi possível cadastrar o animal");
        }
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

    public void cadastrarSexo(Pet pet) {
        while (true) {
            int codigoDigitado = input.lerInt(file.pegarLinhas(2));

            try {
                SexoAnimal sexoEscolhido = SexoAnimal.getTipoPorCodigo(codigoDigitado);
                pet.setSexoAnimal(sexoEscolhido);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Por favor, tente novamente");
            }
        }
    }

    public void cadastrarEndereco(Pet pet) {
        while (true) {
            String enderecoDigitado = input.lerEndereco(file.pegarLinhas(3));

            try {
                pet.setEndereco(enderecoDigitado);
                break;
            } catch (IllegalArgumentException e) {
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

    public void gerarArquivo(Pet pet) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd_Hhmm");

        String dataFormatada = localDateTime.format(dateTimeFormatter);
        String caminhoPasta = "src\\petsCadastrados";
        String nomeArquivo = dataFormatada + "-" + pet.getNome();

        if (pet.getNome() == null) {
            System.out.println("Erro: Pet inválido ou sem nome. Por favor, tente novamente!");
            return;
        }

        File pasta = new File(caminhoPasta);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File arquivo = new File(pasta, nomeArquivo);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write("1 - " + pet.getNome());
            bw.newLine();
            bw.write("2 - " + pet.getTipoAnimal());
            bw.newLine();
            bw.write("3 - " + pet.getSexoAnimal());
            bw.newLine();
            bw.write("4 - " + pet.getEndereco());
            bw.newLine();
            bw.write("5 - " + pet.getIdade());
            bw.newLine();
            bw.write("6 - " + pet.getPeso());
            bw.newLine();
            bw.write("7 - " + pet.getRaca());
            System.out.println("Animal " + pet.getNome() + " cadastrado com sucesso! ✅");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo: " + e.getMessage());
        }
    }

    public void listarPets() {

        if (pets.isEmpty()) {
            System.out.println("Não foi encontrado nenhum animal");
            return;
        }

        int i = 0;
        for (Pet pet : pets) {
            i++;
            System.out.println("[" + i + "]"+ " - " + pet.getNome());

        }
    }

    public void listaEspecifica() {
        Scanner scan = new Scanner(System.in);
        String mensagem = "Escolha uma opção para listar\n" +
                "1. Listar por nome\n" +
                "2. Listar por tipo do animal\n" +
                "3. Listar por sexo do animal\n"+
                "4. Sair\n";
        int escolha = 0;
        while (escolha != 4) {
            System.out.println(mensagem);
            escolha = scan.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome que deseja buscar");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    List<Pet> petNomes = listarPorNome(nome);

                    if(petNomes.isEmpty()){
                        System.out.println("Nenhum animal com esse nome foi encontrado");
                    } else {
                        System.out.println("\nAnimais encontrados:");
                        int i = 0;
                        for (Pet pet : pets) {
                            i++;
                            System.out.println("[" + i + "]"+ " - " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 2:
                    System.out.println("Selecione o tipo que deseja procurar:\n " + "1 - Cachorro/ 2 - Gato");
                    int tipoAnimal = scan.nextInt();

                    List<Pet> petTipo = listaPorTipo(tipoAnimal);
                    if(petTipo.isEmpty()) {
                        System.out.println("Nenhum animal foi encontrado.");
                    } else {
                        System.out.println("\nAnimais encontrados:");
                        int i = 0;
                        for (Pet pet : pets) {
                            i++;
                            System.out.println("[" + i + "]" + " - " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Selecione o sexo que deseja procurar:\n " + "1 - Macho / 2 - Fêmea");
                    int sexoAnimal = scan.nextInt();
                    List<Pet> petSexo = listaPorSexo(sexoAnimal);

                    if(petSexo.isEmpty()){
                        System.out.println("\nNenhum animal foi encontrado");
                    } else {
                        System.out.println("Animais encontrados:");
                        int i = 0;
                        for (Pet pet : pets) {
                            i++;
                            System.out.println(i + "." + " " + pet.getNome());
                        }
                        System.out.println("--------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Selecione uma opção válida");
                    break;
            }
        }
    }

    public List<Pet> listarPorNome(String nome) {
        List<Pet> encontrados = new ArrayList<>();

        for (Pet pet : pets) {
            if (pet.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(pet);
            }
        }
        return encontrados;
    }

    public List<Pet> listaPorTipo(int codigoEspecie) {
        List<Pet> encontrados = new ArrayList<>();
        TipoAnimal tipoAnimal = TipoAnimal.getTipoPorCodigo(codigoEspecie);
        for (Pet pet : pets) {
            if (pet.getTipoAnimal() == tipoAnimal) {
                encontrados.add(pet);
            }
        }
        return encontrados;
    }

    public List<Pet> listaPorSexo(int codigoSexo) {
        List<Pet> encontrados = new ArrayList<>();
        SexoAnimal sexoAnimal = SexoAnimal.getTipoPorCodigo(codigoSexo);
        for (Pet pet : pets) {
            if (pet.getSexoAnimal() == sexoAnimal) {
                encontrados.add(pet);
            }
        }
        return encontrados;
    }

    public Predicate<Pet> filtroNome(String nome){
        return pet -> pet.getNome().equalsIgnoreCase(nome);
    }
}


