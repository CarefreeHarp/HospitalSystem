package Hospital.Registro;

import java.util.HashMap;
import java.util.Map;

public class AutorizacionDeAcceso implements InterfaceAutorizacionDeAcceso {

    // Simulación de usuarios en memoria (usuario -> contraseña)
    private final Map<String, String> usuariosAutorizados = new HashMap<>();

    public AutorizacionDeAcceso() {
        // Usuarios de ejemplo
        usuariosAutorizados.put("medico123", "claveSegura1");
        usuariosAutorizados.put("enfermera456", "claveSegura2");
        usuariosAutorizados.put("admin789", "claveSegura3");
    }

    @Override
    public boolean verificarCredenciales(String usuario, String contrasena) {
        if (usuariosAutorizados.containsKey(usuario)) {
            return usuariosAutorizados.get(usuario).equals(contrasena);
        }
        return false;
    }
}
