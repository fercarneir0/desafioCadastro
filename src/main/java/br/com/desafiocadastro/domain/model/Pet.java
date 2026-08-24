package br.com.desafiocadastro.domain.model;

import br.com.desafiocadastro.domain.enums.SexoAnimal;
import br.com.desafiocadastro.domain.enums.TipoAnimal;

public class Pet {

    private String nome;
    private TipoAnimal tipoAnimal;
    private SexoAnimal sexoAnimal;
    private String endereco;
    private double idade;
    private double peso;
    private String raca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || !nome.matches("[a-zA-ZÀ-ÿ\\s]+")){
            throw new IllegalArgumentException("O nome do animal deve conter apenas letras e espaços");
        }
        this.nome = nome;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public SexoAnimal getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(SexoAnimal sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco == null || !endereco.matches("[a-zA-ZÀ-ÿ0-9\\s.,-]+")){
            throw new IllegalArgumentException("O endereço não pode conter carácteres especias");
        }
        this.endereco = endereco;
    }
    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        if(idade > 20){
            throw new IllegalArgumentException("Idade maior que 20 anos não é permitida");
        }
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso < 0.5 || peso > 60){
            throw new IllegalArgumentException("O peso menor que 0.5kg ou maior que 60kg não é permitido!");
        }
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if(raca == null || !raca.matches("[a-zA-ZÀ-ÿ\\s]+")){
            throw new IllegalArgumentException("A raça do animal deve conter apenas letras e espaços");
        }
        this.raca = raca;
    }
}
