package Hospital.Triage;

public interface InterfaceMonitoreoTiempo {
    void verificarTiempoEspera(long minutosEnEspera, String prioridad);
    void notificarDemora(String prioridad);
}
