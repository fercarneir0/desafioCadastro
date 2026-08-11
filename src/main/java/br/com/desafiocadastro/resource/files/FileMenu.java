package br.com.desafiocadastro.resource.files;

import java.io.*;

public class FileMenu {

    File file = new File("C:\\Users\\luis1\\IdeaProjects\\desafioCadastro\\src\\main\\java\\br\\com\\desafiocadastro\\resource\\formulario.txt");
//
//    public void escreverArquivo(){
//        try (FileWriter fileWriter = new FileWriter(file)){
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            String linha;
//            bufferedWriter.write("1 - Qual o nome e sobrenome do pet?\n2 - Qual o tipo do pet?\n3 - Qual o sexo do animal?\n4 - Qual endereço e bairro que ele foi encontrado?");
//            bufferedWriter.write("\n5 - Qual a idade aproximada do pet?\n6 - Qual o peso aproximado do pet?\n7 - Qual a raça do pet?");
//            bufferedWriter.flush();
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    public void lerArquivo(){
        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String linha;
            while((linha = bufferedReader.readLine()) != null){
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
