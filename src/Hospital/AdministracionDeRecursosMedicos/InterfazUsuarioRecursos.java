package Hospital.AdministracionDeRecursosMedicos;

import java.util.Scanner;

public class InterfazUsuarioRecursos implements InterfaceInterfazUsuario {

    private GestionRecursos gestion;
    private SincronizacionTiempoReal sincronizacion;
    private Scanner scanner;

    public InterfazUsuarioRecursos(GestionRecursos gestion, SincronizacionTiempoReal sincronizacion) {
        this.gestion = gestion;
        this.sincronizacion = sincronizacion;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void mostrarDetallesRecurso(String id) {
        System.out.println("Detalles del recurso:");
        System.out.println("ID: " + id);
        for (String detalle : gestion.verHistorialDeUso(id)) {
            System.out.println("- " + detalle);
        }
    }

    @Override
    public String[] formularioActualizaciones() {
        System.out.print("Ingrese el ID del recurso: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nuevo estado: ");
        String nuevoEstado = scanner.nextLine();

        return new String[] { id, nuevoEstado };
    }

    @Override
    public void actualizarEstadoRecurso(String id, String nuevoEstado) {
        if (confirmarAccion("¿Está seguro que desea cambiar el estado de " + id + " a " + nuevoEstado + "? (s/n)")) {
            gestion.actualizarEstadoRecurso(id, nuevoEstado);
            sincronizacion.subirCambios(id, nuevoEstado);
            sincronizacion.notificarCambio(id, "Estado actualizado a " + nuevoEstado);
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    @Override
    public boolean confirmarAccion(String mensaje) {
        System.out.println(mensaje);
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("s");
    }
}
