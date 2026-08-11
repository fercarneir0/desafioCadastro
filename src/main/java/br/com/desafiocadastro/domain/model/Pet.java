package br.com.desafiocadastro.domain.model;

import br.com.desafiocadastro.domain.enums.sexoAnimal;
import br.com.desafiocadastro.domain.enums.tipoAnimal;

public class Pet {

    private String nome;
    private tipoAnimal tipoAnimal;
    private sexoAnimal sexoAnimal;
    private String endereco;
    private String bairro;
    private double idade;
    private double peso;
    private String raca;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public tipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(tipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public sexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(sexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
}
