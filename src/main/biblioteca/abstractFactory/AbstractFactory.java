package biblioteca.abstractfactory;
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

public interface Abstractfactory {
    InterfazUI crearInterfaz();
    MetodoEnvio crearMetodoEnvio();
}

class AdminFactory implements Abstractfactory {
    @Override
    public InterfazUI crearInterfaz() {
        return new AdminUI();
    }
    
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}

class UsuarioFactory implements Abstractfactory {
    @Override
    public InterfazUI crearInterfaz() {
        return new UsuarioUI();
    }
    
    @Override
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
}

