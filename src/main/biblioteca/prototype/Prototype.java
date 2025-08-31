package biblioteca.prototype;

import java.util.Date;

public class Prestamo implements Cloneable {
    private Libro libro;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaFin;
    
    public Prestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaFin) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    @Override
    public Prestamo clone() {
        try {
            // Shallow copy (las fechas se comparten, pero son inmutables)
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    
    // Getters y setters
    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }
    
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    
    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
    
    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro.getTitulo() +
                ", usuario=" + usuario.getNombre() +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}

// Clases auxiliares para el prototype
class Libro {
    private String titulo;
    private String autor;
    
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
}

class Usuario {
    private String nombre;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() { return nombre; }
}