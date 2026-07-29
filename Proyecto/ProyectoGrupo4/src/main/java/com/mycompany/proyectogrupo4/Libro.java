/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectogrupo4;

/**
 *
 * @author josue
 */
import javax.swing.JOptionPane;

public class Libro {

    private int idLibro;
    private String titulo;
    private double precio;
    private Autor autor;
    private Categoria categoria;
    private int cantidad;
    private boolean disponible;


    // Constructor vacío
    public Libro() {

    }


    // Constructor con parámetros
    public Libro(int idLibro, String titulo, double precio, int cantidad, Autor autor, Categoria categoria) {

        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.autor = autor;
        this.categoria = categoria;

        if (cantidad > 0) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }

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


    // Getter cantidad
    public int getCantidad() {
        return cantidad;
    }

    // Setter cantidad
    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;

        if (cantidad > 0) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }

    }


    // Getter disponible
    public boolean getDisponible() {
        return disponible;
    }

    // Setter disponible
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    // Método para prestar libro
    public void prestarLibro() {

        if (cantidad > 0) {

            cantidad--;

            if (cantidad == 0) {
                disponible = false;
            }

        }

    }


    // Método para devolver libro
    public void devolverLibro() {

        cantidad++;
        disponible = true;

    }


    // Método mostrar datos
    public void mostrarDatos() {

        JOptionPane.showMessageDialog(null,
                "ID Libro: " + idLibro
                + "\nTítulo: " + titulo
                + "\nPrecio: " + precio
                + "\nCantidad disponible: " + cantidad
                + "\nDisponible: " + disponible
                + "\nAutor: " + autor.getNombre()
                + "\nCategoría: " + categoria.getNombre()
        );

    }

}