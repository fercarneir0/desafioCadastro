package br.com.desafiocadastro.domain.enums;

public enum tipoAnimal {
    CACHORRO(1),
    FEMEA(2);

    private int codigo;

    tipoAnimal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
