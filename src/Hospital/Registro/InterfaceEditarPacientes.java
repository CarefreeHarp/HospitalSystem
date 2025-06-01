package Hospital.Registro;

public interface InterfaceEditarPacientes {

    boolean actualizarDireccion(String tipoDoc, String numeroDoc, String nuevaDireccion);

    boolean agregarContactoEmergencia(String tipoDoc, String numeroDoc, String nuevoContacto);

    boolean eliminarContactoEmergencia(String tipoDoc, String numeroDoc, String contactoAEliminar);

    boolean agregarAlergia(String tipoDoc, String numeroDoc, String nuevaAlergia);

    boolean eliminarAlergia(String tipoDoc, String numeroDoc, String alergiaAEliminar);
}
