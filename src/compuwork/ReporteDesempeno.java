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
public class ReporteDesempeno {
    private LocalDate fechaReporte;

    public ReporteDesempeno(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
    
    public void generarRepIndiv(Empleado empleado) {
        try{
            empleado.calcularDesempeno();
            System.out.println("-->===Fin de reporte invidivual de " + empleado.getNombre() + "===<--\n");
        } catch (Exception e){
            System.out.println("Error al generar el reporte de " + empleado.getNombre());
        }
    }
    
    public void generarRepDpto(Departamento dpto) {
        try {
            System.out.println("\n-->=== Reporte departamento " + dpto.getNombreDpto() + "===<--");
            for (Empleado e : dpto.getEmpleados()) {
                if (e != null) {                    
                    e.calcularDesempeno();                    
                }
            }
            System.out.println("-->===Fin de reporte de " + dpto.getNombreDpto() + "===<--\n");
        } catch (Exception e) {
            System.out.println("Error al procesar el reporte del departamento.");
        }
    }
}