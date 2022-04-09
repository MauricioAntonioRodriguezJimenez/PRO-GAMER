package proyecto.programacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProyectoProgramacion {

    public static void main(String[] args) {

        //Verificamos que haya una conexión con la base de datos
        conex();

        Scanner j = new Scanner(System.in);

        //Nos muestra un inicio de sesión para cliente o trabajador
        Login log = new Login();

        char trabajador, cliente;
        
        //Declaramos variables polimorficas de tipo objeto
        Software software[] = new Software[4];
        Hardware hardware[] = new Hardware[4];
        Empleado empleado[] = new Empleado[4];

        System.out.println("     Bienvenido/a      ");
        System.out.println("¿Eres cliente o trabajador?");
        System.out.println("Elije C o T");
        trabajador = j.nextLine().charAt(0);

        if (trabajador == 'T' || trabajador == 't') {
            log.logearse();

            int xr;
            //Menú para empleados

            do {
                xr = menu();
                switch (xr) {
                    case 1:
                        //En este case se agregan productos solo de software

                        String nombre,marca,modelo;
                        double precio;
                        int cantidad,codigo;

                        Scanner ds = new Scanner(System.in);
                        
                        System.out.println("*********************************");
                        System.out.println("   ADICIÓN PRODUCTO SOFTWARE       ");
                        System.out.println("*********************************");

                        System.out.println("Escribe el nombre del producto: ");
                        nombre = ds.nextLine();
                        System.out.println("Escribe la marca del producto: ");
                        marca = ds.nextLine();
                        System.out.println("Escribe el modelo del producto: ");
                        modelo = ds.nextLine();
                        System.out.println("Escribe el precio del producto: ");
                        precio = ds.nextDouble();
                        System.out.println("Escribe la cantidad: ");
                        cantidad = ds.nextInt();
                        System.out.println("Escribe el código: ");
                        codigo = ds.nextInt();
                        
                        //Instanciar los objetos con las variables polimorficas

                        Software softwareDatos = new Software(nombre, marca, modelo, precio, cantidad, codigo);
                        software[0] = softwareDatos;
                        System.out.println(software[0].Create(softwareDatos));

                        break;

                    case 2:
                        //En este case se muestran los productos solo de Software

                        List<Software> lista = new ArrayList<>(); 
                        //Instanciar los objetos con las variables polimorficas
                        Software softwareRead = new Software();
                        software[1] = softwareRead;
                        lista = software[1].readAll();
                        
                        
                        System.out.println("*Nombre*    " + "*Marca*    " + "*Modelo*   " + "*Precio*   " + "*Cantidad*  " + "*Codigo*");
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i).getNombre() + "       " + lista.get(i).getMarca() + "    " + lista.get(i).getModelo() + "      " + lista.get(i).getPrecio() + "      " + lista.get(i).getCantidad() + "          " + lista.get(i).getCodigo());
                        }
                        break;

                    case 3:
                        //En este case se buscan productos de software por precio

                        //Instanciar los objetos con las variables polimorficas
                        Software softwareBusca = new Software();
                        software[2] = softwareBusca;

                        List<Software> listas = new ArrayList<>();
                        Scanner dp = new Scanner(System.in);
                        Double precioS;
                        
                        System.out.println("*********************************");
                        System.out.println("   BUSQUEDA PRODUCTO SOFTWARE       ");
                        System.out.println("*********************************");
                        System.out.println("Digite el precio a buscar:");
                        
                        precioS = dp.nextDouble();
                        listas = software[2].Buscar(precioS);
                        System.out.println("*Nombre*    " + "*Marca*    " + "*Modelo*   " + "*Precio*   " + "*Cantidad*  " + "*Codigo*");
                        for (int i = 0; i < listas.size(); i++) {
                            System.out.println(listas.get(i).getNombre() + "       " + listas.get(i).getMarca() + "    " + listas.get(i).getModelo() + "      " + (int)listas.get(i).getPrecio() + "      " + listas.get(i).getCantidad() + "          " + listas.get(i).getCodigo());
                        }
                        
 
                        break;

                    case 4:
                        //En este case se usa para eliminar productos de software
                        
                        //Instanciar los objetos con las variables polimorficas
                        Software softwareDelete = new Software();

                        software[3] = softwareDelete;

                        Scanner xdc = new Scanner(System.in);

                        int dato;
                        
                        System.out.println("*********************************");
                        System.out.println("   ELIMINAR PRODUCTO SOFTWARE       ");
                        System.out.println("*********************************");
                        System.out.println("Digite el código del producto Software que desea eliminar");
                        dato = xdc.nextInt();
                        System.out.println(software[3].Delete(dato));
                        break;

                    //Apartir del caso 5, se hace lo mismo, solo que para la clase Hardware
                    case 5:
                        //Se agregan productos a la tabla Hardware
                        String nombres,marcas,modelos;
                        double precios;
                        int cantidades,codigos;
                        Scanner dh = new Scanner(System.in);
                        
                        System.out.println("*********************************");
                        System.out.println("   ADICIÓN PRODUCTO HARDWARE      ");
                        System.out.println("*********************************");

                        System.out.println("Escribe el nombre del producto: ");
                        nombres = dh.nextLine();
                        System.out.println("Escribe la marca del producto: ");
                        marcas = dh.nextLine();
                        System.out.println("Escribe el modelo del producto: ");
                        modelos = dh.nextLine();
                        System.out.println("Escribe el precio del producto: ");
                        precios = dh.nextDouble();
                        System.out.println("Escribe la cantidad: ");
                        cantidades = dh.nextInt();
                        System.out.println("Escribe el codigo: ");
                        codigos = dh.nextInt();

                        //Instanciar los objetos con las variables polimorficas
                        Hardware hardwareDatos = new Hardware(nombres, marcas, modelos, precios, cantidades, codigos);
                        hardware[0] = hardwareDatos;
                        System.out.println(hardware[0].Create(hardwareDatos));

                        break;
                    case 6:
                        //Se mustran los productos de la tabla Hardware
                      
                        List<Hardware> listaH = new ArrayList<>();
                        //Instanciar los objetos con las variables polimorficas
                        Hardware hardwareRead = new Hardware();
                        hardware[1] = hardwareRead;
                        listaH = hardware[1].readAll();
                        

                        System.out.println("*Nombre*    " + "*Marca*    " + "*Modelo*   " + "*Precio*   " + "*Cantidad*  " + "*Codigo*");
                        for (int i = 0; i < listaH.size(); i++) {
                            System.out.println(listaH.get(i).getNombre() + "   " + listaH.get(i).getMarca() + "      " + listaH.get(i).getModelo() + "        " + listaH.get(i).getPrecio() + "       " + listaH.get(i).getCantidad() + "          " + listaH.get(i).getCodigo());
                        }
                        
 

                        break;
                    case 7:
                        //Se buscan productos de hardware por precio
                        List<Hardware> listasH = new ArrayList<>();
                        Scanner ph = new Scanner(System.in);
                        Double precioH;
                        
                                                
                        System.out.println("*********************************");
                        System.out.println("   BUSQUEDA PRODUCTO HARDWARE      ");
                        System.out.println("*********************************");

                        System.out.println("Digite el precio a buscar:");
                        precioH = ph.nextDouble();
                        //Instanciar los objetos con las variables polimorficas
                        Hardware hardwareBusca = new Hardware();
                        hardware[2] = hardwareBusca;
                        listasH = hardware[2].Buscar(precioH);
                        System.out.println("*Nombre*    " + "*Marca*    " + "*Modelo*   " + "*Precio*   " + "*Cantidad*  " + "*Codigo*");
                        for (int i = 0; i < listasH.size(); i++) {
                            System.out.println(listasH.get(i).getNombre() + "   " + listasH.get(i).getMarca() + "      " + listasH.get(i).getModelo() + "        " + listasH.get(i).getPrecio() + "       " + listasH.get(i).getCantidad() + "          " + listasH.get(i).getCodigo());
                        }


                        break;
                    case 8:
                        //Se eliminan productos de Hardware
                        Scanner xdel = new Scanner(System.in);
                        int datos;
                        
                                                
                        System.out.println("*********************************");
                        System.out.println("   ELIMINACION PRODUCTO HARDWARE  ");
                        System.out.println("*********************************");

                        System.out.println("Digite el codigo del producto que desea eliminar");
                        datos = xdel.nextInt();
                        //Instanciar los objetos con las variables polimorficas
                        Hardware hardwareDelete = new Hardware();
                        hardware[3] = hardwareDelete;
                        System.out.println(hardware[3].Delete(datos));
                        break;
                        
                    //Apartir de este case, se comeinzan agregar los empleados a su tabla en la Base de Datos    
                    case 9:
                        //Agregar empleados
                        String nombreE,apellido;
                        char sexo;
                        int fecha,ID;
                        Scanner de = new Scanner(System.in);
                        
                                                
                        System.out.println("*********************************");
                        System.out.println("   ADICION DE EMPLEADO           ");
                        System.out.println("*********************************");
                        System.out.println("Escribe el nombre del empleado: ");
                        nombreE = de.nextLine();
                        System.out.println("Escribe el apellido del empleado: ");
                        apellido = de.nextLine();
                        System.out.println("Escribe su ID: ");
                        ID = de.nextInt();
                        de.nextLine();
                        System.out.println("Escriba su sexo:    \n(M o F)");
                        sexo = de.next().charAt(0);
                        System.out.println("Escriba su año de nacimiento: ");
                        fecha = de.nextInt();

                        Empleado empleadoDatos = new Empleado(nombreE, apellido, ID, sexo, fecha);
                        empleado[0] = empleadoDatos;
                        System.out.println(empleado[0].Create(empleadoDatos));
                        break;
                        
                    case 10:
                        //Mostrar lista de empleados
                        List<Empleado> list = new ArrayList<>();
                        //Instanciar los objetos con las variables polimorficas
                        Empleado listaE = new Empleado();
                        empleado[1] = listaE;
                        list = empleado[1].readAll();

                        System.out.println(" *Nombre* " + "  " + " *Apellido* " + "  " + " *ID* " + "  " + " *Sexo* " + "  " + "   *Edad* ");
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i).getNombre() + "       " + list.get(i).getApellido() + "      " + list.get(i).getID() + "      " + list.get(i).getSexo() + "    " + list.get(i).getEdad());
                        }
      
                        break;
                    case 11:
                        //Buscar empleados por ID
                        List<Empleado> listE = new ArrayList<>();
                        Scanner ide = new Scanner(System.in);
                        int Idbusca;
                        
                                                                        
                        System.out.println("*********************************");
                        System.out.println("   BUSQUEDA DE EMPLEADO           ");
                        System.out.println("*********************************");

                        System.out.println("Digite el ID a buscar:");                        
                        Idbusca = ide.nextInt();
                        //Aplicacion de un cast
                        double b = Double.valueOf(Idbusca);
                        Empleado empb = new Empleado();
                        empleado[2] = empb;
                        listE = empleado[2].Buscar(Idbusca);
                        System.out.println(" *Nombre* " + "  " + " *Apellido* " + "  " + " *ID* " + "  " + " *Sexo* " + "  " + "   *Edad* ");
                        for (int i = 0; i < listE.size(); i++) {
                            System.out.println(listE.get(i).getNombre() + "       " + listE.get(i).getApellido() + "      " + listE.get(i).getID() + "      " + listE.get(i).getSexo() + "    " + listE.get(i).getEdad());
                        }
                        break;
                    case 12:
                        //Eliminacion por ID
                        //Instanciar los objetos con las variables polimorficas
                        Empleado empleadoD = new Empleado();
                        empleado [3] = empleadoD;
                        Scanner del = new Scanner(System.in);
                        int ids;
                        
                                                                        
                        System.out.println("*********************************");
                        System.out.println("   ELIMINACION DE EMPLEADO           ");
                        System.out.println("*********************************");

                        System.out.println("Digite el ID del empleado que desea eliminar");
                        ids = del.nextInt();
                        System.out.println(empleado[3].Delete(ids));

                        break;
                    case 13:
                        System.out.println("¡Gracias por la preferencia, vuelva pronto!");
                        break;
                }

            } while (xr != 13);

        } else {
            System.out.println("¿Deseas registrarse con nosotros?");
            System.out.println("\tSí o No");
            cliente = j.nextLine().charAt(0);
            if (cliente == 'S' || cliente == 's') {
                log.registrarse();

                int xrj;
                Scanner s = new Scanner(System.in);
                ArrayList listaProductos = new ArrayList();
                listaProductos.add("Intel i5 2400");
                listaProductos.add("SSD 500 GB");
                listaProductos.add("Memoria RAM 8 GB");
                listaProductos.add("NVIDIA GTX1660");
                listaProductos.add("Teclado K16");

                do {
                    xrj = menuC();
                    switch (xrj) {
                        case 1:
                            //Agregar producto en arreglos
                            System.out.println("Esta es la lista de Productos: " + listaProductos.toString());
                            System.out.println("Agregue un Producto Nuevo: ");
                            String nuevoProducto = s.nextLine();
                            listaProductos.add(0, nuevoProducto);
                            System.out.println("La lista actualizada: " + listaProductos.toString());

                            break;

                        case 2:
                            //Editar producto

                            String editarProducto;
                            int lugar;
                            System.out.println("Esta es la lista de Prodcutos: " + listaProductos.toString());

                            System.out.println("Ingrese la posición del Producto: ");
                            lugar = s.nextInt();
                            lugar = lugar - 1;
                            Scanner editar = new Scanner(System.in);
                            System.out.println("Ingrese el cambio al Producto: ");
                            editarProducto = editar.nextLine();
                            listaProductos.set(lugar, editarProducto);
                            System.out.println("Lista de productos actualizada: " + listaProductos.toString());

                            break;

                        case 3:
                            // Eliminar productos

                            System.out.println("Lista de Productos: " + listaProductos.toString());
                            System.out.println("Ingrese el producto que desea eliminar: ");
                            String eliminado = s.nextLine();
                            if (listaProductos.remove(eliminado)) {
                                System.out.println("Lista Actualizada: " + listaProductos.toString());
                            } else {
                                System.out.println("Ese Producto no existe en la lista");
                            }
                            break;

                        case 4:
                            //VER ID ordenados

                            int posicion;

                            int IDEmpleado[] = {3320, 78393, 2332, 1113, 432, 2212, 4422};
                            System.out.println("Lista de los ID de nuestros empleados :" + Arrays.toString(IDEmpleado));
                            IDEmpleado = ordenBurbujas(IDEmpleado);
                            System.out.println("Lista de los ID ordenados :" + Arrays.toString(IDEmpleado));
                            break;

                        case 5:
                            //Ver precios ordenados
                            double posicion2;
                            System.out.println("");
                            double precios[] = {55.60, 253.25, 49.99, 735.95, 74.99};
                            System.out.println("Lista de precios :" + Arrays.toString(precios));
                            precios = ordenSeleccion(precios);
                            System.out.println("Lista de los precios ordenados :" + Arrays.toString(precios));

                            break;
                        case 6:
                            //Busqueda de ID
                            int posicions;
                            int IDEmpleados[] = {3320, 78393, 2332, 1113, 432, 2212, 4422};
                            IDEmpleados = ordenBurbujas(IDEmpleados);
                            System.out.println("Ingresa un ID a buscar:");
                            posicions = s.nextInt();
                            if (busquedaBinaria(IDEmpleados, posicions) == -1) {
                                System.out.println("EL ID que busca no existe! ");
                            } else {
                                System.out.println("El ID que busca se encuentra en la posición " + busquedaBinaria(IDEmpleados, posicions));
                            }
                            break;
                        case 7:
                            //Busqueda de precios
                            double pos;
                            System.out.println("");
                            double precio[] = {55.60, 253.25, 49.99, 735.95, 74.99};
                            precio = ordenSeleccion(precio);
                            System.out.println("Ingresa un precio a buscar:");
                            pos = s.nextDouble();
                            if (busquedaBinariaDouble(precio, pos) == -1) {
                                System.out.println("El precio no existe! ");
                            } else {
                                System.out.println("El precio que busca se encuentra en la posicion " + busquedaBinariaDouble(precio, pos));
                            }
                            break;
                        case 8:

                            Tecnico opc = new Tecnico();
                            opc.preciosServicio();
                            break;
                        case 9:
                            System.out.println("¡Gracias por la preferencia, vuelva pronto!");
                            break;

                    }

                } while (xrj != 9);

            } else {
                System.out.println("Lo sentimos, debes asociarte con nostros primero.");

            }

        }

    }

    public static double[] ordenSeleccion(double[] a) {
        int indiceMenor, n;
        n = a.length;
        for (int i = 0; i < n - 1; i++) {
            indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            double temp = a[i];
            if (i != indiceMenor) {
                a[i] = a[indiceMenor];
                a[indiceMenor] = temp;
            }

        }
        return a;
    }

    public static int busquedaBinaria(int[] a, int clave) {

        int central, alto, bajo;
        int valorCentral;
        bajo = 0;
        alto = a.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            valorCentral = a[central];
            if (clave == valorCentral) {
                return central;
            } else if (clave < valorCentral) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }

        }

        return -1;

    }

    public static int[] ordenBurbujas(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int busquedaBinariaDouble(double[] a, double clave) {

        int central, alto, bajo;
        double valorCentral;
        bajo = 0;
        alto = a.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2;
            valorCentral = a[central];
            if (clave == valorCentral) {
                return central;
            } else if (clave < valorCentral) {
                alto = central - 1;
            } else {
                bajo = central + 1;
            }

        }

        return -1;
    }

    //Menu para empleados, mejorar codigo en consola
    public static int menu() {
        int x;
        Scanner n = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\t\tMENÚ INICIAL \nSeleccione un número \n1.Agregar un Producto Software \t2.Mostar Productos Software \n3.Buscar Software por Precio \t4.Eliminar Producto Software \n5.Agregar producto Hardware \t6.Mostrar productos de Hardware \n7.Busqueda productos Hardware \t8.Eliminar producto Hardware \n9. Agregar empleado nuevo \t10.Mostrar lista de empleados \n11.Buscar empleados por ID \t12.Eliminar empleado por ID  \n13.Salir del menú  \n\t\t\t\t\t\t\tModo Empleado");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Opción seleccionada: ");
        x = n.nextInt();
        System.out.println("---------------------------------------------------------------------");
        return x;
    }

    //Menu para clientes, codigo en consola
    public static int menuC() {
        int xrj;
        Scanner n = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\t\tMENÚ INICIAL \nSeleccione un número  \n1.Agregar Productos \t2.Editar productos \n3.Eliminar Productos \t4.Ver ID ordenados \n5.Ver orden de precios \t6.Busqueda de ID \n7.Busqueda de precios \t8.Solicitar Servicio Tecnico\n9.Salir del menú  \n\t\t\t\t\t\t\tModo Cliente");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Opción seleccionada: ");
        xrj = n.nextInt();
        System.out.println("---------------------------------------------------------------------");
        return xrj;
    }

    //Prueba de Conexion
    public static void conex() {
        if (Conectar.getConexion() != null) {
            System.out.println("Conexión a Base de Datos, ha sido correcta");
        } else {
            System.out.println("No se ha podido conectar a la base de datos");
        }
    }
}
