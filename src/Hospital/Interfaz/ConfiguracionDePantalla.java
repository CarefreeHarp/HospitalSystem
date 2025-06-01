package Hospital.Interfaz;

public class ConfiguracionDePantalla {

    private String resolucion;      // Ej: "720p", "1080p", "4K"
    private boolean modoOscuro;     // true = modo oscuro activado

    public ConfiguracionDePantalla() {
        this.resolucion = "720p";   // valor por defecto
        this.modoOscuro = false;    // valor por defecto
    }

    public void ajustarResolucion(String nuevaResolucion) {
        if (nuevaResolucion.equals("720p") || nuevaResolucion.equals("1080p") || nuevaResolucion.equals("4K")) {
            this.resolucion = nuevaResolucion;
            System.out.println("Resolución ajustada a: " + resolucion);
        } else {
            System.out.println("Resolución no válida. Use: 720p, 1080p o 4K.");
        }
    }

    public void activacionModoLuzOscura(boolean activar) {
        this.modoOscuro = activar;
        if (modoOscuro) {
            System.out.println("Una aplicacion de consola no va acambiar a modo oscuro jajaja ");
        } else {
            System.out.println("Una aplicacion de consola no va acambiar a modo claro jajaja");
        }
    }

    // Métodos para consultar el estado actual (útiles para pruebas o integración)
    public String getResolucion() {
        return resolucion;
    }

    public boolean isModoOscuro() {
        return modoOscuro;
    }
}
