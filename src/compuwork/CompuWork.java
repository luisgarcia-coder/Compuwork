/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compuwork;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Set;
/**
 *
 * @author ljgarciao
 */
public class CompuWork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Empleado> empleados = new LinkedList<>();
                
        //Creación departamentos
        Departamento sistemas = new Departamento(10, "Sistemas", empleados);
        Departamento contabilidad = new Departamento(20, "Contabilidad", empleados);
        Departamento logistica = new Departamento(30, "Logistica", empleados);
        Departamento gerencia = new Departamento(40, "Gerencia", empleados);
        
        //Lista para validar departamentos
        LinkedList<Departamento> dptos = new LinkedList<>();
        dptos.add(sistemas);
        dptos.add(contabilidad);
        dptos.add(logistica);
        dptos.add(gerencia);
        
        //Creación empleados
        EmpleadoPermanente emp1 = new EmpleadoPermanente(1000000, "Paquete premium", 101, "Juan", LocalDate.of(2021, 1, 1));
        EmpleadoPermanente emp2 = new EmpleadoPermanente(500000, "Paquete deluxe", 102, "Pedro", LocalDate.of(2023, 1, 1));
        EmpleadoPermanente emp3 = new EmpleadoPermanente(250000, "Paquete estandar", 103, "Marcela", LocalDate.of(2025, 1, 1));
        EmpleadoPermanente emp4 = new EmpleadoPermanente(0, "Sin beneficios", 104, "Sara", LocalDate.of(2026, 1, 1));
        EmpleadoTemporal emp5 = new EmpleadoTemporal(LocalDate.of(2026, 6, 30), 105, "Carlos", LocalDate.of(2024, 6, 1));
        EmpleadoTemporal emp6 = new EmpleadoTemporal(LocalDate.of(2025, 12, 31), 106, "Lucia", LocalDate.of(2025, 2, 15));
        EmpleadoPermanente emp7 = new EmpleadoPermanente(300000, "Bonificacion salud", 107, "Ricardo", LocalDate.of(2020, 11, 20));
        EmpleadoTemporal emp8 = new EmpleadoTemporal(LocalDate.of(2027, 01, 01), 108, "Elena", LocalDate.of(2025, 03, 01));
        EmpleadoPermanente emp9 = new EmpleadoPermanente(150000, "Auxilio transporte", 109, "Fernando", LocalDate.of(2022, 8, 12));
        
        System.out.println("=== PRUEBAS DE FUNCIONALIDAD COMPUWORK ===\n");
        
        //Gestión de errores controlados
        //Error en EmpleadoPermanente con bono negativo
        System.out.println("--- Prueba 1: Bono negativo en Permanente ---");
        emp1.setBonoAntiguedad(-100);
        
        //Error en Departamento con null como parámetro
        System.out.println("\n--- Prueba 2: Asignacion de empleado nulo ---");
        sistemas.agregarEmpleado(null,dptos);
        
        //Asignación de empleados a los departamentos
        System.out.println("\n--- Prueba 3: Asignaciones correctas ---");
        sistemas.agregarEmpleado(emp1,dptos);
        sistemas.agregarEmpleado(emp1,dptos); //Error por mismo dpto
        contabilidad.agregarEmpleado(emp1,dptos); //Error por otro dpto
        sistemas.agregarEmpleado(emp2,dptos);
        contabilidad.agregarEmpleado(emp3,dptos);
        contabilidad.agregarEmpleado(emp4,dptos);
        logistica.agregarEmpleado(emp5,dptos);
        logistica.agregarEmpleado(emp6,dptos);
        gerencia.agregarEmpleado(emp7,dptos);
        gerencia.agregarEmpleado(emp8,dptos);
        sistemas.agregarEmpleado(emp9,dptos);
        
        //Reportería
        System.out.println("\n--- Prueba 4: Generacion de Reportes (Polimorfismo) ---");
        // El mismo método recibe diferentes tipos de empleados y sabe qué hacer
        ReporteDesempeno repInd = new ReporteDesempeno(LocalDate.now());
        repInd.generarRepIndiv(emp1);
        repInd.generarRepIndiv(emp5);
        repInd.generarRepIndiv(emp2);
        repInd.generarRepIndiv(emp6);
        
        // El mismo método recibe diferentes tipos de departamentos y sabe qué hacer
        ReporteDesempeno repDpto = new ReporteDesempeno(LocalDate.now());
        repDpto.generarRepDpto(sistemas);
        repDpto.generarRepDpto(contabilidad);
        repDpto.generarRepDpto(logistica);
        repDpto.generarRepDpto(gerencia);
        
        System.out.println("\n--- Prueba 5: Listado de Departamento ---");
        System.out.println("\nTotal empleados en " + sistemas.getNombreDpto() + ": " + sistemas.getEmpleados().size());
        sistemas.listarEmpleados();
        System.out.println("\nTotal empleados en " + contabilidad.getNombreDpto() + ": " + contabilidad.getEmpleados().size());
        contabilidad.listarEmpleados();
        System.out.println("\nTotal empleados en " + logistica.getNombreDpto() + ": " + logistica.getEmpleados().size());
        logistica.listarEmpleados();
        System.out.println("\nTotal empleados en " + gerencia.getNombreDpto() + ": " + gerencia.getEmpleados().size());
        gerencia.listarEmpleados();
        
        //Cambiar bono de 109, Fernando, de 150k a 200k
        emp9.setBonoAntiguedad(200000);
        
        //Cambiar a Pedro 102 de sistemas a gerencia
        System.out.println("\nPrueba de movimiento de Pedro de sistemas a gerencia");
        sistemas.getEmpleados().remove(emp2);
        gerencia.agregarEmpleado(emp2,dptos);        
        repDpto.generarRepDpto(sistemas);
        repDpto.generarRepDpto(gerencia);
        
        //Prueba de eliminación
        //Cuántos hay antes de eliminar en sistemas
        System.out.println("\nAntes de eliminar:");
        sistemas.listarEmpleados();
        //Eliminar un empleado específico: Juan - emp1
        sistemas.eliminarEmpleado(emp1);
        //Verificar que ya no aparece en la lista
        System.out.println("\nDespues de eliminar:");
        sistemas.listarEmpleados();
        
        //Modificar departamento
        sistemas.setNombreDpto("Tecnologia");
        System.out.println("\nNombre actualizado");
        sistemas.listarEmpleados();
        
        //Eliminar departamentos. Vaciar dpto y consultar el dpto
        System.out.println("\n\n");
        logistica.listarEmpleados();
        System.out.println("\n-->=== Iniciando eliminacion de departamento: logistica ===<--");
        logistica.vaciarDpto();
        dptos.remove(logistica);
        logistica = null;
        System.out.println("El departamento ha sido eliminado.");
        try {
            if (logistica == null) {
                throw new Exception("ERROR: El departamento consultado ya no existe en el sistema.");
            }
            logistica.listarEmpleados();
        } catch (Exception e) {            
            System.out.println("El departamento ha sido eliminado, asigne nuevo departamento a los empleados.");
        }
    }    
}