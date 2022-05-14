package proyecto.programacion;

public class Ordenamiento {
    
        //Métodos de ordenamiento
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

    
}
