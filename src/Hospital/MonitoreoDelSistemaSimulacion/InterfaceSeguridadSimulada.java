package Hospital.MonitoreoDelSistemaSimulacion;

public interface InterfaceSeguridadSimulada {
    boolean autenticarUsuario(String usuario, String clave);
    boolean validarPermisos(String usuario, String recurso);
    void registrarIntentoFallido(String usuario);
    void bloquearUsuario(String usuario);
}
