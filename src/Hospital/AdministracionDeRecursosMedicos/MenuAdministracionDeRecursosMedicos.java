package Hospital.AdministracionDeRecursosMedicos;
import java.util.List;
import java.util.Scanner;

public class MenuAdministracionDeRecursosMedicos {

    private GestionRecursos gestion;
    private SincronizacionTiempoReal sincronizacion;
    private InterfazUsuarioRecursos interfaz;
    private Scanner scanner;

    public MenuAdministracionDeRecursosMedicos() {
        this.gestion = new GestionRecursos();
        this.sincronizacion = new SincronizacionTiempoReal();
        this.interfaz = new InterfazUsuarioRecursos(gestion, sincronizacion);
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== ADMINISTRACIÓN DE RECURSOS MÉDICOS ===");
            System.out.println("1. Registrar nuevo recurso");
            System.out.println("2. Eliminar recurso");
            System.out.println("3. Listar todos los recursos");
            System.out.println("4. Filtrar recursos por estado");
            System.out.println("5. Ver historial de uso");
            System.out.println("6. Mostrar detalles de recurso");
            System.out.println("7. Actualizar estado de un recurso");
            System.out.println("8. Verificar sincronización");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarRecurso();
                    break;
                case 2:
                    eliminarRecurso();
                    break;
                case 3:
                    gestion.listarRecursos();
                    break;
                case 4:
                    filtrarPorEstado();
                    break;
                case 5:
                    verHistorialDeUso();
                    break;
                case 6:
                    mostrarDetallesRecurso();
                    break;
                case 7:
                    actualizarEstadoRecurso();
                    break;
                case 8:
                    verificarSincronizacion();
                    break;
                case 0:
                    System.out.println("Saliendo del módulo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void registrarRecurso() {
        System.out.print("Ingrese el tipo de recurso: ");
        String tipo = scanner.nextLine();
        System.out.print("Ingrese el ID del recurso: ");
        String id = scanner.nextLine();
        gestion.registrarNuevoRecurso(tipo, id);
        sincronizacion.subirCambios(id, "Disponible");
    }

    private void eliminarRecurso() {
        System.out.print("Ingrese el ID del recurso a eliminar: ");
        String id = scanner.nextLine();
        gestion.eliminarRecurso(id);
    }

    private void filtrarPorEstado() {
        System.out.print("Ingrese el estado a filtrar: ");
        String estado = scanner.nextLine();
        List<String> filtrados = gestion.filtrarPorEstado(estado);
        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron recursos con ese estado.");
        } else {
            for (String recurso : filtrados) {
                System.out.println(recurso);
            }
        }
    }

    private void verHistorialDeUso() {
        System.out.print("Ingrese el ID del recurso: ");
        String id = scanner.nextLine();
        List<String> historial = gestion.verHistorialDeUso(id);
        if (historial.isEmpty()) {
            System.out.println("Sin historial registrado.");
        } else {
            for (String evento : historial) {
                System.out.println("- " + evento);
            }
        }
    }

    private void mostrarDetallesRecurso() {
        System.out.print("Ingrese el ID del recurso: ");
        String id = scanner.nextLine();
        interfaz.mostrarDetallesRecurso(id);
    }

    private void actualizarEstadoRecurso() {
        String[] datos = interfaz.formularioActualizaciones();
        String id = datos[0];
        String nuevoEstado = datos[1];
        interfaz.actualizarEstadoRecurso(id, nuevoEstado);
    }

    private void verificarSincronizacion() {
        System.out.print("Ingrese el ID del recurso: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el estado local actual: ");
        String estadoLocal = scanner.nextLine();
        sincronizacion.verificarActualizaciones(id, estadoLocal);
    }
}
