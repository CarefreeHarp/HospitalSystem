package Hospital;

import Hospital.Interfaz.MenuInterfaz;
import Hospital.Registro.MenuRegistro;
import Hospital.Triage.MenuTriage;
import Hospital.AdministracionDeRecursosMedicos.MenuAdministracionDeRecursosMedicos;
import Hospital.MonitoreoDelSistemaSimulacion.MenuMonitoreo;
import Hospital.HistorialClinico.MenuHistorialClinico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> mostrarMenuInterfaz(scanner);
                case 2 -> mostrarMenuRegistro(scanner);
                case 3 -> mostrarMenuTriage(scanner);
                case 4 -> mostrarMenuRecursosMedicos();
                case 5 -> mostrarMenuMonitoreo();
                case 6 -> mostrarMenuHistorialClinico();
                case 9 -> {
                    System.out.println("¡Hasta luego!");
                    continuar = false;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }

            if (continuar) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("===================================");
        System.out.println("    SISTEMA HOSPITALARIO - MENÚ    ");
        System.out.println("===================================");
        System.out.println("1. Módulo de Interfaz");
        System.out.println("2. Módulo de Registro");
        System.out.println("3. Módulo de Triage");
        System.out.println("4. Módulo de Recursos Médicos (Para registrar, consultar y administrar medicamentos o utensilios del hospital :D)");
        System.out.println("5. Módulo de Monitoreo del Sistema");
        System.out.println("6. Módulo de Historial Clínico");
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
        MenuInterfaz menuInterfaz = new MenuInterfaz();
        menuInterfaz.mostrar(scanner);
    }

    private static void mostrarMenuRegistro(Scanner scanner) {
        MenuRegistro menuRegistro = new MenuRegistro();
        menuRegistro.mostrar(scanner);
    }

    private static void mostrarMenuTriage(Scanner scanner) {
        MenuTriage menuTriage = new MenuTriage();
        menuTriage.mostrar(scanner);
    }

    private static void mostrarMenuRecursosMedicos() {
        MenuAdministracionDeRecursosMedicos menuRecursos = new MenuAdministracionDeRecursosMedicos();
        menuRecursos.mostrarMenu();
    }

    private static void mostrarMenuMonitoreo() {
        MenuMonitoreo menuMonitoreo = new MenuMonitoreo();
        menuMonitoreo.mostrarMenu();
    }

    private static void mostrarMenuHistorialClinico() {
        MenuHistorialClinico menuHistorial = new MenuHistorialClinico();
        menuHistorial.mostrarMenu();
    }
}
