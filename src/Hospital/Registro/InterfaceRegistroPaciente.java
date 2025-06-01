package Hospital.Registro;

public interface InterfaceRegistroPaciente {

    boolean validarDuplicados(String tipoDoc, String numeroDoc);

    void consultarPacientes(); // Muestra todos los pacientes registrados

    boolean guardarPaciente(Paciente paciente); // Agrega un nuevo paciente si no existe
}
