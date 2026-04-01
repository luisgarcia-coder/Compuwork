/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author ljgarciao
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private LocalDate fechaingreso;

    public Empleado(int idEmpleado, String nombre, LocalDate fechaingreso) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.fechaingreso = fechaingreso;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        try {
            this.idEmpleado = idEmpleado;            
        } catch (Exception e){
            System.out.println("Tipo de dato incorrecto, debe ser un número entero." + e.getMessage());
        }        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(LocalDate fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
    public void calcularDesempeno() {
        System.out.println("Calcular desempeno para " + nombre);
    }
}