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

            System.out.println("Pets cadastrados : " + pets.size());
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

    public Predicate<Pet> filtroNome(String nome){
        return pet -> pet.getNome()
                .toLowerCase()
                .contains(nome.toLowerCase());
    }

    public Predicate<Pet> filtroTipoAnimal(int codigoEspecie){
        TipoAnimal tipoAnimal = TipoAnimal.getTipoPorCodigo(codigoEspecie);
        return pet -> pet.getTipoAnimal() == tipoAnimal;
    }

    public Predicate<Pet> filtroSexoAnimal(int codigoSexo){
        SexoAnimal sexoAnimal = SexoAnimal.getTipoPorCodigo(codigoSexo);
        return pet -> pet.getSexoAnimal() == sexoAnimal;
    }

    public Predicate<Pet> filtroPesoAnimal(double peso){
        return pet -> pet.getPeso() == peso;
    }

    public Predicate<Pet> filtroIdadeAnimal(double idade){
        return pet -> pet.getIdade() == idade;
    }

    public Predicate<Pet> filtroRacaAnimal(String raca){
        return pet -> pet.getRaca()
                .toLowerCase()
                .contains(raca.toLowerCase());
    }

    public Predicate<Pet> filtroEnderecoAnimal(String endereco){
        return pet -> pet.getEndereco()
                .toLowerCase()
                .contains(endereco.toLowerCase());
    }

    public List<Pet> filtrarPets(Predicate<Pet> filtro){
        List<Pet> encontrados = new ArrayList<>();

        for (Pet pet : pets) {

            if(filtro.test(pet)){
                encontrados.add(pet);
            }
        }
        return encontrados;
    }
}


