// Archivo: Usuario.java

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un usuario de la biblioteca.
 */
public class Usuario {

    private final String id;
    private final String nombre;
    private final List<String> isbnsPrestados;

    /**
     * Constructor para la clase Usuario.
     */
    public Usuario(String id, String nombre) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo o vacío.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }

        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    // Métodos Getter
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getIsbnsPrestados() {
        // Devuelve una copia para proteger la lista original
        return new ArrayList<>(isbnsPrestados);
    }

    /**
     * Añade un ISBN a la lista de libros prestados del usuario.
     * Este método es llamado por la clase Biblioteca.
     */
    void prestarLibro(String isbn) {
        if (isbn != null && !isbn.trim().isEmpty()) {
            this.isbnsPrestados.add(isbn);
        }
    }

    /**
     * Quita un ISBN de la lista de libros prestados del usuario.
     * Este método es llamado por la clase Biblioteca.
     */
    void devolverLibro(String isbn) {
        this.isbnsPrestados.remove(isbn);
    }

    @Override
    public String toString() {
        return "Usuario{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", librosPrestados=" + isbnsPrestados.size() +
               '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
