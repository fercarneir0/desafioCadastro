package br.com.desafiocadastro.domain.enums;

public enum SexoAnimal {
    MACHO(1), FEMEA(2);


    private int codigo;

    SexoAnimal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static SexoAnimal getTipoPorCodigo(int codigo){
        for (SexoAnimal tipo : SexoAnimal.values()){
            if (tipo.codigo == codigo){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Opção inválida. Escolha 1 para MACHO ou 2 para FEMEA");
    }
}
