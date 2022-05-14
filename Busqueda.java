package proyecto.programacion;


public class Busqueda {
    
    // Metodos de busqueda
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
}
