// Archivo: Main.java

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Iniciando Sistema de Biblioteca Digital ---");
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("\n--- Registro de Usuarios ---");
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        System.out.println("\n--- Añadiendo Libros al Catálogo ---");
        biblioteca.añadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.añadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));
        biblioteca.añadirLibro(new Libro("ISBN-003", "The Pragmatic Programmer", "Andrew Hunt", "Software"));

        System.out.println("\n--- Proceso de Préstamos ---");
        biblioteca.prestarLibro("U1", "ISBN-001"); // Ana presta Clean Code
        biblioteca.prestarLibro("U2", "ISBN-002"); // Luis presta Effective Java
        biblioteca.prestarLibro("U1", "ISBN-002"); // Ana intenta prestar un libro ya prestado (fallará)

        System.out.println("\n--- Listar Libros Prestados por Usuario U1 (Ana) ---");
        List<Libro> prestadosAna = biblioteca.listarPrestados("U1");
        System.out.println("Libros prestados a Ana: " + prestadosAna);

        System.out.println("\n--- Proceso de Devolución ---");
        biblioteca.devolverLibro("U1", "ISBN-001"); // Ana devuelve Clean Code

        System.out.println("\n--- Nuevos Préstamos ---");
        biblioteca.prestarLibro("U2", "ISBN-001"); // Luis ahora puede prestar Clean Code

        System.out.println("\n--- Búsquedas en el Catálogo ---");
        System.out.println("Buscando por autor 'Bloch': " + biblioteca.buscarPorAutor("Bloch"));
        System.out.println("Buscando por categoría 'Software': " + biblioteca.buscarPorCategoria("Software"));
        
        System.out.println("\n--- Fin de la Simulación ---");
    }
}
