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
}

/*
package controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import models.GestorProducto;
import models.Producto;

public class ProductoController {
    private static GestorProducto gestorp = new GestorProducto();
    
    public void guardarProducto(float precio, int peso, String nombre, LocalDate fecha){
        System.out.println("Producto enviado al controlador");
        Producto p = new Producto(precio,peso,nombre,fecha);
        gestorp.agregarProducto(p);
        System.out.println("Producto agregado correctamente");
    }
    
    public LinkedList<Producto> listarProductos(){
        return gestorp.listarProductos();
    }
}
*/