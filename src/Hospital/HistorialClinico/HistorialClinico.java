package Hospital.HistorialClinico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistorialClinico implements InterfaceManejoHistorial {

    private Map<String, List<String>> baseDatosHistorial;

    public HistorialClinico() {
        baseDatosHistorial = new HashMap<>();
        conexionDB();
    }

    @Override
    public void conexionDB() {
        System.out.println("Simulación de conexión exitosa a la base de datos de historiales.");
    }

    @Override
    public boolean verificacionDB(String idPaciente) {
        return baseDatosHistorial.containsKey(idPaciente);
    }

    @Override
    public void consultarHistorial(String idPaciente) {
        if (verificacionDB(idPaciente)) {
            mostrarHistorial(idPaciente);
        } else {
            System.out.println("No se encontró historial para el paciente con ID: " + idPaciente);
        }
    }

    @Override
    public void actualizarHistorial(String idPaciente, String nuevoRegistro) {
        if (!verificacionDB(idPaciente)) {
            baseDatosHistorial.put(idPaciente, new ArrayList<>());
        }
        baseDatosHistorial.get(idPaciente).add(nuevoRegistro);
        System.out.println("Nuevo evento clínico añadido para el paciente " + idPaciente);
    }

    @Override
    public void mostrarHistorial(String idPaciente) {
        List<String> historial = baseDatosHistorial.get(idPaciente);
        if (historial != null && !historial.isEmpty()) {
            System.out.println("Historial clínico del paciente " + idPaciente + ":");
            for (String entrada : historial) {
                System.out.println("- " + entrada);
            }
        } else {
            System.out.println("Historial vacío para el paciente " + idPaciente);
        }
    }
}
