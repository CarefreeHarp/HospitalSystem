package Hospital.Triage;

public class MonitoreoTiempo implements InterfaceMonitoreoTiempo {

    //Se calcula el tiempo maximo de espera según la prioridad del paciente. y el color de la emergencia que le fue asignado
    @Override
    public void verificarTiempoEspera(long minutosEnEspera, String prioridad) {
        if (prioridad.equals("Rojo") && minutosEnEspera > 15) {
            notificarDemora(prioridad);
        } else if ((prioridad.equals("Amarillo") || prioridad.equals("Verde")) && minutosEnEspera > 30) {
            notificarDemora(prioridad);
        }
    }

    @Override
    public void notificarDemora(String prioridad) {
        System.out.println("Alerta: Paciente con prioridad " + prioridad + " ha superado el tiempo máximo de espera.");
    }
}
