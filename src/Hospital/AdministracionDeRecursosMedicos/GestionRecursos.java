package Hospital.AdministracionDeRecursosMedicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionRecursos implements InterfaceGestionRecursos {

    private Map<String, String> recursos; // id -> estado
    private Map<String, String> tipos;    // id -> tipo
    private Map<String, List<String>> historial; // id -> lista de eventos

    public GestionRecursos() {
        recursos = new HashMap<>();
        tipos = new HashMap<>();
        historial = new HashMap<>();
    }

    @Override
    public void registrarNuevoRecurso(String tipo, String id) {
        recursos.put(id, "Disponible");
        tipos.put(id, tipo);
        historial.put(id, new ArrayList<>());
        historial.get(id).add("Registrado como " + tipo + " en estado Disponible");
        System.out.println("Recurso registrado: " + id + " (" + tipo + ")");
    }

    @Override
    public void eliminarRecurso(String id) {
        if (recursos.containsKey(id)) {
            recursos.remove(id);
            tipos.remove(id);
            historial.remove(id);
            System.out.println("Recurso eliminado: " + id);
        } else {
            System.out.println("Recurso no encontrado: " + id);
        }
    }

    @Override
    public void actualizarEstadoRecurso(String id, String nuevoEstado) {
        if (recursos.containsKey(id)) {
            recursos.put(id, nuevoEstado);
            historial.get(id).add("Estado actualizado a: " + nuevoEstado);
            System.out.println("Estado actualizado de " + id + " a " + nuevoEstado);
        } else {
            System.out.println("Recurso no encontrado: " + id);
        }
    }

    @Override
    public void listarRecursos() {
        if (recursos.isEmpty()) {
            System.out.println("No hay recursos registrados.");
            return;
        }

        for (String id : recursos.keySet()) {
            String tipo = tipos.get(id);
            String estado = recursos.get(id);
            System.out.println(id + " | Tipo: " + tipo + " | Estado: " + estado);
        }
    }

    @Override
    public List<String> filtrarPorEstado(String estado) {
        List<String> resultado = new ArrayList<>();
        for (String id : recursos.keySet()) {
            if (recursos.get(id).equalsIgnoreCase(estado)) {
                resultado.add(id + " (" + tipos.get(id) + ")");
            }
        }
        return resultado;
    }

    @Override
    public List<String> verHistorialDeUso(String id) {
        return historial.getOrDefault(id, new ArrayList<>());
    }
}
