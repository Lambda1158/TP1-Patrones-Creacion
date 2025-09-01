package biblioteca.abstractfactory;

public class FabricaProvider {
    public static Abstractfactory getFactory(String tipoUsuario) {
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