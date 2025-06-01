package Hospital.AdministracionDeRecursosMedicos;

import java.util.List;

public interface InterfaceGestionRecursos {
    void registrarNuevoRecurso(String tipo, String id);
    void eliminarRecurso(String id);
    void actualizarEstadoRecurso(String id, String nuevoEstado);
    void listarRecursos();
    List<String> filtrarPorEstado(String estado);
    List<String> verHistorialDeUso(String id);
}
