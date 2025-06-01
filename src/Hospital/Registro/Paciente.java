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
                String direccion, List<String> contactos, List<String> alergias, List<String> medicamentos, String seguroMedico) {

    this.nombreCompleto = nombreCompleto;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocumento = numeroDocumento;
    this.direccion = direccion;
    this.contactosEmergencia = contactos;
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

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContactosEmergencia(List<String> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    @Override
    public String toString() {
    return "Nombre: " + nombreCompleto +
           "\nFecha de nacimiento: " + fechaNacimiento +
           "\nTipo de documento: " + tipoDocumento +
           "\nNúmero de documento: " + numeroDocumento +
           "\nDirección: " + direccion +
           "\nContactos de emergencia: " + String.join(", ", contactosEmergencia) +
           "\nAlergias: " + String.join(", ", alergias) +
           "\nMedicamentos actuales: " + String.join(", ", medicamentos) +
           "\nSeguro médico: " + seguroMedico;
}

}
