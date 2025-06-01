package Hospital.Triage;

public class ValidacionDatos implements InterfaceValidacionDatos {

    private final ClasificarPrioridad datos;

    public ValidacionDatos(ClasificarPrioridad datos) {
        this.datos = datos;
    }

    @Override
    public String calcularPrioridad() {
        boolean critico = datos.getPresionSistolica() > 180 || datos.getPresionDiastolica() > 120;
        boolean urgente = datos.getTemperatura() > 39;
        boolean oxigenoBajo = datos.getSaturacionOxigeno() < 92;

        if (critico || oxigenoBajo) {
            return "Rojo";
        } else if (urgente) {
            return "Amarillo";
        } else {
            return "Verde";
        }
    }

    @Override
    public void enviarAlerta(String prioridad) {
        if (prioridad.equals("Rojo")) {
            System.out.println("¡Alerta crítica! Notificando al personal médico.");
        } else if (prioridad.equals("Amarillo")) {
            System.out.println("Atención requerida: Prioridad media.");
        }
    }
}
