package br.com.desafiocadastro;

import br.com.desafiocadastro.view.MenuInicial;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
        System.out.println("Bem-vindo ao sistema PetLovers");
        System.out.println("O que desejas fazer? Estamos aqui para te ajudar");

        menu.menu();
    }
}
