package Hospital.Registro;

import java.util.List;

public class BusquedaDePacientes implements InterfaceBusquedaDePacientes {

    private final List<Paciente> pacientes = RegistroPacienteFactory.getPacientes();

    @Override
    public Paciente buscarPorDocumento(String tipoDoc, String numeroDoc) {
        for (Paciente paciente : pacientes) {
            if (paciente.getTipoDocumento().equalsIgnoreCase(tipoDoc)
                    && paciente.getNumeroDocumento().equalsIgnoreCase(numeroDoc)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void buscarPorNombre(String nombre) {
        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(paciente);
                System.out.println("--------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron pacientes con ese nombre.");
        }
    }

    @Override
    public void buscarPorFechaNacimiento(String fechaNacimiento) {
        boolean encontrado = false;
        for (Paciente paciente : pacientes) {
            if (paciente.getFechaNacimiento().equals(fechaNacimiento)) {
                System.out.println(paciente);
                System.out.println("--------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron pacientes con esa fecha de nacimiento.");
        }
    }
}
