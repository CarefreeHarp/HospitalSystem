package Hospital.Interfaz;

public class VisualizacionPaciente {

    // Atributos simulados (en un sistema real vendrían de una base de datos o servicio)
    private String[] alergias;
    private String[] medicamentos;

    public VisualizacionPaciente(String[] alergias, String[] medicamentos) {
        this.alergias = alergias;
        this.medicamentos = medicamentos;
    }

    public void mostrarSignosVitales() {
        System.out.println("\n\n\n\n\nSignos Vitales del Paciente:");
        System.out.println("Aca se muestran los signos vitales obtenidos de alguna base de datos\n\n\n\n\n");
    }

    public void mostrarAlergias() {
        System.out.println("\n\n\n\n\nAlergias conocidas:");
        if (alergias != null && alergias.length > 0) {
            for (String alergia : alergias) {
                System.out.println(" - " + alergia);
            }
        } else {
            System.out.println("No se registran alergias.");
        }
    }

    public void mostrarMedicamentos() {
        System.out.println("\n\n\n\n\n\nMedicamentos actuales:");
        if (medicamentos != null && medicamentos.length > 0) {
            for (String med : medicamentos) {
                System.out.println(" - " + med);
            }
        } else {
            System.out.println("No se están administrando medicamentos actualmente.");
        }
    }
}
