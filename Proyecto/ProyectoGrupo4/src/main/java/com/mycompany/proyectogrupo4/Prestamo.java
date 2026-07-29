package com.mycompany.proyectogrupo4;

/**
 *
 * @author Gerald
 */
public class Prestamo {
     // Contador para generar IDs automáticos
    private static int contadorId = 1;
    // Cantidad fija de días que dura un préstamo
    private static final int DIAS_PRESTAMO = 7;

    private int idPrestamo;
    private int diaPrestamo;
    private int diaDevolucion;
    private String estado;
    private boolean devuelto;
    private Usuario usuario;
    private Libro libro;

    // Constructor
    public Prestamo(Usuario usuario, Libro libro, int diaActual) {
        idPrestamo = contadorId;
        contadorId = contadorId + 1;
        this.usuario = usuario;
        this.libro = libro;
        diaPrestamo = diaActual;
        diaDevolucion = diaActual + DIAS_PRESTAMO;
        estado = "ACTIVO";
        devuelto = false;
    }

    // Registrar devolución del libro
    public void registrarDevolucion() {
        if (devuelto == false) {
            estado = "DEVUELTO";
            devuelto = true;
        }
    }

    // Getter idPrestamo
    public int getIdPrestamo() {
        return idPrestamo;
    }

    // Getter diaPrestamo
    public int getDiaPrestamo() {
        return diaPrestamo;
    }

    // Getter diaDevolucion
    public int getDiaDevolucion() {
        return diaDevolucion;
    }

    // Getter estado
    public String getEstado() {
        return estado;
    }

    // Getter usuario
    public Usuario getUsuario() {
        return usuario;
    }

    // Getter libro
    public Libro getLibro() {
        return libro;
    }

    // Mostrar información del préstamo
    public String obtenerInfo() {
        String info = "Prestamo #" + idPrestamo
                + " | Usuario: " + usuario.getNombre()
                + " | Libro: " + libro.getTitulo()
                + " | Dia de prestamo: " + diaPrestamo
                + " | Dia limite: " + diaDevolucion
                + " | Estado: " + estado;
        return info;
    }
}

