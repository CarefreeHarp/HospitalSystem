package Hospital.MonitoreoDelSistemaSimulacion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeguridadSimulada implements InterfaceSeguridadSimulada {

    private Map<String, String> usuariosValidos;
    private Set<String> usuariosBloqueados;
    private Map<String, Integer> intentosFallidos;

    public SeguridadSimulada() {
        usuariosValidos = new HashMap<>();
        usuariosBloqueados = new HashSet<>();
        intentosFallidos = new HashMap<>();

        // Usuarios de mentira permitidos
        usuariosValidos.put("admin", "admin");
        usuariosValidos.put("medico1", "abcd");
        usuariosValidos.put("enfermera1", "pass");
    }

    @Override
    public boolean autenticarUsuario(String usuario, String clave) {
        if (usuariosBloqueados.contains(usuario)) {
            System.out.println("Usuario bloqueado.");
            return false;
        }

        if (usuariosValidos.containsKey(usuario) && usuariosValidos.get(usuario).equals(clave)) {
            System.out.println("Autenticación exitosa.");
            intentosFallidos.put(usuario, 0); // reset
            return true;
        } else {
            registrarIntentoFallido(usuario);
            return false;
        }
    }

    @Override
    public boolean validarPermisos(String usuario, String recurso) {
        // Simulación básica: todos tienen acceso a todo menos bloqueados
        return !usuariosBloqueados.contains(usuario);
    }

    @Override
    public void registrarIntentoFallido(String usuario) {
        int intentos = intentosFallidos.getOrDefault(usuario, 0) + 1;
        intentosFallidos.put(usuario, intentos);
        System.out.println("Intento fallido #" + intentos);

        if (intentos >= 3) {
            bloquearUsuario(usuario);
        }
    }

    @Override
    public void bloquearUsuario(String usuario) {
        usuariosBloqueados.add(usuario);
        System.out.println("Usuario bloqueado por múltiples intentos fallidos.");
    }
}
