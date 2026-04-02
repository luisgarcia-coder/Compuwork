/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ljgarciao
 */
import models.GestorEmpleado;
import models.Empleado;
import models.EmpleadoPermanente;
import models.EmpleadoTemporal;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestorEmpleadoTest {
    
    @Test
    public void testGuardarListar(){
        //Instanciamos gestor
        GestorEmpleado gestor = new GestorEmpleado();
        LocalDate fecha = LocalDate.now();
        
        //Creamos dos empleados, uno permanente y uno temporal
        Empleado e = new EmpleadoPermanente(500,"Seguros",1,"Luis",fecha);
        Empleado em = new EmpleadoTemporal(fecha.plusMonths(1),2,"Javier",fecha);
        
        //Agregamos ambos empleados
        gestor.agregarEmpleado(e);
        gestor.agregarEmpleado(em);
        
        //Uso de los asserts
        //Verificación que se guardan en total 2 empleados
        assertEquals("La lista debe tener 2 empleados",2,gestor.listarEmpleados().size());
        
        //Verificación que el primer empleado es permanente y el segundo temporal
        assertTrue("Primer empleado debe ser permanente",gestor.listarEmpleados().get(0) instanceof EmpleadoPermanente);
        assertTrue("Segundo empleado debe ser temporal",gestor.listarEmpleados().get(1) instanceof EmpleadoTemporal);
    }
}