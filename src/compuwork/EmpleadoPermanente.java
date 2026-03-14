/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork;
import java.time.LocalDate;

/**
 *
 * @author ljgarciao
 */
public class EmpleadoPermanente extends Empleado{
    private double bonoAntiguedad;
    private String beneficios;

    public EmpleadoPermanente(double bonoAntiguedad, String beneficios, int idEmpleado, String nombre, LocalDate fechaingreso) {
        super(idEmpleado, nombre, fechaingreso);
        this.bonoAntiguedad = bonoAntiguedad;
        this.beneficios = beneficios;
    }

    public double getBonoAntiguedad() {
        return bonoAntiguedad;
    }

    public void setBonoAntiguedad(double bonoAntiguedad) {
        try {            
            if (bonoAntiguedad < 0) {
                throw new Exception("El bono no puede ser negativo");
            }
            this.bonoAntiguedad = bonoAntiguedad;
        } catch (Exception e) {            
            System.out.println("Error en asignacion de bono.");
        }
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    
    //public 
    
    @Override
    public void calcularDesempeno(){
        System.out.println("-> Desempeno trabajador permanente: " + this.getNombre());
        System.out.println("--> Beneficios: " + beneficios + ", bono: " + bonoAntiguedad);
    }
}