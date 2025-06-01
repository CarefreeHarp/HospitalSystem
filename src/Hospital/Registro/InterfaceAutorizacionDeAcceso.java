package Hospital.Registro;

public interface InterfaceAutorizacionDeAcceso {
    boolean verificarCredenciales(String usuario, String contrasena);
}
