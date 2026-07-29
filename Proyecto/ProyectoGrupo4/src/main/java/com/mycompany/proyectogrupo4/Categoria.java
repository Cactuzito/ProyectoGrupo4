/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectogrupo4;

/**
 *
 * @author josue
 */
public class Categoria {

    private int idCategoria;
    private String nombre;
    private String descripcion;


    // Constructor vacío
    public Categoria() {

    }


    // Constructor con parámetros
    public Categoria(int idCategoria, String nombre, String descripcion) {

        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }


    // Getter idCategoria
    public int getIdCategoria() {
        return idCategoria;
    }

    // Setter idCategoria
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Getter descripcion
    public String getDescripcion() {
        return descripcion;
    }

    // Setter descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    // Método mostrar datos
    public void mostrarDatos() {

        System.out.println("ID Categoría: " + idCategoria);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);

    }
}