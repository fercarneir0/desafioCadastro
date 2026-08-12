package br.com.desafiocadastro.resource.files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileMenu {

    File file = new File("C:\\Users\\luis1\\IdeaProjects\\desafioCadastro\\src\\main\\java\\br\\com\\desafiocadastro\\resource\\formulario.txt");

    public List<String> lerArquivo() {
        List<String> linhaDoArquivo = new ArrayList<>();

        try (FileReader fr = new FileReader(file); BufferedReader bfr = new BufferedReader(fr)) {
            String linha;
            while ((linha = bfr.readLine()) != null) {
                linhaDoArquivo.add(linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Arquivo não encontrado");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linhaDoArquivo;
    }

    public String pegarLinhas(int posicao) {
        List<String> linhas = this.lerArquivo();

        if (posicao >= 0 && posicao < linhas.size()) {
            return linhas.get(posicao);
        } else {
            return "Posição inválida ou linha não encontrada.";
        }
    }
}
