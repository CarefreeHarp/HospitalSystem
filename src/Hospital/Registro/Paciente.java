package Hospital.Registro;

import java.util.List;

public class Paciente {
    private String nombreCompleto;
    private String fechaNacimiento;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private List<String> contactosEmergencia;
    private List<String> alergias;
    private List<String> medicamentos;
    private String seguroMedico;

    public Paciente(String nombreCompleto, String fechaNacimiento, String tipoDocumento, String numeroDocumento,
                    String direccion, List<String> contactosEmergencia, List<String> alergias,
                    List<String> medicamentos, String seguroMedico) {
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.contactosEmergencia = contactosEmergencia;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
        this.seguroMedico = seguroMedico;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<String> getContactosEmergencia() {
        return contactosEmergencia;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }
}
