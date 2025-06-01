package Hospital.MonitoreoDelSistemaSimulacion;

import java.util.ArrayList;
import java.util.List;

public class AuditoriaSimulada implements InterfaceAuditoriaSimulada {

    private RegistroActividadSimulado registro;

    public AuditoriaSimulada(RegistroActividadSimulado registro) {
        this.registro = registro;
    }

    @Override
    public List<String> consultarRegistros() {
        return registro.obtenerLogs();
    }

    @Override
    public List<String> buscarRegistroPorUsuario(String usuario) {
        List<String> resultado = new ArrayList<>();
        for (String log : registro.obtenerLogs()) {
            if (log.contains(usuario)) {
                resultado.add(log);
            }
        }
        return resultado;
    }

    @Override
    public String verDetalleRegistro(String id) {
        for (String log : registro.obtenerLogs()) {
            if (log.contains(id)) {
                return log;
            }
        }
        return "Registro no encontrado.";
    }

    @Override
    public void exportarReporte(String formato) {
        System.out.println("Exportando reporte en formato " + formato + "...");
        for (String log : registro.obtenerLogs()) {
            System.out.println(log);
        }
        System.out.println("Exportación simulada finalizada.");
    }
}
