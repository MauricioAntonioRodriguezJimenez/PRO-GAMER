package proyecto.programacion;

import java.util.Scanner;

public class ProyectoProgramacion {

    public static void main(String[] args) {

        Scanner entradaDato = new Scanner(System.in);

        //Hacer la conexion con la base de Datos
        Conectar.pruebaConex();

        Login log = new Login();

        //Variables para el ingreso de diferentes menus
        char opcion, respuesta = 0;

        
            System.out.println("     Bienvenido/a      ");
            System.out.println("¿Eres cliente o trabajador?");
            System.out.println("Elije C o T");
            opcion = entradaDato.nextLine().toUpperCase().charAt(0);

            if (opcion == 'T') {
                //Se muestra en pantalla el login para acceder al menu
                log.logearse();
                //Se muestra el menu del trabajador
                menuEmpleado.menuTrabajador();

            } else if (opcion == 'C') {
                System.out.println("Primero debes registarte con nostros");
                System.out.println("¿Deseas crear una cuenta con nosotros?");
                System.out.println("\tSí o No");
                respuesta = entradaDato.nextLine().toUpperCase().charAt(0);

                if (respuesta == 'S') {
                    //Se muestra en pantalla un formulario para registrarse
                    log.registrarse();
                    //Se muestra el menú con los productos de la tienda.
                    MenuCliente.menuCliente();

                } else {

                    System.out.println("Lo sentimos, debes asociarte con nosotros primero.");
                    System.exit(0);
                }

            } else {
                System.out.println("Esa opcion no esta disponible....");
            }
        
        

    }

}

