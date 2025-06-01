package Hospital.AdministracionDeRecursosMedicos;

public interface InterfaceInterfazUsuario {
    void mostrarDetallesRecurso(String id);
    String[] formularioActualizaciones();
    void actualizarEstadoRecurso(String id, String nuevoEstado);
    boolean confirmarAccion(String mensaje);
}
