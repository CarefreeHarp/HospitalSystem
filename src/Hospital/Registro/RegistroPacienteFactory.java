package Hospital.Registro;

import java.util.ArrayList;
import java.util.List;

public class RegistroPacienteFactory implements InterfaceRegistroPaciente {

    // Simulación de base de datos en memoria
    private static final List<Paciente> pacientes = new ArrayList<>();

    @Override
    public boolean validarDuplicados(String tipoDoc, String numeroDoc) {
        return pacientes.stream()
                .anyMatch(p -> p.getTipoDocumento().equalsIgnoreCase(tipoDoc)
                        && p.getNumeroDocumento().equals(numeroDoc));
    }

    @Override
    public void consultarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
        } else {
            System.out.println("Pacientes registrados:");
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
                System.out.println("--------------------------");
            }
        }
    }

    @Override
    public boolean guardarPaciente(Paciente paciente) {
        if (validarDuplicados(paciente.getTipoDocumento(), paciente.getNumeroDocumento())) {
            System.out.println("El paciente ya está registrado.");
            return false;
        }
        pacientes.add(paciente);
        System.out.println("Paciente registrado exitosamente.");
        return true;
    }

    // Método opcional para acceso externo si lo necesitás
    public static List<Paciente> getPacientes() {
        return pacientes;
    }
}