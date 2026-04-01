/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.LinkedList;

/**
 *
 * @author kobak
 */
public class GestorEmpleado{
    private LinkedList<Empleado> listaEmpleados;
    
    public GestorEmpleado(){
        listaEmpleados = new LinkedList<>();
    }
    
    //Create(crear): agregar empleado
    public void agregarEmpleado(Empleado empleado){
        listaEmpleados.add(empleado);
    }
    
    //Read(leer): listar empleados
    public LinkedList<Empleado> listarEmpleados(){
        return listaEmpleados;
    }
    
    //Read(buscar): Buscar empleado
    public Empleado buscarEmpleado(String nombre){
        for(Empleado p: listaEmpleados){
            if(p.getNombre().equals(nombre)){
                return p;
            }
        }
        return null;
    }
    
    public Empleado buscarEmpleadoID(int id){
        for(Empleado p: listaEmpleados){
            if (p.getIdEmpleado() == id){
                return p;
            }
        }
        return null;
    }
    
    //Update(actualizar): actualizar producto
    public boolean actualizarEmpleado(int id, Empleado nuevoEmpleado){
        for(int i=0; i<listaEmpleados.size(); i++){
            if(listaEmpleados.get(i).getIdEmpleado()==id){
                listaEmpleados.set(i,nuevoEmpleado);
                return true;                
            }
        }
        return false;
    }
    
    //Delete(eliminar): eliminar producto
    public boolean eliminarEmpleado(String nombre){
        for(int i=0; i<listaEmpleados.size(); i++){
            if(listaEmpleados.get(i).getNombre().equals(nombre)){
                listaEmpleados.remove(i);
                return true;                
            }
        }
        return false;
    }
    
    /*Delete(eliminar): eliminar empleado nivel experto
    public boolean eliminarEmpleado(String nombre){
        return listaEmpleados.removeIf(p->p.getNombre().equals(nombre));
    }*/    
}