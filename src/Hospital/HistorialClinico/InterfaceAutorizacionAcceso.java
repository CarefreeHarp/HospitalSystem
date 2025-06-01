package Hospital.HistorialClinico;

public interface InterfaceAutorizacionAcceso {
    boolean autenticarUsuario(String usuario, String clave);
    void ingresarSistema();
    void redireccionamientoAlMenu();
    void integracionModuloMonitoreo(String usuario);
}
