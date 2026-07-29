/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectogrupo4;

/**
 *
 * @author josue
 */
public class Autor {

    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private int edad;

public Autor() {

}

public Autor(int idAutor, String nombre, String nacionalidad, int edad){

    this.idAutor = idAutor;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.edad = edad;
    

}

    // Getter idAutor
    public int getIdAutor() {
     return idAutor;
    }

    // Setter idAutor   
    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    // Getter nombre
    public String getNombre() {
        return nombre;
    }

    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // Getter nacionalidad
    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setter nacionalidad
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }


    // Getter edad
    public int getEdad() {
        return edad;
    }

    // Setter edad
    public void setEdad(int edad) {
        this.edad = edad;
    }


    // Mostrar los Datos
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Edad: " + edad);
    }
}
