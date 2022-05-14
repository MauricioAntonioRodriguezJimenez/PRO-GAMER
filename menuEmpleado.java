package proyecto.programacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class menuEmpleado {
    
    //Menu para empleados, mejora codigo en consola
    public static int opcionesmenuT() {
        int opTrbj;
        Scanner n = new Scanner(System.in);
        System.out.println("");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("\t\t\tMENÚ INICIAL \nSeleccione un número \n1.Agregar un Producto Software \t2.Mostar Productos Software \n3.Buscar Software por Precio \t4.Eliminar Producto Software \n5.Agregar producto Hardware \t6.Mostrar productos de Hardware \n7.Busqueda productos Hardware \t8.Eliminar producto Hardware \n9. Agregar empleado nuevo \t10.Mostrar lista de empleados \n11.Buscar empleados por ID \t12.Eliminar empleado por ID\n13.Servicios del Tecnico  \t14.Salir del menú  \n\t\t\t\t\t\t\tModo Empleado");
        System.out.println("---------------------------------------------------------------------");
        System.out.print("Opción seleccionada: ");
        opTrbj = n.nextInt();
        System.out.println("---------------------------------------------------------------------");
        return opTrbj;
    }

    public static void menuTrabajador() {

        Software software[] = new Software[4];
        Hardware hardware[] = new Hardware[4];
        Empleado empleado[] = new Empleado[4];

        int opEmp;
        //Menú para empleados

        do {
            opEmp = opcionesmenuT();
            switch (opEmp) {
                case 1:
                    //En este case se agregan productos solo de software

                    String nombre ="",
                    marca ="",
                    modelo="";
                    double precio = 0;
                    int cantidad =0,
                     codigo = 0;

                    Scanner sftwAdicion = new Scanner(System.in);

                    System.out.println("*********************************");
                    System.out.println("   ADICIÓN PRODUCTO SOFTWARE       ");
                    System.out.println("*********************************");
                    
                    try{

                    System.out.println("Escribe el nombre del producto: ");
                    nombre = sftwAdicion.nextLine();
                    System.out.println("Escribe la marca del producto: ");
                    marca = sftwAdicion.nextLine();
                    System.out.println("Escribe el modelo del producto: ");
                    modelo = sftwAdicion.nextLine();
                    System.out.println("Escribe el precio del producto: ");
                    precio = sftwAdicion.nextDouble();
                    System.out.println("Escribe la cantidad: ");
                    cantidad = sftwAdicion.nextInt();
                    System.out.println("Escribe el codigo: ");
                    codigo = sftwAdicion.nextInt();
                    
                    Software softwareDatos = new Software(nombre, marca, modelo, precio, cantidad, codigo);
                    software[0] = softwareDatos;
                    System.out.println(software[0].Create(softwareDatos));
                    
                    }catch(Exception e){
                        System.out.println("El dato que ingresaste no es valido...Intentalo  de Nuevo!");
                    }



                    break;

                case 2:
                    //En este case se muestran los productos solo de Software

                    List<Software> lista = new ArrayList<>();
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

                    Software softwareBusca = new Software();
                    software[2] = softwareBusca;

                    List<Software> listas = new ArrayList<>();
                    Scanner sftwBusca = new Scanner(System.in);
                    Double precioS; 

                    try{
                    System.out.println("*********************************");
                    System.out.println("   BÚSQUEDA PRODUCTO SOFTWARE       ");
                    System.out.println("*********************************");
                    System.out.println("Digite el precio a buscar:");
                    precioS = sftwBusca.nextDouble();
                    listas = software[2].Buscar(precioS);
                    System.out.println("*Nombre*" + "*Marca*    " + "*Modelo*   ");
                    for (int i = 0; i < listas.size(); i++) {
                        System.out.println(listas.get(i).getNombre() + "    " + listas.get(i).getMarca() + "    " + listas.get(i).getModelo());
                    }
                    
                    }catch(Exception e){
                        System.out.println("El digito a buscar no es valido asi que intenta de nuevo...");
                    }


                    break;

                case 4:
                    //En este case se usa para eliminar productos de software
                    Software softwareDelete = new Software();
                    software[3] = softwareDelete;
                    Scanner sftwDelete = new Scanner(System.in);

                    int dato;
                    
                    try{
                    System.out.println("*********************************");
                    System.out.println("   ELIMINAR PRODUCTO SOFTWARE       ");
                    System.out.println("*********************************");
                    System.out.println("Digite el código del producto Software que desea eliminar");
                    dato = sftwDelete.nextInt();
                    System.out.println(software[3].Delete(dato));
                    } catch(Exception e){
                        System.out.println("El codigo de producto no es valido intenta de nuevo...");
                    }
                    break;

                //Apartir del caso 5, se hace lo mismo, solo que para la clase Hardware
                case 5:
                    //Se agregan productos a la tabla Hardware
                    String nombres,
                    marcas,
                    modelos;
                    double precios;
                    int cantidades,
                     codigos;
                    Scanner hrdwAdd = new Scanner(System.in);
                    
                    
                    try{
                    System.out.println("*********************************");
                    System.out.println("   ADICION PRODUCTO HARDWARE      ");
                    System.out.println("*********************************");

                    System.out.println("Escribe el nombre del producto: ");
                    nombres = hrdwAdd.nextLine();
                    System.out.println("Escribe la marca del producto: ");
                    marcas = hrdwAdd.nextLine();
                    System.out.println("Escribe el modelo del producto: ");
                    modelos = hrdwAdd.nextLine();
                    System.out.println("Escribe el precio del producto: ");
                    precios = hrdwAdd.nextDouble();
                    System.out.println("Escribe la cantidad: ");
                    cantidades = hrdwAdd.nextInt();
                    System.out.println("Escribe el codigo: ");
                    codigos = hrdwAdd.nextInt();

                    Hardware hardwareDatos = new Hardware(nombres, marcas, modelos, precios, cantidades, codigos);
                    hardware[0] = hardwareDatos;
                    System.out.println(hardware[0].Create(hardwareDatos));
                    
                    }catch(Exception e){
                        
                        System.out.println("El dato que ingreso no es valido para el registro del producto");
                    }

                    break;
                case 6:
                    //Se mustran los productos de la tabla Hardware

                    List<Hardware> listaH = new ArrayList<>();
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
                    Scanner hrdwBusca = new Scanner(System.in);
                    Double precioH;
                    
                    try{

                    System.out.println("*********************************");
                    System.out.println("   BÚSQUEDA PRODUCTO HARDWARE      ");
                    System.out.println("*********************************");
                    System.out.println("Digite el precio a buscar:");
                    precioH = hrdwBusca.nextDouble();
                    Hardware hardwareBusca = new Hardware();
                    hardware[2] = hardwareBusca;
                    listasH = hardware[2].Buscar(precioH);
                    System.out.println("*Marca*    " + "*Modelo*   " + "*Precio*   ");
                    for (int i = 0; i < listasH.size(); i++) {
                        System.out.println(listasH.get(i).getMarca() + "      " + listasH.get(i).getModelo() + "        " + listasH.get(i).getPrecio());
                    }
                    
                    }catch(Exception e){
                        System.out.println("El precio que digito no es valido para la busqueda");
                    }


                    break;
                case 8:
                    //Se eliminan productos de Hardware
                    Scanner hrdwDelete = new Scanner(System.in);
                    int datos;
                    try{
                    System.out.println("*********************************");
                    System.out.println("   ELIMINACIÓN PRODUCTO HARDWARE  ");
                    System.out.println("*********************************");
                    System.out.println("Digite el codigo del producto que desea eliminar");
                    datos = hrdwDelete.nextInt();
                    Hardware hardwareDelete = new Hardware();
                    hardware[3] = hardwareDelete;
                    System.out.println(hardware[3].Delete(datos));
                    }catch(Exception e){
                        System.out.println("El codigo de eliminacion no es valido!");
                    }
                    break;

                //Apartir de este case, se comeinzan agregar los empleados a su tabla en la Base de Datos    
                case 9:
                    //Agregar empleados
                    String nombreE,
                     apellido;
                    char sexo;
                    int fecha,
                     ID;
                    Scanner empAdicion = new Scanner(System.in);

                    
                    try{
                    System.out.println("*********************************");
                    System.out.println("   ADICION DE EMPLEADO           ");
                    System.out.println("*********************************");
                    System.out.println("Escribe el nombre del empleado: ");
                    nombreE = empAdicion.nextLine();
                    System.out.println("Escribe el apellido del empleado: ");
                    apellido = empAdicion.nextLine();
                    System.out.println("Escribe su ID: ");
                    ID = empAdicion.nextInt();
                    empAdicion.nextLine();
                    System.out.println("Escriba su sexo:    (M o F)");
                    sexo = empAdicion.next().charAt(0);
                    System.out.println("Escriba su año de nacimiento: ");
                    fecha = empAdicion.nextInt();

                    Empleado empleadoDatos = new Empleado(nombreE, apellido, ID, sexo, fecha);
                    empleado[0] = empleadoDatos;
                    System.out.println(empleado[0].Create(empleadoDatos));
                    }catch(Exception e){
                        System.out.println("El dato del Empleado que ingreso no es valido");
                    }
                    break;

                case 10:
                    //Mostrar lista de empleados
                    List<Empleado> list = new ArrayList<>();
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
                    Scanner empBusca = new Scanner(System.in);
                    int Idbusca;
                    try{
                    System.out.println("*********************************");
                    System.out.println("   BUSQUEDA DE EMPLEADO           ");
                    System.out.println("*********************************");

                    System.out.println("Digite el ID a buscar:");
                    Idbusca = empBusca.nextInt();
                    double b = Double.valueOf(Idbusca);
                    Empleado empb = new Empleado();
                    empleado[2] = empb;
                    listE = empleado[2].Buscar(Idbusca);
                    System.out.println(" *Nombre* " + "  " + " *Apellido* " + "  " + " *ID* " + "  " + " *Sexo* " + "  " + "   *Edad* ");
                    for (int i = 0; i < listE.size(); i++) {
                        System.out.println(listE.get(i).getNombre() + "       " + listE.get(i).getApellido() + "      " + listE.get(i).getID() + "      " + listE.get(i).getSexo() + "    " + listE.get(i).getEdad());
                    }
                    }catch(Exception e){
                        System.out.println("El ID del Empleado que se ingreso no es valido para labusqueda");
                    }
                    break;
                case 12:
                    //Eliminacion por ID
                    Empleado empleadoD = new Empleado();
                    empleado[3] = empleadoD;
                    Scanner empDelete = new Scanner(System.in);
                    int isftwAdicion;
                    try{
                    System.out.println("*********************************");
                    System.out.println("   ELIMINACION DE EMPLEADO           ");
                    System.out.println("*********************************");

                    System.out.println("Digite el ID del empleado que desea eliminar");
                    isftwAdicion = empDelete.nextInt();
                    System.out.println(empleado[3].Delete(isftwAdicion));
                }catch(Exception e){
                    System.out.println("El ID del Empleadono ufe valido...no pudo ser eliminado ");
                }

                    break;
                case 13:
                    Tecnico.preciosServicio();
                    break;
                case 14:
                    System.out.println("¡Gracias por la preferencia, vuelva pronto!");
                    break;
                    
                default:
                    break;
            }

        } while (opEmp != 14);

    }
}
