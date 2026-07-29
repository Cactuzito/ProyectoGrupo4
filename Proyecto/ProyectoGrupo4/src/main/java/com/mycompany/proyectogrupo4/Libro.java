/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectogrupo4;

/**
 *
 * @author josue
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private double precio;
    private Autor autor;
    private Categoria categoria;


    // Constructor vacío
    public Libro() {

    }


    // Constructor con parámetros
    public Libro(int idLibro, String titulo, double precio, Autor autor, Categoria categoria) {

        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.categoria = categoria;

    }


    // Getter idLibro
    public int getIdLibro() {
        return idLibro;
    }

    // Setter idLibro
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }


    // Getter titulo
    public String getTitulo() {
        return titulo;
    }

    // Setter titulo
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    // Getter precio
    public double getPrecio() {
        return precio;
    }

    // Setter precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }


    // Getter autor
    public Autor getAutor() {
        return autor;
    }

    // Setter autor
    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    // Getter categoria
    public Categoria getCategoria() {
        return categoria;
    }

    // Setter categoria
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    // Método mostrar datos
    public void mostrarDatos() {

        System.out.println("ID Libro: " + idLibro);
        System.out.println("Título: " + titulo);
        System.out.println("Precio: " + precio);

        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Categoría: " + categoria.getNombre());

    }

}