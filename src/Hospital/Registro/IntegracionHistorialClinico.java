package Hospital.Registro;

import java.util.HashMap;
import java.util.Map;

public class IntegracionHistorialClinico implements InterfaceIntegracionHistorialClinico {

    private final Map<String, Paciente> historialSimulado = new HashMap<>();

    private String generarClave(String tipoDoc, String numeroDoc) {
        return tipoDoc + "-" + numeroDoc;
    }

    @Override
    public void sincronizarPacienteConHistorial(Paciente paciente) {
        String clave = generarClave(paciente.getTipoDocumento(), paciente.getNumeroDocumento());
        historialSimulado.put(clave, paciente);
        System.out.println("Paciente sincronizado con el sistema HealthCore v3.5 (de mentiras).");
    }

    @Override
    public boolean estaPacienteEnHistorial(String tipoDoc, String numeroDoc) {
        String clave = generarClave(tipoDoc, numeroDoc);
        return historialSimulado.containsKey(clave);
    }

    @Override
    public void mostrarHistorialPaciente(String tipoDoc, String numeroDoc) {
        String clave = generarClave(tipoDoc, numeroDoc);
        if (historialSimulado.containsKey(clave)) {
            Paciente paciente = historialSimulado.get(clave);
            System.out.println("\nHistorial Clínico del Paciente:");
            System.out.println(paciente);
        } else {
            System.out.println("El paciente no está registrado en el historial clínico.");
        }
    }
}
