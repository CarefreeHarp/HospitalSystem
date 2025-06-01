package Hospital.AdministracionDeRecursosMedicos;

import java.util.HashMap;
import java.util.Map;

public class SincronizacionTiempoReal implements InterfaceSincronizacionTiempoReal {

    private Map<String, String> estadoServidor;
    private Map<String, String> logCambios;

    public SincronizacionTiempoReal() {
        estadoServidor = new HashMap<>();
        logCambios = new HashMap<>();
    }

    @Override
    public void subirCambios(String id, String estado) {
        estadoServidor.put(id, estado);
        System.out.println("Cambios subidos al servidor para " + id + " -> " + estado);
    }

    @Override
    public boolean verificarActualizaciones(String id, String estadoLocal) {
        String estadoServidorActual = estadoServidor.get(id);
        boolean hayCambio = estadoServidorActual != null && !estadoServidorActual.equals(estadoLocal);

        if (hayCambio) {
            System.out.println("Diferencia detectada en " + id + ": local=" + estadoLocal + ", servidor=" + estadoServidorActual);
        } else {
            System.out.println("Estado sincronizado para " + id);
        }

        return hayCambio;
    }

    @Override
    public void notificarCambio(String id, String mensaje) {
        logCambios.put(id, mensaje);
        System.out.println("Notificación: " + mensaje + " (Recurso: " + id + ")");
    }

    // (Opcional) Método para consultar el log de notificaciones
    public String consultarUltimaNotificacion(String id) {
        return logCambios.getOrDefault(id, "Sin notificaciones registradas");
    }
}
