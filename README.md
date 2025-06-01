# Sistema Hospitalario San Vicente

Aplicación de consola en Java que simula el funcionamiento de los módulos clave de un sistema hospitalario, enfocado en el área de emergencias. Desarrollado como parte de un proyecto académico para la Pontificia Universidad Javeriana.
Este proyecto busca la aplicación de los conocimientos adquiridos en la clase de Análisis y diseño de Software poniendo en práctica patrones de diseño de software y buenas prácticas de desarrollo entre los cuales están patrones creacionales como factory method, de comportamiendo como strategy o observer e incluso la aplicacion de principios SOLID para el desarrollo de nuestro sistema

Integrantes:
Daniel Felipe Ramírez Vargas
Nicolás Castañeda Vargas
Guillermo Aponte Cardenas
María Fernanda Cruz Niño 



---

## Estructura del Proyecto

```plaintext
Hospital/
├── Main.java
├── Interfaz/
│   ├── MenuInterfaz.java
│   ├── VisualizacionPaciente.java
│   ├── CalculoPrioridades.java
│   └── ConfiguracionDePantalla.java
├── Registro/
│   ├── MenuRegistro.java
│   ├── Paciente.java
│   ├── RegistroPacienteFactory.java
│   ├── InterfaceRegistroPaciente.java
│   ├── InterfaceBusquedaPaciente.java
│   ├── BusquedaPaciente.java
│   ├── InterfaceEditarPaciente.java
│   ├── EditarPaciente.java
│   ├── InterfaceAutorizacionDeAcceso.java
│   ├── AutorizacionDeAcceso.java
│   ├── InterfaceVerificadorDeSeguridad.java
│   ├── VerificadorDeSeguridad.java
│   ├── InterfaceIntegracionHistorial.java
│   └── IntegracionHistorial.java
├── Triage/
│   ├── MenuTriage.java
│   ├── InterfaceClasificarPrioridad.java
│   ├── ClasificarPrioridad.java
│   ├── InterfaceValidacionDatos.java
│   ├── ValidacionDatos.java
│   ├── InterfaceMonitoreoTiempo.java
│   └── MonitoreoTiempo.java
```


---

## Módulos Implementados

### 1. Módulo de Interfaz

- Visualización de signos vitales, medicamentos y alergias.
- Escala de Glasgow y resultados del triaje.
- Ajustes de resolución y modo oscuro.

### 2. Módulo de Registro

- Registro de pacientes en un `ArrayList` simulando una base de datos.
- Consulta, edición y verificación de duplicados.
- Control de acceso, seguridad y validaciones.
- Simulación de integración con historial clínico.

### 3. Módulo de Triage

- Registro y validación de signos vitales.
- Cálculo automático de prioridad médica.
- Monitoreo del tiempo de espera y alertas.

---

## Principios de Diseño (Solicitados Por el Proyecto)

-  Principios SOLID en la definición de interfaces.
# -  Patrones de diseño:
  - **Factory Method**: Registro de pacientes (Presente en la carpeta Registro en la clase RegistroPacienteFactory.java)
  - **Strategy**: Cálculo de prioridad en Triage (El cálculo de la prioridad depende del Triage registrado y puede cambiar segun la necesidad) (Presente en la carpeta Triage en la clase ValidacionDatos.java)
  - **Observer**: Alerta de espera en Triage (El sistema alerta si el tiempo de espera de un paciente es demasiado para una alerta específica) (Presente en la carpeta Triage en la clase MonitoreoTiempo.java)

---
