package proyecto.programacion;

import java.util.Scanner;

/**
 *
 * @author MauriRod
 */
public class Login extends Empleado {

    public Login() {
        super("Mauricio", "Rodríguez", 20012, 'M', 2001);

    }

    public void logearse() {
        Scanner rm = new Scanner(System.in);

        String name, pass, p = "tiendaPRO2022";
        int id, c = 0;

        System.out.println("Ingrese su nombre: ");
        name = rm.nextLine();

        System.out.println("Favor " + name + " ingrese su id: ");
        id = rm.nextInt();

        Scanner r = new Scanner(System.in);
        System.out.println("Ingrese contraseña brindada por la tienda: ");
        pass = r.nextLine();

        if (p.equals(pass)) {
            System.out.println("");
            System.out.println("Hola " + name + " con numero de identificación " + id);
            System.out.println("     Bienvenido al sistema de la tienda      ");
        } else {
            System.out.println("La contraseña es incorrecta");
            while (!pass.equals(p) && c <= 2) {
                System.out.println("");
                c++;
                System.out.println("Por favor, ingrese de nuevo la contraseña: ");
                pass = r.nextLine();

                if (p.equals(pass)) {
                    System.out.println("Hola " + name + " con numero de identificación " + id);
                    System.out.println("     Bienvenido al sistema de la tienda      ");
                    System.out.println("");
                    
                    break;
                }
                if (c == 2) {
                    System.out.println("Su sesión se ha bloqueado, intente en otro momento.");
                    break;
                }

            }
        }
    }

    public void registrarse() {
        Scanner mr = new Scanner(System.in);
        String nombre, apellido, edad, tel;

        System.out.println("Ingrese su nombre: ");
        nombre = mr.nextLine();
        System.out.println("Ingrese su apellido: ");
        apellido = mr.nextLine();
        System.out.println("Digite su edad: ");
        edad = mr.nextLine();
        System.out.println("Digite su número de teléfono: ");
        tel = mr.nextLine();
        System.out.println("");

        System.out.println("Su correo nuevo es: " + nombre.substring(0, 5).toLowerCase() + apellido.substring(0, 3).toLowerCase() + edad.charAt(0) + tel.substring(1, 3) + "@tiendaprogamer.com");
        System.out.println("Su nombre de usuario: " + nombre.substring(0, 5).toLowerCase() + apellido.substring(0, 3).toLowerCase());
        System.out.println("");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("¡Bienvenido " + nombre+ ", esperamos disfrutes de nuestros productos!" );
        System.out.println("A continuacion se te mostrará el menú");

    }
}
