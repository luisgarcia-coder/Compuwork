/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compuwork;
import java.util.LinkedList;

/**
 *
 * @author ljgarciao
 */
public class Departamento {
    private int idDpto;
    private String nombreDpto;
    private LinkedList<Empleado> empleados;

    public Departamento(int idDpto, String nombreDpto, LinkedList<Empleado> empleados) {
        this.idDpto = idDpto;
        this.nombreDpto = nombreDpto;
        this.empleados = new LinkedList<>();
    }

    public int getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(LinkedList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void agregarEmpleado(Empleado emp, LinkedList<Departamento> todosDpto) {
        try {
            if (emp == null) {
               throw new Exception("El empleado es nulo");
            }
            for (Departamento d:todosDpto){
                if (d.getEmpleados().contains(emp)){
                    throw new Exception("ERROR: " + emp.getNombre() + " ya se encuentra asignado a " + d.getNombreDpto());
                }
            }
            this.empleados.add(emp);
            System.out.println("Asignacion exitosa: " + emp.getNombre() + " en: " + nombreDpto);            
        } catch (Exception e) {
            System.out.println("Error en la asignacion.");
        }
    }
    
    public void listarEmpleados() {
        System.out.println("Empleados del departamento " + nombreDpto + ":");
        for (Empleado e:this.empleados) {
            if (e != null){
                System.out.println("- " + e.getNombre());
            }else{
                System.out.println("- Registro nulo.");
            }            
        }
    }
    
    public void eliminarEmpleado(Empleado emp) {
        try {
            if (emp == null) {
                throw new Exception("No se puede eliminar un objeto nulo.");
            }
            boolean eliminado = this.empleados.remove(emp);

            if (eliminado) {             
                System.out.println("LOG: Empleado " + emp.getNombre() + " eliminado de " + this.nombreDpto);
            } else {
                System.out.println("ADVERTENCIA: El empleado no se encontraba en este departamento.");
            }
        } catch (Exception e) {
            System.out.println("Error al intentar eliminar.");
        }
    }
    
    public void vaciarDpto() {
        try {
            System.out.println("Vaciando " + this.nombreDpto + "...");            
            this.empleados.clear(); 
        } catch (Exception e) {
            System.out.println("Error al vaciar.");
        }
    }
}