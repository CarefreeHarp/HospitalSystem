package Hospital.HistorialClinico;

import java.util.Scanner;

public class GestionAbandono implements InterfaceGestionAbandono {

    private Scanner scanner;

    public GestionAbandono() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public boolean confirmarAbandono() {
        System.out.print("¿Está seguro que desea abandonar el módulo? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

    @Override
    public void redireccionamientoAlIngreso() {
        System.out.println("Redirigiendo a la pantalla de inicio de sesión...");
    }
}
