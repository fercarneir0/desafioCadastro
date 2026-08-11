package br.com.desafiocadastro.domain.enums;

public enum sexoAnimal {
    MACHO(1), FEMEA(2);


    private int codigo;

    sexoAnimal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
