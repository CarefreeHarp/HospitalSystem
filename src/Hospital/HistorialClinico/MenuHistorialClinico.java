package Hospital.HistorialClinico;

import java.util.Scanner;

public class MenuHistorialClinico {

    private AutorizacionAcceso autorizacion;
    private HistorialClinico historial;
    private GestionAbandono abandono;
    private Scanner scanner;

    public MenuHistorialClinico() {
        this.autorizacion = new AutorizacionAcceso();
        this.historial = new HistorialClinico();
        this.abandono = new GestionAbandono();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String clave = scanner.nextLine();

        if (!autorizacion.autenticarUsuario(usuario, clave)) {
            System.out.println("Autenticación fallida. Acceso denegado.");
            return;
        }

        autorizacion.ingresarSistema();
        autorizacion.integracionModuloMonitoreo(usuario);
        autorizacion.redireccionamientoAlMenu();

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENÚ HISTORIAL CLÍNICO ===");
            System.out.println("1. Consultar historial clínico");
            System.out.println("2. Actualizar historial clínico");
            System.out.println("3. Mostrar historial completo");
            System.out.println("0. Abandonar módulo");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();
                    historial.consultarHistorial(id);
                }
                case 2 -> {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();
                    System.out.print("Nuevo registro clínico: ");
                    String registro = scanner.nextLine();
                    historial.actualizarHistorial(id, registro);
                }
                case 3 -> {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();
                    historial.mostrarHistorial(id);
                }
                case 0 -> {
                    if (abandono.confirmarAbandono()) {
                        abandono.redireccionamientoAlIngreso();
                    } else {
                        opcion = -1; // Cancelar salida
                    }
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
