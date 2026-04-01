/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.time.LocalDate;
import java.util.LinkedList;
import models.Empleado;
import models.GestorEmpleado;

/**
 *
 * @author kobak
 */
public class EmpleadoController {
    private static GestorEmpleado gestore = new GestorEmpleado();
    
    public void guardarEmpleado(int idEmpleado, String nombre, LocalDate fechaIngreso){
        System.out.println("Empleado enviado al controlador");
        Empleado p = new Empleado(idEmpleado, nombre, fechaIngreso);
        gestore.agregarEmpleado(p);
        System.out.println("Empleado agregado correctamente");
    }
    
    public LinkedList<Empleado> listarEmpleado(){
        return gestore.listarEmpleados();
    }
    
    public Empleado buscarID(int Id){
        return gestore.buscarEmpleadoID(Id);
    }
    
    public Empleado buscarNombre(String nombre){
        return gestore.buscarEmpleado(nombre);
    }
}