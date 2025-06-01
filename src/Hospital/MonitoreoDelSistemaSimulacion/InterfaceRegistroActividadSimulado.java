package Hospital.MonitoreoDelSistemaSimulacion;

public interface InterfaceRegistroActividadSimulado {
    void registrarAcceso(String usuario);
    void registrarConsulta(String usuario, String recurso);
    void registrarModificacion(String usuario, String recurso, String descripcionCambio);
    String generarIDModificacion();
}
