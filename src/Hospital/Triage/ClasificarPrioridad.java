package Hospital.Triage;

import java.util.Scanner;

public class ClasificarPrioridad implements InterfaceClasificarPrioridad {
    private double temperatura;
    private int presionSistolica;
    private int presionDiastolica;
    private int saturacionOxigeno;
    private int escalaGlasgow;
    private int nivelDolor;

    @Override
    public void registrarSignosVitales() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Temperatura (°C): ");
        temperatura = scanner.nextDouble();
        System.out.print("Presión sistólica: ");
        presionSistolica = scanner.nextInt();
        System.out.print("Presión diastólica: ");
        presionDiastolica = scanner.nextInt();
        System.out.print("Saturación de oxígeno (%): ");
        saturacionOxigeno = scanner.nextInt();
        System.out.print("Escala de Glasgow (3-15): ");
        escalaGlasgow = scanner.nextInt();
        System.out.print("Nivel de dolor (1-10): ");
        nivelDolor = scanner.nextInt();
    }

    @Override
    public boolean validarRango() {
        return temperatura >= 30 && temperatura <= 45 &&
               presionSistolica >= 80 && presionSistolica <= 250 &&
               presionDiastolica >= 40 && presionDiastolica <= 150 &&
               saturacionOxigeno >= 50 && saturacionOxigeno <= 100 &&
               escalaGlasgow >= 3 && escalaGlasgow <= 15 &&
               nivelDolor >= 1 && nivelDolor <= 10;
    }

    // Getters para que las otras clases accedan a los datos
    public double getTemperatura() { return temperatura; }
    public int getPresionSistolica() { return presionSistolica; }
    public int getPresionDiastolica() { return presionDiastolica; }
    public int getSaturacionOxigeno() { return saturacionOxigeno; }
    public int getEscalaGlasgow() { return escalaGlasgow; }
    public int getNivelDolor() { return nivelDolor; }

}
