/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalDate;

/**
 *
 * @author ljgarciao
 */
public class EmpleadoTemporal extends Empleado{
    private LocalDate fechaContrato;

    public EmpleadoTemporal(LocalDate fechaContrato, int idEmpleado, String nombre, LocalDate fechaingreso) {
        super(idEmpleado, nombre, fechaingreso);
        this.fechaContrato = fechaContrato;
    }

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        try {            
            if (fechaContrato == null) {
                throw new Exception("La fecha de contrato no puede ser nula");
            }
            this.fechaContrato = fechaContrato;
        } catch (Exception e) {            
            System.out.println("Error en fecha contrato");
        }
    }
    
    @Override
    public void calcularDesempeno() {
        System.out.println("-> Desempeno trabajador temporal: " + this.getNombre());
        System.out.println("--> El contrato finaliza el: " + fechaContrato);        
    }
}