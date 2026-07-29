package com.mycompany.proyectogrupo4;

/**
 *
 * @author Gerald
 */
public class Usuario {
  // Contador para generar IDs automáticos
    private static int contadorId = 1;

    private int idUsuario;
    private String nombre;
    private String email;
    private String tipoUsuario;
    private Prestamo[] historial;
    private int cantidadPrestamos;

    // Constructor
    public Usuario(String nombre, String email, String tipoUsuario) {
        idUsuario = contadorId;
        contadorId = contadorId + 1;
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        historial = new Prestamo[50];
        cantidadPrestamos = 0;
    }

    // Agregar un préstamo al historial
    public void agregarAlHistorial(Prestamo prestamo) {
        if (cantidadPrestamos < historial.length) {
            historial[cantidadPrestamos] = prestamo;
            cantidadPrestamos = cantidadPrestamos + 1;
        }
    }

    // Consultar historial de préstamos
    public Prestamo[] consultarHistorial() {
        return historial;
    }

    // Getter cantidadPrestamos
    public int getCantidadPrestamos() {
        return cantidadPrestamos;
    }

    // Getter idUsuario
    public int getIdUsuario() {
        return idUsuario;
    }

    // Getter nombre
    public String getNombre() {
        return nombre;
    }
    // Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter email
    public String getEmail() {
        return email;
    }
    // Setter email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter tipoUsuario
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    // Setter tipoUsuario
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Mostrar información del usuario
    public String obtenerInfo() {
        String info = "ID: " + idUsuario
                + " | Nombre: " + nombre
                + " | Email: " + email
                + " | Tipo: " + tipoUsuario;
        return info;
    }
}  


                