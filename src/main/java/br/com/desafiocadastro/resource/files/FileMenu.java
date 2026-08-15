package br.com.desafiocadastro.resource.files;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMenu {

    public List<String> lerArquivo() {
        List<String> linhaDoArquivo = new ArrayList<>();

        String caminhoAbsoluto = "br/com/desafiocadastro/resource/formulario.txt";
        InputStream is = getClass().getClassLoader().getResourceAsStream(caminhoAbsoluto);

        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
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
