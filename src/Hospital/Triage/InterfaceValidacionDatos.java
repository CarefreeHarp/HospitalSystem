package Hospital.Triage;

public interface InterfaceValidacionDatos {
    String calcularPrioridad();  // Retorna: "Verde", "Amarillo", "Rojo"
    void enviarAlerta(String prioridad);
}
