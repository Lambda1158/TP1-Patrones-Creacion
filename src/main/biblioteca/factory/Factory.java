package biblioteca.factory;

public interface Libro {
    String getTipo();
    String getTitulo();
    String getAutor();
}

class LibroFisico implements Libro {
    private String titulo;
    private String autor;
    
    public LibroFisico(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    @Override
    public String getTipo() { return "Físico"; }
    
    @Override
    public String getTitulo() { return titulo; }
    
    @Override
    public String getAutor() { return autor; }
    
    @Override
    public String toString() {
        return titulo + " (" + getTipo() + ") - " + autor;
    }
}

class LibroDigital implements Libro {
    private String titulo;
    private String autor;
    
    public LibroDigital(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    @Override
    public String getTipo() { return "Digital"; }
    
    @Override
    public String getTitulo() { return titulo; }
    
    @Override
    public String getAutor() { return autor; }
    
    @Override
    public String toString() {
        return titulo + " (" + getTipo() + ") - " + autor;
    }
}

class LogisticaLibro {
    public static Libro crearLibro(String tipo, String titulo, String autor) {
        switch (tipo.toLowerCase()) {
            case "fisico":
                return new LibroFisico(titulo, autor);
            case "digital":
                return new LibroDigital(titulo, autor);
            default:
                throw new IllegalArgumentException("Tipo de libro no válido");
        }
    }
}