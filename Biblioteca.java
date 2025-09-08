// Archivo: Biblioteca.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Clase que gestiona la colección de libros, usuarios y préstamos.
 */
public class Biblioteca {

    private final Map<String, Libro> catalogoPorIsbn;
    private final Map<String, Usuario> usuariosPorId;
    private final Set<String> isbnsPrestados;

    /**
     * Constructor que inicializa las colecciones.
     */
    public Biblioteca() {
        this.catalogoPorIsbn = new HashMap<>();
        this.usuariosPorId = new HashMap<>();
        this.isbnsPrestados = new HashSet<>();
    }

    // --- Funcionalidades de Libros ---
    public void añadirLibro(Libro libro) {
        if (catalogoPorIsbn.containsKey(libro.getIsbn())) {
            System.out.println("Error: El libro con ISBN " + libro.getIsbn() + " ya existe.");
        } else {
            catalogoPorIsbn.put(libro.getIsbn(), libro);
            System.out.println("Libro añadido: " + libro.getTitulo());
        }
    }

    public void quitarLibro(String isbn) {
        if (!catalogoPorIsbn.containsKey(isbn)) {
            System.out.println("Error: El libro con ISBN " + isbn + " no se encuentra en el catálogo.");
        } else if (isbnsPrestados.contains(isbn)) {
            System.out.println("Error: El libro con ISBN " + isbn + " está actualmente prestado y no se puede quitar.");
        } else {
            Libro libroQuitado = catalogoPorIsbn.remove(isbn);
            System.out.println("Libro quitado: " + libroQuitado.getTitulo());
        }
    }

    // --- Funcionalidades de Usuarios ---
    public void registrarUsuario(Usuario usuario) {
        if (usuariosPorId.containsKey(usuario.getId())) {
            System.out.println("Error: El usuario con ID " + usuario.getId() + " ya está registrado.");
        } else {
            usuariosPorId.put(usuario.getId(), usuario);
            System.out.println("Usuario registrado: " + usuario.getNombre());
        }
    }

    public void darBajaUsuario(String id) {
        Usuario usuario = usuariosPorId.get(id);
        if (usuario == null) {
            System.out.println("Error: El usuario con ID " + id + " no existe.");
        } else if (!usuario.getIsbnsPrestados().isEmpty()) {
            System.out.println("Error: El usuario " + usuario.getNombre() + " tiene libros prestados y no puede ser dado de baja.");
        } else {
            usuariosPorId.remove(id);
            System.out.println("Usuario dado de baja: " + usuario.getNombre());
        }
    }

    // --- Funcionalidades de Préstamos ---
    public void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);

        if (usuario == null) {
            System.out.println("Error al prestar: Usuario con ID " + idUsuario + " no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Error al prestar: Libro con ISBN " + isbn + " no encontrado.");
            return;
        }
        if (isbnsPrestados.contains(isbn)) {
            System.out.println("Error al prestar: El libro '" + libro.getTitulo() + "' ya está prestado.");
            return;
        }

        usuario.prestarLibro(isbn);
        isbnsPrestados.add(isbn);
        System.out.println("Éxito: El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre() + ".");
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = catalogoPorIsbn.get(isbn);
        
        if (usuario == null) {
            System.out.println("Error al devolver: Usuario con ID " + idUsuario + " no encontrado.");
            return;
        }
        if (!isbnsPrestados.contains(isbn) || !usuario.getIsbnsPrestados().contains(isbn)) {
             System.out.println("Error al devolver: El libro no está prestado a este usuario.");
            return;
        }
        
        usuario.devolverLibro(isbn);
        isbnsPrestados.remove(isbn);
        System.out.println("Éxito: El libro '" + libro.getTitulo() + "' ha sido devuelto por " + usuario.getNombre() + ".");
    }

    // --- Funcionalidades de Búsqueda y Listado ---
    public List<Libro> buscarPorTitulo(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorAutor(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getAutor().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> buscarPorCategoria(String texto) {
        return catalogoPorIsbn.values().stream()
                .filter(libro -> libro.getCategoria().toLowerCase().contains(texto.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Libro> listarPrestados(String idUsuario) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        if (usuario == null) {
            System.out.println("No se pueden listar préstamos: Usuario con ID " + idUsuario + " no encontrado.");
            return Collections.emptyList(); // Devuelve una lista vacía inmutable
        }

        List<Libro> libros = new ArrayList<>();
        for (String isbn : usuario.getIsbnsPrestados()) {
            Libro libro = catalogoPorIsbn.get(isbn);
            if (libro != null) {
                libros.add(libro);
            }
        }
        return libros;
    }
}
