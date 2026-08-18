package br.com.desafiocadastro;

import br.com.desafiocadastro.controller.PetController;
import br.com.desafiocadastro.domain.model.Pet;
import br.com.desafiocadastro.resource.files.FileMenu;
import br.com.desafiocadastro.view.ConsoleInput;
import br.com.desafiocadastro.view.MenuInicial;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuInicial menu = new MenuInicial();
        PetController controller = new PetController();
        System.out.println("Bem-vindo ao sistema PetLovers");
        System.out.println("O que desejas fazer? Estamos aqui para te ajudar");

        menu.menu();
    }
}
