package Hospital;

import Hospital.Interfaz.VisualizacionPaciente;
import Hospital.Interfaz.CalculoPrioridades;
import Hospital.Interfaz.ConfiguracionDePantalla;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    mostrarMenuInterfaz(scanner);
                    break;
                case 9:
                    System.out.println("¡Hasta luego");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

            if (continuar) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("===================================");
        System.out.println("    SISTEMA HOSPITALARIO - MENÚ    ");
        System.out.println("===================================");
        System.out.println("1. Módulo de Interfaz");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion(Scanner scanner) {
        int opcion = -1;
        try {
            opcion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido.");
        }
        return opcion;
    }

    private static void mostrarMenuInterfaz(Scanner scanner) {
        // Simulamos datos de paciente
        Map<String, Double> signos = new HashMap<>();
        signos.put("temperatura", 39.5);
        signos.put("presion_sistolica", 185.0);
        signos.put("presion_diastolica", 122.0);
        signos.put("saturacion_oxigeno", 89.0);

        String[] alergias = {"Penicilina", "Polen"};
        String[] medicamentos = {"Paracetamol", "Omeprazol"};

        VisualizacionPaciente visual = new VisualizacionPaciente(alergias, medicamentos);
        CalculoPrioridades prioridades = new CalculoPrioridades(39.5, 185, 122, 89, 9, 6);
        ConfiguracionDePantalla pantalla = new ConfiguracionDePantalla();

        boolean volver = false;
        while (!volver) {
            System.out.println("\n===== MÓDULO DE INTERFAZ =====");
            System.out.println("1. Mostrar signos vitales");
            System.out.println("2. Mostrar alergias");
            System.out.println("3. Mostrar medicamentos");
            System.out.println("4. Calcular prioridad y alertas");
            System.out.println("5. Mostrar escala de Glasgow");
            System.out.println("6. Mostrar resultados del triaje");
            System.out.println("7. Ajustar resolución");
            System.out.println("8. Activar/desactivar modo oscuro");
            System.out.println("9. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1 -> visual.mostrarSignosVitales();
                case 2 -> visual.mostrarAlergias();
                case 3 -> visual.mostrarMedicamentos();
                case 4 -> prioridades.alertarPorPrioridad();
                case 5 -> prioridades.mostrarEscalaGlasgow();
                case 6 -> prioridades.mostrarResultados();
                case 7 -> {
                    System.out.print("Ingrese resolución (720p, 1080p, 4K): ");
                    String nuevaRes = scanner.nextLine();
                    pantalla.ajustarResolucion(nuevaRes);
                }
                case 8 -> {
                    System.out.print("¿Activar modo oscuro? (s/n): ");
                    String respuesta = scanner.nextLine().trim().toLowerCase();
                    pantalla.activacionModoLuzOscura(respuesta.equals("s"));
                }
                case 9 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
