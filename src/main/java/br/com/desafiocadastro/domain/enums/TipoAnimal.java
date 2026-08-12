package br.com.desafiocadastro.domain.enums;

public enum TipoAnimal {
    CACHORRO(1),
    FEMEA(2);

    private int codigo;

    TipoAnimal(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoAnimal getTipoPorCodigo(int codigo){
        for (TipoAnimal tipo : TipoAnimal.values()){
            if(tipo.codigo == codigo){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Opção inválida. Escolha 1 para CACHORRO ou 2 para GATO");
    }
}
