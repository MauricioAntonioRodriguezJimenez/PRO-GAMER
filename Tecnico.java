package proyecto.programacion;

public class Tecnico extends Empleado {

     public Tecnico() {

        super("Gabriel", "Lemus", 20012, 'M', 2001);
    }
    private double precio;
    
    public void preciosServicio() {

        int opcion = 0;


        System.out.println("Opciones de Servicio:");
        System.out.println("1- Limpieza de componentes de un equipo");
        System.out.println("2- Revision por algun o falla del Sistema");
        System.out.println("3- Reparacion de equipo dañado");
        System.out.println("4- Optimizacion del Sistema Operativo");

        switch (opcion) {
            case 1:
                precio = 25;
                System.out.println("El servicio de limpieza tendra un costo de $" + precio);
                break;
            case 2:
                precio =30;
                System.out.println("El servicio de revision tendra un costo de $" + precio);
                break;
            case 3:
                precio = 80;
                System.out.println("El servicio de reparacion tendra un costo de $" + precio);
                break;
            case 4:
                precio = 25;
                System.out.println("El servicio de optimizacion tendra un costo de $" + precio);
                break;
            default:
                System.out.println("Esa opcion de servicio no existe");
                break;
        }


    }
}
