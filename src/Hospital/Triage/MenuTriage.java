package Hospital.Triage;

import java.util.Scanner;

public class MenuTriage {

    public void mostrar(Scanner scanner) {
        ClasificarPrioridad clasificador = new ClasificarPrioridad();
        ValidacionDatos validador = new ValidacionDatos(clasificador);
        MonitoreoTiempo monitoreo = new MonitoreoTiempo();

        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MÓDULO DE TRIAGE =====");
            System.out.println("1. Registrar signos vitales");
            System.out.println("2. Calcular prioridad");
            System.out.println("3. Verificar tiempo de espera");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            String input = scanner.nextLine().trim();
            int opcion;
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    clasificador.registrarSignosVitales();
                    if (!clasificador.validarRango()) {
                        System.out.println("Error: Valores fuera de rango. Verifique e intente de nuevo.");
                    } else {
                        System.out.println("Signos vitales registrados correctamente.");
                    }
                }
                case 2 -> {
                    String prioridad = validador.calcularPrioridad();
                    System.out.println("Prioridad asignada: " + prioridad);
                    validador.enviarAlerta(prioridad);
                }
                case 3 -> {
                    System.out.print("Ingrese minutos de espera del paciente: ");
                    try {
                        long minutos = Long.parseLong(scanner.nextLine().trim());
                        String prioridad = validador.calcularPrioridad();
                        monitoreo.verificarTiempoEspera(minutos, prioridad);
                    } catch (NumberFormatException e) {
                        System.out.println("Minutos inválidos. Intente de nuevo.");
                    }
                }
                case 4 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
