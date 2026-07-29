/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectogrupo4;
import javax.swing.JOptionPane;
/**
 *
 * @author josue
 */
public class ProyectoGrupo4 {

   public static void main(String[] args) {
// Crear Autor
        Autor autor1 = new Autor(
                1,
                "Gabriel Garcia Marquez",
                "Colombiana",
                87
        );


        // Crear Categoria
        Categoria categoria1 = new Categoria(
                1,
                "Novela",
                "Libros de ficción"
        );


        // Crear Libro
        Libro libro1 = new Libro(
                1,
                "Cien años de soledad",
                15000,
                autor1,
                categoria1
        );


        // Mostrar datos del libro
        JOptionPane.showMessageDialog(null,
                "ID Libro: " + libro1.getIdLibro()
                + "\nTitulo: " + libro1.getTitulo()
                + "\nPrecio: " + libro1.getPrecio()
                + "\nAutor: " + libro1.getAutor().getNombre()
                + "\nCategoria: " + libro1.getCategoria().getNombre()
        );

    }
}