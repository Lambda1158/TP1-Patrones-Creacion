package biblioteca.factory;

public class LogisticaLibro {
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