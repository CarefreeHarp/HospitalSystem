package Hospital.Registro;

public interface InterfaceBusquedaDePacientes {

    Paciente buscarPorDocumento(String tipoDoc, String numeroDoc);

    void buscarPorNombre(String nombre);

    void buscarPorFechaNacimiento(String fechaNacimiento);
}
