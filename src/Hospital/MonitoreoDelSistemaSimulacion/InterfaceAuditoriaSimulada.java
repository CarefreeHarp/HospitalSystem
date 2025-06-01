package Hospital.MonitoreoDelSistemaSimulacion;

import java.util.List;

public interface InterfaceAuditoriaSimulada {
    List<String> consultarRegistros();
    List<String> buscarRegistroPorUsuario(String usuario);
    String verDetalleRegistro(String id);
    void exportarReporte(String formato);
}
