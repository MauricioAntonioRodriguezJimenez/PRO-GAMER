package proyecto.programacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuCliente {

    //Menu para clientes, codigo en consola
    public static int opcionesmenuC() {
        int opClientes;
        Scanner n = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\t\tMENÚ INICIAL \nSeleccione un número  \n1.Agregar Productos \t2.Editar productos \n3.Eliminar Productos \t4.Ver ID ordenados \n5.Ver orden de precios \t6.Busqueda de ID \n7.Busqueda de precios \t8.Solicitar Servicio Tecnico\n9.Salir del menú  \n\t\t\t\t\t\t\tModo Cliente");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Opción seleccionada: ");
        opClientes = n.nextInt();
        System.out.println("---------------------------------------------------------------------");
        return opClientes;
    }
    public static void menuCliente() {

        int opCliente;
        Scanner datosEntrad = new Scanner(System.in);
        ArrayList listaProductos = new ArrayList();
        listaProductos.add("Intel i5 2400");
        listaProductos.add("SSD 500 GB");
        listaProductos.add("Memoria RAM 8 GB");
        listaProductos.add("NVIDIA GTX1660");
        listaProductos.add("Teclado K16");

        do {
            opCliente = opcionesmenuC();
            switch (opCliente) {
                case 1:
                    //Agregar producto en arreglos
                    try{
                    System.out.println("Esta es la lista de Productos: " + listaProductos.toString());
                    System.out.println("Agregue un Producto Nuevo: ");
                    String nuevoProducto = datosEntrad.nextLine();
                    listaProductos.add(0, nuevoProducto);
                    System.out.println("La lista actualizada: " + listaProductos.toString());
                    }catch(Exception e){
                        System.out.println("No se pudo agregar el producto porque el dato no es valido");
                    }

                    break;
                case 2:
                    //Editar producto

                    String editarProducto;
                    int lugar;
                    try{
                    System.out.println("Esta es la lista de Productos: " + listaProductos.toString());
                    System.out.println("Ingrese la posición del Producto: ");
                    lugar = datosEntrad.nextInt();
                    lugar = lugar - 1;
                    Scanner editar = new Scanner(System.in);
                    System.out.println("Ingrese el cambio al Producto: ");
                    editarProducto = editar.nextLine();
                    listaProductos.set(lugar, editarProducto);
                    System.out.println("Lista de productos actualizada: " + listaProductos.toString());
                    }catch(Exception e){
                        System.out.println("No se pudo editar la lista por el ingreso de un dato invalido");
                    }

                    break;

                case 3:
                    // Eliminar productos

                    try{
                    System.out.println("Lista de Productos: " + listaProductos.toString());
                    System.out.println("Ingrese el producto que desea eliminar: ");
                    String eliminado = datosEntrad.nextLine();
                    if (listaProductos.remove(eliminado)) {
                        System.out.println("Lista Actualizada: " + listaProductos.toString());
                    }else{
                        System.out.println("El producto que ingreso no existe en la lista");
                    }
                    }catch(Exception e){
                         System.out.println("El dato que se ingreso no es valido para laeliminacion");
                    }
                    break;

                case 4:
                    //VER ID ordenados

                    //int posicion; //<---- Revisar
                    int IDEmpleado[] = {3320, 78393, 2332, 1113, 432, 2212, 4422};
                    System.out.println("Lista de los ID de nuestros empleados :" + Arrays.toString(IDEmpleado));
                    IDEmpleado = Ordenamiento.ordenBurbujas(IDEmpleado);
                    System.out.println("Lista de los ID ordenados :" + Arrays.toString(IDEmpleado));
                    break;

                case 5:
                    //Ver precios ordenados

                    //double posicion2; //<---- Revisar
                    System.out.println("");
                    double precios[] = {55.60, 253.25, 49.99, 735.95, 74.99};
                    System.out.println("Lista de precios :" + Arrays.toString(precios));
                    precios = Ordenamiento.ordenSeleccion(precios);
                    System.out.println("Lista de los precios ordenados :" + Arrays.toString(precios));

                    break;
                case 6:
                    //Busqueda de ID
                    int posicions;
                    int IDEmpleados[] = {3320, 78393, 2332, 1113, 432, 2212, 4422};
                    IDEmpleados = Ordenamiento.ordenBurbujas(IDEmpleados);
                    try{
                    System.out.println("Ingresa un ID a buscar:");
                    posicions = datosEntrad.nextInt();
                    if (Busqueda.busquedaBinaria(IDEmpleados, posicions) == -1) {
                        System.out.println("EL ID que busca no existe! ");
                    } else {
                        System.out.println("El ID que busca se encuentra en la posición " + Busqueda.busquedaBinaria(IDEmpleados, posicions));
                    }
                    }catch(Exception e){
                        System.out.println("El dato que se ingreso no es valido para la busqueda");
                    }
                    break;
                case 7:
                    //Busqueda de precios
                    double pos;
                    System.out.println("");
                    try{
                    double precio[] = {55.60, 253.25, 49.99, 735.95, 74.99};
                    precio = Ordenamiento.ordenSeleccion(precio);
                    System.out.println("Ingresa un precio a buscar:");
                    pos = datosEntrad.nextDouble();
                    if (Busqueda.busquedaBinariaDouble(precio, pos) == -1) {
                        System.out.println("El precio no existe! ");
                    } else {
                        System.out.println("El precio que busca se encuentra en la posicion " + Busqueda.busquedaBinariaDouble(precio, pos));
                    }
                    }catch(Exception e){
                        System.out.println("El dato que ingreso no es valido para realizar la busqueda");
                    }
                    break;
                case 8:
                    Tecnico tecnico = new Tecnico();
                    tecnico.preciosServicio();
                    break;
                case 9:
                    System.out.println("¡Gracias por la preferencia, vuelva pronto!");
                    break;
                default:
                    break;

            }

        } while (opCliente != 9);
    }
}
