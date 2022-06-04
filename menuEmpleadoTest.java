import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;
import org.junit.*;
import proyecto.programacion.Empleado;
import proyecto.programacion.Hardware;
import proyecto.programacion.Software;
import proyecto.programacion.Tecnico;


public class menuEmpleadoTest {

    @Test
    public void testAdicionSoftware() {

        System.out.println("Adicion de Producto Software");

        String nombre = "Windows 10", marca = "Microsoft", modelo = "PRO";
        double precio = 19.99;
        int cantidad = 20, codigo = 12345;

        Software softwareDatos = new Software(nombre, marca, modelo, precio, cantidad, codigo);

        int expResult = 1;
        int Result = new Software().Create(softwareDatos);
        assertEquals(expResult, Result);
    }

    @Test
    public void testAdicionHardware() {

        System.out.println("Adicion de Producto Hardware");

        String nombres = "Procesador", marcas = "Intel", modelos = "i5";
        double precios = 149.99;
        int cantidades = 10, codigos = 1998;

        Hardware hardwareDatos = new Hardware(nombres, marcas, modelos, precios, cantidades, codigos);

        int expResult = 1;
        int Result = new Hardware().Create(hardwareDatos);
        assertEquals(expResult, Result);
    }

    @Test
    public void testAdicionEmpleado() {

        System.out.println("Adicion de Empleado a la Empresa");

        String nombre = "Juan", apellido = "Perez";

        int ID = 123, fecha = 2000;
        char sexo = 'M';

        Empleado empleadoDatos = new Empleado(nombre, apellido, ID, sexo, fecha);

        int expResult = 1;
        int Result = new Empleado().Create(empleadoDatos);
        assertEquals(expResult, Result);
    }

    @Test
    public void testEliminacionSoftware() {
        System.out.println("Eliminacion de Producto Software");

        int expResult = 1;
        int Result = new Software().Delete(0);
        assertEquals(expResult, Result);
    }

    @Test
    public void testEliminacionHardware() {
        System.out.println("Eliminacion de Producto Hardware");

        int expResult = 1;
        int Result = new Hardware().Delete(0);
        assertEquals(expResult, Result);
    }

    @Test
    public void testEliminacionEmpleado() {
        System.out.println("ID de empleado Eliminado con Exito");
        

        int expResult = 1;
        int Result = new Empleado().Delete(0);
        assertEquals(expResult, Result);
    }

    @Test
    public void testreadAllSoftware() {
        System.out.println("Mostar Producto");

        Object expResult = null;
        List Result = new Software().readAll();
        assertEquals(expResult, Result);
    }
    @Test
    public void testreadAllHardware() {
        System.out.println("Mostar Producto");

        Object expResult = null;
        List Result = new Hardware().readAll();
        assertEquals(expResult, Result);
    }
    
    @Test
    public void testreadAllEmpleado() {
        System.out.println("Mostar Producto");

        Object expResult = null;
        List Result = new Empleado().readAll();
        assertEquals(expResult, Result);
    }

    @Test
    public void testpreciosServicios() {
        System.out.println("Mostrar precios de servicios tecnicos");
        int caso=100;
        int expResult = 35;
        int Result= Tecnico.preciosServicio(caso);
        assertEquals(expResult, Result);
        

    }

}
