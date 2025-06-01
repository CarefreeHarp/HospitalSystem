package Hospital.Registro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRegistro {

    private final RegistroPacienteFactory registroPaciente;
    private final InterfaceBusquedaDePacientes busquedaPacientes;
    private final InterfaceEditarPacientes editarPacientes;
    private final InterfaceIntegracionHistorialClinico integracion;

    public MenuRegistro() {
        this.registroPaciente = new RegistroPacienteFactory();
        this.busquedaPacientes = new BusquedaDePacientes();
        this.editarPacientes = new EditarPacientes();
        this.integracion = new IntegracionHistorialClinico();
    }

    public void mostrar(Scanner scanner) {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n===== MÓDULO DE REGISTRO DE PACIENTES =====");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Buscar paciente por documento");
            System.out.println("3. Ver todos los pacientes");
            System.out.println("4. Editar dirección");
            System.out.println("5. Agregar alergia");
            System.out.println("6. Sincronizar con historial clínico");
            System.out.println("7. Mostrar historial clínico");
            System.out.println("9. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1 -> registrarPaciente(scanner);
                case 2 -> buscarPaciente(scanner);
                case 3 -> registroPaciente.consultarPacientes();
                case 4 -> editarDireccion(scanner);
                case 5 -> agregarAlergia(scanner);
                case 6 -> sincronizarHistorial(scanner);
                case 7 -> mostrarHistorial(scanner);
                case 9 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }

            if (!volver) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }
    }

    private int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido.");
            return -1;
        }
    }

    private void registrarPaciente(Scanner scanner) {
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Contactos de emergencia separados por comas: ");
        List<String> contactos = new ArrayList<>(List.of(scanner.nextLine().split(",")));

        System.out.print("Alergias separadas por comas: ");
        List<String> alergias = new ArrayList<>(List.of(scanner.nextLine().split(",")));
        
        System.out.print("medicamentos separados por comas: ");
        List<String> medicamentos = new ArrayList<>(List.of(scanner.nextLine().split(",")));


        System.out.print("Cobertura del seguro médico: ");
        String seguro = scanner.nextLine();

        Paciente nuevo = new Paciente(nombre, fechaNacimiento, tipoDoc, numeroDoc,
                direccion, contactos, alergias, medicamentos, seguro);

        registroPaciente.guardarPaciente(nuevo);
    }

    private void buscarPaciente(Scanner scanner) {
        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        List<Paciente> pacientes = RegistroPacienteFactory.getPacientes();
        boolean encontrado = false;

        for (Paciente p : pacientes) {
            if (p.getTipoDocumento().equalsIgnoreCase(tipoDoc) &&
                p.getNumeroDocumento().equalsIgnoreCase(numeroDoc)) {
                System.out.println("Paciente encontrado:");
                System.out.println(p);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún paciente con ese documento.");
        }
    }

    private void editarDireccion(Scanner scanner) {
        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        System.out.print("Nueva dirección: ");
        String nuevaDireccion = scanner.nextLine();

        editarPacientes.actualizarDireccion(tipoDoc, numeroDoc, nuevaDireccion);
    }

    private void agregarAlergia(Scanner scanner) {
        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        System.out.print("Nueva alergia a agregar: ");
        String alergia = scanner.nextLine();

        editarPacientes.agregarAlergia(tipoDoc, numeroDoc, alergia);
    }

    private void sincronizarHistorial(Scanner scanner) {
        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        for (Paciente p : RegistroPacienteFactory.getPacientes()) {
            if (p.getTipoDocumento().equalsIgnoreCase(tipoDoc)
                && p.getNumeroDocumento().equalsIgnoreCase(numeroDoc)) {
                integracion.sincronizarPacienteConHistorial(p);
                return;
            }
        }

        System.out.println("Paciente no encontrado.");
    }

    private void mostrarHistorial(Scanner scanner) {
        System.out.print("Tipo de documento: ");
        String tipoDoc = scanner.nextLine();

        System.out.print("Número de documento: ");
        String numeroDoc = scanner.nextLine();

        integracion.mostrarHistorialPaciente(tipoDoc, numeroDoc);
    }
}
