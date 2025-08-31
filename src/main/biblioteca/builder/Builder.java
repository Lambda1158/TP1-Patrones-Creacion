package biblioteca.builder;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;
    
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.email = builder.email;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
        this.fechaNacimiento = builder.fechaNacimiento;
    }
    
    public static class Builder {
        private String nombre;
        private String email;
        private String direccion;
        private String telefono;
        private Date fechaNacimiento;
        
        public Builder(String nombre, String email) {
            this.nombre = nombre;
            this.email = email;
        }
        
        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }
        
        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }
        
        public Builder fechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }
        
        public Usuario build() {
            return new Usuario(this);
        }
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}