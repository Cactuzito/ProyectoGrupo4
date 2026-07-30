package com.mycompany.proyectogrupo4;

import javax.swing.JOptionPane;

public class Menu {

    private Biblioteca biblioteca;

    public Menu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void iniciar() {
        int opcion = -1;
        while (opcion != 0) {
            String menuPrincipal = "===== SISTEMA DE BIBLIOTECA =====\n"
                    + "1. Gestionar Autores\n"
                    + "2. Gestionar Categorías\n"
                    + "3. Gestionar Libros\n"
                    + "4. Gestionar Usuarios\n"
                    + "5. Gestionar Préstamos\n"
                    + "0. Salir";
            opcion = leerOpcion(menuPrincipal);

            switch (opcion) {
                case 1:
                    menuAutores();
                    break;
                case 2:
                    menuCategorias();
                    break;
                case 3:
                    menuLibros();
                    break;
                case 4:
                    menuUsuarios();
                    break;
                case 5:
                    menuPrestamos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    private void menuAutores() {
        String submenu = "----- AUTORES -----\n"
                + "1. Agregar autor\n"
                + "2. Listar autores\n"
                + "0. Volver";
        int opcion = leerOpcion(submenu);

        if (opcion == 1) {
            int id = leerEntero("ID del autor:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String nacionalidad = JOptionPane.showInputDialog("Nacionalidad:");
            int edad = leerEntero("Edad:");

            Autor autor = new Autor(id, nombre, nacionalidad, edad);
            boolean exito = biblioteca.agregarAutor(autor);
            mostrarResultado(exito, "Autor agregado correctamente.",
                    "No se pudo agregar (ID repetido o capacidad llena).");
        } else if (opcion == 2) {
            JOptionPane.showMessageDialog(null, biblioteca.listarAutores());
        }
    }

    private void menuCategorias() {
        String submenu = "----- CATEGORÍAS -----\n"
                + "1. Agregar categoría\n"
                + "2. Listar categorías\n"
                + "0. Volver";
        int opcion = leerOpcion(submenu);

        if (opcion == 1) {
            int id = leerEntero("ID de la categoría:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String descripcion = JOptionPane.showInputDialog("Descripción:");

            Categoria categoria = new Categoria(id, nombre, descripcion);
            boolean exito = biblioteca.agregarCategoria(categoria);
            mostrarResultado(exito, "Categoría agregada correctamente.",
                    "No se pudo agregar (ID repetido o capacidad llena).");
        } else if (opcion == 2) {
            JOptionPane.showMessageDialog(null, biblioteca.listarCategorias());
        }
    }

    private void menuLibros() {
        String submenu = "----- LIBROS -----\n"
                + "1. Agregar libro\n"
                + "2. Listar libros\n"
                + "0. Volver";
        int opcion = leerOpcion(submenu);

        if (opcion == 1) {
            int idAutor = leerEntero("ID del autor (debe existir):");
            Autor autor = biblioteca.buscarAutorPorId(idAutor);
            if (autor == null) {
                JOptionPane.showMessageDialog(null, "Ese autor no existe. Regístralo primero.");
                return;
            }

            int idCategoria = leerEntero("ID de la categoría (debe existir):");
            Categoria categoria = biblioteca.buscarCategoriaPorId(idCategoria);
            if (categoria == null) {
                JOptionPane.showMessageDialog(null, "Esa categoría no existe. Regístrala primero.");
                return;
            }

            int idLibro = leerEntero("ID del libro:");
            String titulo = JOptionPane.showInputDialog("Título:");
            double precio = leerDecimal("Precio:");
            int cantidad = leerEntero("Cantidad de ejemplares:");

            Libro libro = new Libro(idLibro, titulo, precio, cantidad, autor, categoria);
            boolean exito = biblioteca.agregarLibro(libro);
            mostrarResultado(exito, "Libro agregado correctamente.",
                    "No se pudo agregar (ID repetido o capacidad llena).");
        } else if (opcion == 2) {
            JOptionPane.showMessageDialog(null, biblioteca.listarLibros());
        }
    }

    private void menuUsuarios() {
        String submenu = "----- USUARIOS -----\n"
                + "1. Agregar usuario\n"
                + "2. Listar usuarios\n"
                + "0. Volver";
        int opcion = leerOpcion(submenu);

        if (opcion == 1) {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String email = JOptionPane.showInputDialog("Email:");
            String tipoUsuario = JOptionPane.showInputDialog("Tipo de usuario (ESTUDIANTE/DOCENTE/EXTERNO):");

            Usuario usuario = new Usuario(nombre, email, tipoUsuario);
            biblioteca.agregarUsuario(usuario);
            JOptionPane.showMessageDialog(null, "Usuario agregado. ID asignado: " + usuario.getIdUsuario());
        } else if (opcion == 2) {
            JOptionPane.showMessageDialog(null, biblioteca.listarUsuarios());
        }
    }

    private void menuPrestamos() {
        String submenu = "----- PRÉSTAMOS -----\n"
                + "1. Registrar préstamo\n"
                + "2. Registrar devolución\n"
                + "3. Listar préstamos\n"
                + "0. Volver";
        int opcion = leerOpcion(submenu);

        if (opcion == 1) {
            int idUsuario = leerEntero("ID de usuario:");
            int idLibro = leerEntero("ID de libro:");
            int diaActual = leerEntero("Día actual (número de día del sistema):");

            Prestamo prestamo = biblioteca.registrarPrestamo(idUsuario, idLibro, diaActual);
            if (prestamo != null) {
                JOptionPane.showMessageDialog(null, "Préstamo registrado:\n" + prestamo.obtenerInfo());
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se pudo registrar el préstamo (usuario/libro inexistente o sin stock).");
            }
        } else if (opcion == 2) {
            int idPrestamo = leerEntero("ID del préstamo a devolver:");
            boolean exito = biblioteca.registrarDevolucion(idPrestamo);
            mostrarResultado(exito, "Devolución registrada correctamente.",
                    "No se pudo registrar la devolución (préstamo inexistente o ya devuelto).");
        } else if (opcion == 3) {
            JOptionPane.showMessageDialog(null, biblioteca.listarPrestamos());
        }
    }

    private int leerOpcion(String mensaje) {
        String texto = JOptionPane.showInputDialog(mensaje);
        if (texto == null) {
            return 0;
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
            return -1;
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null) {
                return -1;
            }
            try {
                return Integer.parseInt(texto.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido, ingresa un número entero.");
            }
        }
    }

    private double leerDecimal(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(mensaje);
            if (texto == null) {
                return -1;
            }
            try {
                return Double.parseDouble(texto.trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido, ingresa un número decimal.");
            }
        }
    }

    private void mostrarResultado(boolean exito, String mensajeOk, String mensajeError) {
        if (exito) {
            JOptionPane.showMessageDialog(null, mensajeOk);
        } else {
            JOptionPane.showMessageDialog(null, mensajeError);
        }
    }
}
