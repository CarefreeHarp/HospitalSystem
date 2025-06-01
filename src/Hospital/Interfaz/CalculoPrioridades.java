package Hospital.Interfaz;

public class CalculoPrioridades implements InterfaceCalculoPrioridades{

    private double temperatura;
    private int presionSistolica;
    private int presionDiastolica;
    private int saturacionOxigeno;
    private int escalaGlasgow;
    private int nivelDolor;

    public CalculoPrioridades(double temperatura, int presionSistolica, int presionDiastolica,
                               int saturacionOxigeno, int escalaGlasgow, int nivelDolor) {
        this.temperatura = temperatura;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
        this.saturacionOxigeno = saturacionOxigeno;
        this.escalaGlasgow = escalaGlasgow;
        this.nivelDolor = nivelDolor;
    }

    public void alertarPorPrioridad() {
        System.out.println("\n\n\n\n\n\nAlerta de Prioridad:");

        boolean alerta = false;

        if (temperatura > 39.0) {
            System.out.println(" - Temperatura elevada (>39°C): Código AMARILLO");
            alerta = true;
        }
        if (presionSistolica > 180 || presionDiastolica > 120) {
            System.out.println(" - Presión arterial crítica (>180/120): Código ROJO");
            alerta = true;
        }
        if (saturacionOxigeno < 92) {
            System.out.println(" - Saturación de oxígeno baja (<92%): ¡ATENCIÓN INMEDIATA!");
            alerta = true;
        }

        if (!alerta) {
            System.out.println(" - Sin alertas críticas detectadas.");
        }
    }

    public void mostrarEscalaGlasgow() {
        System.out.println("\n\n\n\n\n\nEscala de Glasgow: " + escalaGlasgow + " puntos");
        if (escalaGlasgow < 8) {
            System.out.println(" - Estado crítico. Posible inconsciencia.");
        } else if (escalaGlasgow <= 12) {
            System.out.println(" - Estado moderado. Requiere monitoreo.");
        } else {
            System.out.println(" - Estado de conciencia aceptable.");
        }
    }

    public void mostrarResultados() {
        System.out.println("\n\n\n\n\n\n Resultados del triaje:");
        System.out.printf(" - Temperatura: %.1f °C\n", temperatura);
        System.out.printf(" - Presión Arterial: %d/%d mmHg\n", presionSistolica, presionDiastolica);
        System.out.printf(" - Saturación de Oxígeno: %d %%\n", saturacionOxigeno);
        System.out.printf(" - Escala de Glasgow: %d\n", escalaGlasgow);
        System.out.printf(" - Nivel de Dolor: %d / 10\n", nivelDolor);
    }
}