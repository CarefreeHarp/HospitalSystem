package Hospital.MonitoreoDelSistemaSimulacion;
import java.util.List;
import java.util.Scanner;

public class MenuMonitoreo {

    private SeguridadSimulada seguridad;
    private RegistroActividadSimulado registro;
    private AuditoriaSimulada auditoria;
    private Scanner scanner;

    public MenuMonitoreo() {
        this.seguridad = new SeguridadSimulada();
        this.registro = new RegistroActividadSimulado();
        this.auditoria = new AuditoriaSimulada(registro);
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.print("Ingrese usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese clave: ");
        String clave = scanner.nextLine();

        if (!seguridad.autenticarUsuario(usuario, clave)) {
            System.out.println("Acceso denegado.");
            return;
        }

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n=== MENÚ MONITOREO ===");
            System.out.println("1. Registrar acceso");
            System.out.println("2. Registrar consulta");
            System.out.println("3. Registrar modificación");
            System.out.println("4. Consultar todos los registros");
            System.out.println("5. Buscar registros por usuario");
            System.out.println("6. Ver detalle por ID");
            System.out.println("7. Exportar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> registro.registrarAcceso(usuario);
                case 2 -> {
                    System.out.print("Recurso consultado: ");
                    String recurso = scanner.nextLine();
                    registro.registrarConsulta(usuario, recurso);
                }
                case 3 -> {
                    System.out.print("Recurso modificado: ");
                    String recurso = scanner.nextLine();
                    System.out.print("Descripción del cambio: ");
                    String cambio = scanner.nextLine();
                    registro.registrarModificacion(usuario, recurso, cambio);
                }
                case 4 -> {
                    List<String> todos = auditoria.consultarRegistros();
                    todos.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Usuario a buscar: ");
                    String u = scanner.nextLine();
                    List<String> encontrados = auditoria.buscarRegistroPorUsuario(u);
                    encontrados.forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("ID del registro: ");
                    String id = scanner.nextLine();
                    System.out.println(auditoria.verDetalleRegistro(id));
                }
                case 7 -> {
                    System.out.print("Formato (PDF/CSV): ");
                    String formato = scanner.nextLine();
                    auditoria.exportarReporte(formato);
                }
                case 0 -> System.out.println("Saliendo del módulo de monitoreo...");
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
