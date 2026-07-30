package com.mycompany.proyectogrupo4;

public class Biblioteca {

    private static final int CAPACIDAD = 100;
    private static final int CAPACIDAD_PRESTAMOS = 500;

    private Autor[] autores;
    private int cantidadAutores;

    private Categoria[] categorias;
    private int cantidadCategorias;

    private Libro[] libros;
    private int cantidadLibros;

    private Usuario[] usuarios;
    private int cantidadUsuarios;

    private Prestamo[] prestamos;
    private int cantidadPrestamos;

    public Biblioteca() {
        autores = new Autor[CAPACIDAD];
        categorias = new Categoria[CAPACIDAD];
        libros = new Libro[CAPACIDAD];
        usuarios = new Usuario[CAPACIDAD];
        prestamos = new Prestamo[CAPACIDAD_PRESTAMOS];
        cantidadAutores = 0;
        cantidadCategorias = 0;
        cantidadLibros = 0;
        cantidadUsuarios = 0;
        cantidadPrestamos = 0;
    }

    public boolean agregarAutor(Autor autor) {
        if (cantidadAutores >= autores.length) {
            return false;
        }
        if (buscarAutorPorId(autor.getIdAutor()) != null) {
            return false;
        }
        autores[cantidadAutores] = autor;
        cantidadAutores++;
        return true;
    }

    public Autor buscarAutorPorId(int idAutor) {
        for (int i = 0; i < cantidadAutores; i++) {
            if (autores[i].getIdAutor() == idAutor) {
                return autores[i];
            }
        }
        return null;
    }

    public String listarAutores() {
        if (cantidadAutores == 0) {
            return "No hay autores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadAutores; i++) {
            Autor a = autores[i];
            sb.append(a.getIdAutor()).append(" - ").append(a.getNombre())
                    .append(" (").append(a.getNacionalidad()).append(")\n");
        }
        return sb.toString();
    }

    public boolean agregarCategoria(Categoria categoria) {
        if (cantidadCategorias >= categorias.length) {
            return false;
        }
        if (buscarCategoriaPorId(categoria.getIdCategoria()) != null) {
            return false;
        }
        categorias[cantidadCategorias] = categoria;
        cantidadCategorias++;
        return true;
    }

    public Categoria buscarCategoriaPorId(int idCategoria) {
        for (int i = 0; i < cantidadCategorias; i++) {
            if (categorias[i].getIdCategoria() == idCategoria) {
                return categorias[i];
            }
        }
        return null;
    }

    public String listarCategorias() {
        if (cantidadCategorias == 0) {
            return "No hay categorías registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadCategorias; i++) {
            Categoria c = categorias[i];
            sb.append(c.getIdCategoria()).append(" - ").append(c.getNombre()).append("\n");
        }
        return sb.toString();
    }

    public boolean agregarLibro(Libro libro) {
        if (cantidadLibros >= libros.length) {
            return false;
        }
        if (buscarLibroPorId(libro.getIdLibro()) != null) {
            return false;
        }
        libros[cantidadLibros] = libro;
        cantidadLibros++;
        return true;
    }

    public Libro buscarLibroPorId(int idLibro) {
        for (int i = 0; i < cantidadLibros; i++) {
            if (libros[i].getIdLibro() == idLibro) {
                return libros[i];
            }
        }
        return null;
    }

    public String listarLibros() {
        if (cantidadLibros == 0) {
            return "No hay libros registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadLibros; i++) {
            Libro l = libros[i];
            sb.append(l.getIdLibro()).append(" - ").append(l.getTitulo())
                    .append(" | Autor: ").append(l.getAutor().getNombre())
                    .append(" | Categoría: ").append(l.getCategoria().getNombre())
                    .append(" | Disponibles: ").append(l.getCantidad()).append("\n");
        }
        return sb.toString();
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (cantidadUsuarios >= usuarios.length) {
            return false;
        }
        usuarios[cantidadUsuarios] = usuario;
        cantidadUsuarios++;
        return true;
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == idUsuario) {
                return usuarios[i];
            }
        }
        return null;
    }

    public String listarUsuarios() {
        if (cantidadUsuarios == 0) {
            return "No hay usuarios registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadUsuarios; i++) {
            sb.append(usuarios[i].obtenerInfo()).append("\n");
        }
        return sb.toString();
    }

    public Prestamo registrarPrestamo(int idUsuario, int idLibro, int diaActual) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorId(idLibro);

        if (usuario == null || libro == null) {
            return null;
        }
        if (!libro.getDisponible() || libro.getCantidad() <= 0) {
            return null;
        }
        if (cantidadPrestamos >= prestamos.length) {
            return null;
        }

        Prestamo prestamo = new Prestamo(usuario, libro, diaActual);
        libro.prestarLibro();
        usuario.agregarAlHistorial(prestamo);
        prestamos[cantidadPrestamos] = prestamo;
        cantidadPrestamos++;
        return prestamo;
    }

    public boolean registrarDevolucion(int idPrestamo) {
        for (int i = 0; i < cantidadPrestamos; i++) {
            Prestamo p = prestamos[i];
            if (p.getIdPrestamo() == idPrestamo) {
                if ("DEVUELTO".equals(p.getEstado())) {
                    return false;
                }
                p.registrarDevolucion();
                p.getLibro().devolverLibro();
                return true;
            }
        }
        return false;
    }

    public String listarPrestamos() {
        if (cantidadPrestamos == 0) {
            return "No hay préstamos registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidadPrestamos; i++) {
            sb.append(prestamos[i].obtenerInfo()).append("\n");
        }
        return sb.toString();
    }
}
