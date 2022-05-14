package proyecto.programacion;

import java.util.Scanner;

public class Login extends Empleado {

    

    public void logearse() {
        Scanner datosEntra = new Scanner(System.in);

        String name="", contrasenha="", palabra = "hola";
        int id, contador = 0;
        
        try{
        System.out.println("Ingrese su nombre: ");
        name = datosEntra.nextLine();

        System.out.println("Favor " + name + " ingrese su id: ");
        id = datosEntra.nextInt();

        Scanner dtoContra = new Scanner(System.in);
        System.out.println("Ingrese contraseña brindada por la tienda: ");
        contrasenha = dtoContra.nextLine();
        

        if (palabra.equals(contrasenha)) {
            System.out.println("");
            System.out.println("Hola " + name + " con numero de identificación " + id);
            System.out.println("     Bienvenido al sistema de la tienda      ");
        } else {
            System.out.println("La contraseña es incorrecta");
            while (!contrasenha.equals(palabra) && contador <= 2) {
                System.out.println("");
                contador++;
                System.out.println("Por favor, ingrese de nuevo la contraseña: ");
                contrasenha = dtoContra.nextLine();

                if (palabra.equals(contrasenha)) {
                    System.out.println("Hola " + name + " con numero de identificación " + id);
                    System.out.println("     Bienvenido al sistema de la tienda      ");
                    System.out.println("");

                    break;
                }
                if (contador == 2) {
                    System.out.println("Su sesión se ha bloqueado, intente en otro momento.");
                    break;
                }

            }
        }
      
    }catch(Exception e){
            System.out.println("El valor que introduciste no es valido");
            System.exit(0);
         }
    }

    public void registrarse() {
        Scanner dtoRegistro = new Scanner(System.in);
        String nombre="", apellido="", edad="", tel="";
        
        try{
            System.out.println("Ingrese su nombre: ");
            nombre = dtoRegistro.nextLine();
            System.out.println("Ingrese su apellido: ");
            apellido = dtoRegistro.nextLine();
            System.out.println("Digite su edad: ");
            edad = dtoRegistro.nextLine();
            System.out.println("Digite su número de teléfono: ");
            tel = dtoRegistro.nextLine();
            System.out.println(""); 
        }catch(Exception e){
            System.out.println("El valor que se introdujo no es valido...");
            System.exit(0);
        }


        try{
        System.out.println("Su correo nuevo es: " + nombre.substring(0, 5).toLowerCase() + apellido.substring(0, 3).toLowerCase() + edad.charAt(0) + tel.substring(1, 3) + "@tiendaprogamer.com");
        System.out.println("Su nombre de usuario: " + nombre.substring(0, 5).toLowerCase() + apellido.substring(0, 3).toLowerCase());
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("¡Bienvenido " + nombre + ", esperamos disfrutes de nuestros productos!");
        System.out.println("A continuacion se te mostrará el menú");

        }catch(Exception e){
            System.out.println("Los campos de entrada son :\n Nombre al menos 5 Caracteres\n Apellido al menos 3 caracteres\n Telefono 6 caracteres\n"
                    + "Si no cumplen complete el formato con numeros o caracteres especiales");
            //Para que el programa se cierre.
           System.exit(0);
        }

    }
}
