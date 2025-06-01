package Hospital.AdministracionDeRecursosMedicos;

public interface InterfaceSincronizacionTiempoReal {
    void subirCambios(String id, String estado);
    boolean verificarActualizaciones(String id, String estadoLocal);
    void notificarCambio(String id, String mensaje);
}
