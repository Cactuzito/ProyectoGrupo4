package com.mycompany.proyectogrupo4;

public class Principal {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Menu menu = new Menu(biblioteca);
        menu.iniciar();
    }
}
