package biblioteca;

import biblioteca.singleton.Database;
import biblioteca.factory.*;
import biblioteca.abstractfactory.*;
import biblioteca.builder.Usuario;
import biblioteca.prototype.Prestamo;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PATRONES CREACIONALES - BIBLIOTECA ONLINE ===\n");
        
        // 1. Singleton
        System.out.println("1. SINGLETON");
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println("Misma instancia? " + (db1 == db2));
        
        // 2. Factory Method
        System.out.println("\n2. FACTORY METHOD");
        Libro libro1 = LogisticaLibro.crearLibro("fisico", "Cien años de soledad", "García Márquez");
        Libro libro2 = LogisticaLibro.crearLibro("digital", "1984", "George Orwell");
        System.out.println(libro1);
        System.out.println(libro2);
        
        // 3. Abstract Factory
        System.out.println("\n3. ABSTRACT FACTORY");
        Abstractfactory adminFactory = FabricaProvider.getFactory("admin");
        Abstractfactory userFactory = FabricaProvider.getFactory("usuario");
        
        InterfazUI adminUI = adminFactory.crearInterfaz();
        MetodoEnvio adminEnvio = adminFactory.crearMetodoEnvio();
        System.out.println("Admin: " + adminUI.getTipo() + " - " + adminEnvio.getTipo());
        
        InterfazUI userUI = userFactory.crearInterfaz();
        MetodoEnvio userEnvio = userFactory.crearMetodoEnvio();
        System.out.println("Usuario: " + userUI.getTipo() + " - " + userEnvio.getTipo());
        
        // 4. Builder
        System.out.println("\n4. BUILDER");
        Usuario usuario1 = new Usuario.Builder("Juan Pérez", "juan@email.com")
                .direccion("Calle 123")
                .telefono("123456789")
                .build();
        
        Usuario usuario2 = new Usuario.Builder("María García", "maria@email.com")
                .fechaNacimiento(new Date())
                .build();
        
        System.out.println(usuario1);
        System.out.println(usuario2);
        
        // 5. Prototype
        System.out.println("\n5. PROTOTYPE");
        Prestamo prestamoOriginal = new Prestamo(
                new biblioteca.prototype.Libro("El Quijote", "Cervantes"),
                new biblioteca.prototype.Usuario("Carlos López"),
                new Date(),
                new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000) // +7 días
        );
        
        Prestamo prestamoClon1 = prestamoOriginal.clone();
        Prestamo prestamoClon2 = prestamoOriginal.clone();
        
        System.out.println("Original: " + prestamoOriginal);
        System.out.println("Clon 1: " + prestamoClon1);
        System.out.println("Clon 2: " + prestamoClon2);
        System.out.println("Mismo objeto? " + (prestamoOriginal == prestamoClon1));
    }
}