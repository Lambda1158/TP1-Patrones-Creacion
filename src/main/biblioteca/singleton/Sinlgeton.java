package biblioteca.singleton;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private List<Libro> libros;
    
    private Database() {
        libros = new ArrayList<>();
    }
    
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public List<Libro> listarLibros() {
        return new ArrayList<>(libros);
    }
    
    public void mostrarLibros() {
        System.out.println("=== LIBROS EN LA BIBLIOTECA ===");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}

class Libro {
    private String titulo;
    private String autor;
    
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}