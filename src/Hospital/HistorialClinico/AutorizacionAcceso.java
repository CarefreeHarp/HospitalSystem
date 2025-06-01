package Hospital.HistorialClinico;

import java.util.HashMap;
import java.util.Map;

public class AutorizacionAcceso implements InterfaceAutorizacionAcceso {

    private Map<String, String> usuariosValidos;

    public AutorizacionAcceso() {
        usuariosValidos = new HashMap<>();
        usuariosValidos.put("admin", "admin");
        usuariosValidos.put("medico1", "abcd");
        usuariosValidos.put("enfermera1", "pass");
    }

    @Override
    public boolean autenticarUsuario(String usuario, String clave) {
        String claveCorrecta = usuariosValidos.get(usuario);
        if (claveCorrecta != null && claveCorrecta.equals(clave)) {
            System.out.println("Acceso concedido a " + usuario);
            return true;
        } else {
            System.out.println("Credenciales inválidas para " + usuario);
            return false;
        }
    }

    @Override
    public void ingresarSistema() {
        System.out.println("Ingreso al sistema registrado.");
    }

    @Override
    public void redireccionamientoAlMenu() {
        System.out.println("Redireccionando al menú del historial clínico...");
    }

    @Override
    public void integracionModuloMonitoreo(String usuario) {
        System.out.println("Registro simulado en módulo de monitoreo para: " + usuario);
    }
}
