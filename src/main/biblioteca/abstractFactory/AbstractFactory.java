package biblioteca.abstractfactory;

public interface InterfazUI {
    void render();
    String getTipo();
}

public interface MetodoEnvio {
    void enviarNotificacion(String mensaje);
    String getTipo();
}

class AdminUI implements InterfazUI {
    @Override
    public void render() {
        System.out.println("Renderizando interfaz de administrador");
    }
    
    @Override
    public String getTipo() {
        return "Admin UI";
    }
}

class UsuarioUI implements InterfazUI {
    @Override
    public void render() {
        System.out.println("Renderizando interfaz de usuario");
    }
    
    @Override
    public String getTipo() {
        return "Usuario UI";
    }
}

class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación normal: " + mensaje);
    }
    
    @Override
    public String getTipo() {
        return "Envío Normal";
    }
}

class EnvioExpress implements MetodoEnvio {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Enviando notificación express: " + mensaje);
    }
    
    @Override
    public String getTipo() {
        return "Envío Express";
    }
}

interface AbstractFactory {
    InterfazUI crearInterfaz();
    MetodoEnvio crearMetodoEnvio();
}

class AdminFactory implements AbstractFactory {
    @Override
    public InterfazUI crearInterfaz() {
        return new AdminUI();
    }
    
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}

class UsuarioFactory implements AbstractFactory {
    @Override
    public InterfazUI crearInterfaz() {
        return new UsuarioUI();
    }
    
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
}

class FabricaProvider {
    public static AbstractFactory getFactory(String tipoUsuario) {
        switch (tipoUsuario.toLowerCase()) {
            case "admin":
                return new AdminFactory();
            case "usuario":
                return new UsuarioFactory();
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }
    }
}