// Archivo: Libro.java

import java.util.Objects;

/**
 * Representa un libro en la biblioteca.
 * Esta clase es inmutable. Una vez que se crea un objeto Libro,
 * sus atributos no pueden ser cambiados.
 */
public final class Libro {

    private final String isbn;
    private final String titulo;
    private final String autor;
    private final String categoria;

    /**
     * Constructor para la clase Libro.
     * Valida que ninguno de los parámetros sea nulo o esté vacío.
     */
    public Libro(String isbn, String titulo, String autor, String categoria) {
        // Validación de los argumentos
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede ser nulo o vacío.");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede ser nulo o vacío.");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede ser nula o vacía.");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
    }

    // Métodos Getter
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +
               "isbn='" + isbn + '\'' +
               ", titulo='" + titulo + '\'' +
               ", autor='" + autor + '\'' +
               ", categoria='" + categoria + '\'' +
               '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return isbn.equals(libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
