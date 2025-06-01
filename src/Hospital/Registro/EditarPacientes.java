package Hospital.Registro;

import java.util.List;

public class EditarPacientes implements InterfaceEditarPacientes {

    private final List<Paciente> pacientes = RegistroPacienteFactory.getPacientes();

    private Paciente buscarPaciente(String tipoDoc, String numeroDoc) {
        for (Paciente paciente : pacientes) {
            if (paciente.getTipoDocumento().equalsIgnoreCase(tipoDoc)
                    && paciente.getNumeroDocumento().equalsIgnoreCase(numeroDoc)) {
                return paciente;
            }
        }
        return null;
    }

    @Override
    public boolean actualizarDireccion(String tipoDoc, String numeroDoc, String nuevaDireccion) {
        Paciente paciente = buscarPaciente(tipoDoc, numeroDoc);
        if (paciente != null) {
            paciente.setDireccion(nuevaDireccion);
            System.out.println("Dirección actualizada.");
            return true;
        }
        System.out.println("Paciente no encontrado.");
        return false;
    }

    @Override
    public boolean agregarContactoEmergencia(String tipoDoc, String numeroDoc, String nuevoContacto) {
        Paciente paciente = buscarPaciente(tipoDoc, numeroDoc);
        if (paciente != null) {
            paciente.getContactosEmergencia().add(nuevoContacto);
            System.out.println("Contacto de emergencia agregado.");
            return true;
        }
        System.out.println("Paciente no encontrado.");
        return false;
    }

    @Override
    public boolean eliminarContactoEmergencia(String tipoDoc, String numeroDoc, String contactoAEliminar) {
        Paciente paciente = buscarPaciente(tipoDoc, numeroDoc);
        if (paciente != null && paciente.getContactosEmergencia().remove(contactoAEliminar)) {
            System.out.println("Contacto de emergencia eliminado.");
            return true;
        }
        System.out.println("Paciente no encontrado o contacto inexistente.");
        return false;
    }

    @Override
    public boolean agregarAlergia(String tipoDoc, String numeroDoc, String nuevaAlergia) {
        Paciente paciente = buscarPaciente(tipoDoc, numeroDoc);
        if (paciente != null) {
            paciente.getAlergias().add(nuevaAlergia);
            System.out.println("Alergia agregada.");
            return true;
        }
        System.out.println("Paciente no encontrado.");
        return false;
    }

    @Override
    public boolean eliminarAlergia(String tipoDoc, String numeroDoc, String alergiaAEliminar) {
        Paciente paciente = buscarPaciente(tipoDoc, numeroDoc);
        if (paciente != null && paciente.getAlergias().remove(alergiaAEliminar)) {
            System.out.println("Alergia eliminada.");
            return true;
        }
        System.out.println("Paciente no encontrado o alergia inexistente.");
        return false;
    }
}