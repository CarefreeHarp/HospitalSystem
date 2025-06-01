package Hospital.Registro;

public interface InterfaceIntegracionHistorialClinico {

    void sincronizarPacienteConHistorial(Paciente paciente);

    boolean estaPacienteEnHistorial(String tipoDoc, String numeroDoc);

    void mostrarHistorialPaciente(String tipoDoc, String numeroDoc);
}
