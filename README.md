# Sistema Hospitalario San Vicente

Aplicación de consola desarrollada en Java para simular el funcionamiento de un sistema hospitalario modular, con énfasis en el área de emergencias. Proyecto académico para la **Pontificia Universidad Javeriana**, desarrollado como parte del curso de **Análisis y Diseño de Software**.

Este sistema implementa principios de diseño SOLID y patrones como **Factory Method**, **Strategy** y **Observer**, integrando varios módulos que colaboran entre sí bajo una arquitectura estructurada y orientada a objetos.

---

## Integrantes del Proyecto
```
Daniel Felipe Ramírez Vargas
Nicolás Castañeda Vargas
Guillermo Aponte Cárdenas
María Fernanda Cruz Niño
```


---

## Usuarios Simulados que se pueden utilizar en la autenticacion

Los siguientes usuarios están habilitados para los módulos con control de acceso:

| Usuario      | Contraseña |
|--------------|------------|
| `admin`      | `admin`    |
| `medico1`    | `abcd`     |
| `enfermera1` | `pass`     |

---

## Estructura del Proyecto (Está dividida por 6 modulos y una clase Main que los conecta)
 ```
src/Hospital/
├── AdministracionDeRecursosMedicos/
│ ├── InterfaceGestionRecursos.java
│ ├── InterfaceSincronizacionTiempoReal.java
│ ├── InterfaceInterfazUsuario.java
│ ├── GestionRecursos.java
│ ├── SincronizacionTiempoReal.java
│ ├── InterfazUsuarioRecursos.java
│ └── MenuAdministracionDeRecursosMedicos.java

├── HistorialClinico/
│ ├── AutorizacionAcceso.java
│ ├── GestionAbandono.java
│ ├── HistorialClinico.java
│ ├── InterfaceAutorizacionAcceso.java
│ ├── InterfaceGestionAbandono.java
│ ├── InterfaceManejoHistorial.java
│ └── MenuHistorialClinico.java

├── Interfaz/
│ ├── CalculoPrioridades.java
│ ├── ConfiguracionDePantalla.java
│ ├── InterfaceCalculoPrioridades.java
│ ├── InterfaceConfiguracionDePantalla.java
│ ├── InterfaceVisualizacionPaciente.java
│ └── VisualizacionPaciente.java

├── MonitoreoDelSistemaSimulacion/
│ ├── Auditoria.java
│ ├── Autenticador.java
│ ├── InterfaceAuditoria.java
│ ├── InterfaceAutenticador.java
│ ├── InterfaceRegistroActividad.java
│ ├── MenuMonitoreo.java
│ ├── RegistroActividad.java
│ └── Seguridad.java

├── Registro/
│ ├── AutorizacionDeAcceso.java
│ ├── BusquedaDePacientes.java
│ ├── EditarPacientes.java
│ ├── IntegracionHistorialClinico.java
│ ├── InterfaceAutorizacionDeAcceso.java
│ ├── InterfaceBusquedaDePacientes.java
│ ├── InterfaceEditarPacientes.java
│ ├── InterfaceIntegracionHistorialClinico.java
│ ├── InterfaceRegistroPaciente.java
│ ├── MenuRegistro.java
│ ├── Paciente.java
│ └── RegistroPacienteFactory.java

├── Triage/
│ ├── ClasificarPrioridad.java
│ ├── InterfaceClasificarPrioridad.java
│ ├── InterfaceMonitoreoTiempo.java
│ ├── InterfaceValidacionDatos.java
│ ├── MenuTriage.java
│ ├── MonitoreoTiempo.java
│ └── ValidacionDatos.java

├── Main.java
 ```

---

## Módulos Implementados

### 1. Módulo de Interfaz
- Visualización de datos vitales, medicamentos y alergias.
- Escala de Glasgow, modo oscuro y configuración visual.
- Cálculo y visualización de prioridades.

### 2. Módulo de Registro
- Registro, consulta y edición de pacientes.
- Validaciones y detección de duplicados.
- Control de acceso y simulación de integración con historial clínico.

### 3. Módulo de Triage
- Clasificación de pacientes según signos vitales.
- Cálculo dinámico de prioridad (Strategy).
- Monitoreo del tiempo de espera con alertas (Observer).

### 4. Módulo de Administración de Recursos Médicos
- Registro y gestión de medicamentos e insumos.
- Filtrado por estado, historial de uso y control de stock.
- Sincronización simulada en tiempo real.

### 5. Módulo de Monitoreo del Sistema 
- **Este Módulo es unicamente una simulación y no registra los verdaderos accesos ni registros a los demás modulos**
- Registro de accesos, consultas y modificaciones por usuario.
- Búsqueda de logs, exportación simulada y validaciones de seguridad.
- Autenticación, bloqueo y trazabilidad del sistema.

### 6. Módulo de Historial Clínico
- Consulta y actualización de eventos clínicos por paciente.
- Registro de responsables, hora y tipo de operación.
- Simulación de autorización, acceso y abandono de sesión.

---

## Principios de Diseño Aplicados

- **SOLID:** Interfaces bien definidas, separación de responsabilidades.
- **Factory Method:** Creación de pacientes desde `RegistroPacienteFactory`.
- **Strategy:** Lógica de prioridad médica según los datos en `ValidacionDatos`.
- **Observer:** Sistema de alertas en el módulo de triaje (`MonitoreoTiempo`).

---

## Tecnologías y Herramientas

- Java SE 17
- Programación orientada a objetos
- Simulación de bases de datos con estructuras en memoria (`ArrayList`, `Map`)
- Diseño modular por paquetes
- Entrada y salida por consola

---

Este sistema demuestra cómo aplicar patrones de diseño y principios de arquitectura limpia para construir una simulacion de un sistema funcional, flexible y preparado para evolucionar hacia una versión más robusta y persistente.

