package Hospital.MonitoreoDelSistemaSimulacion;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegistroActividadSimulado implements InterfaceRegistroActividadSimulado {

    private List<String> logs;

    public RegistroActividadSimulado() {
        logs = new ArrayList<>();
    }

    @Override
    public void registrarAcceso(String usuario) {
        String log = "[ACCESO] Usuario: " + usuario + " | Timestamp: " + System.currentTimeMillis();
        logs.add(log);
        System.out.println("Registrado: " + log);
    }

    @Override
    public void registrarConsulta(String usuario, String recurso) {
        String log = "[CONSULTA] Usuario: " + usuario + " | Recurso: " + recurso + " | Timestamp: " + System.currentTimeMillis();
        logs.add(log);
        System.out.println("Registrado: " + log);
    }

    @Override
    public void registrarModificacion(String usuario, String recurso, String descripcionCambio) {
        String id = generarIDModificacion();
        String log = "[MODIFICACIÓN] ID: " + id + " | Usuario: " + usuario + " | Recurso: " + recurso +
                     " | Cambio: " + descripcionCambio + " | Timestamp: " + System.currentTimeMillis();
        logs.add(log);
        System.out.println("Registrado: " + log);
    }

    @Override
    public String generarIDModificacion() {
        return UUID.randomUUID().toString();
    }

    public List<String> obtenerLogs() {
        return logs;
    }
}
