package Hospital.HistorialClinico;

public interface InterfaceManejoHistorial {
    void conexionDB();
    boolean verificacionDB(String idPaciente);
    void consultarHistorial(String idPaciente);
    void actualizarHistorial(String idPaciente, String nuevoRegistro);
    void mostrarHistorial(String idPaciente);
}
