package refactorizar;

/**
 * Clase Refactorizar:
 * Calcula todos los numeros primos hasta el numero introducido por el usuario. Lo calcula usando la criba de Eratostenes.
 * @author Carmen Y. Escrig
 * @version 1.1.3
 * @see <a href ="https://es.wikipedia.org/wiki/Criba_de_Eratóstenes">Criba de Eratostenes</a>
 */

import java.util.Scanner;
public class Refactorizar {

    /**
     * Metodo main donde se lee el numero que desea el usuario y se muestra tanto el vector de numeros inicial, como el vector final con solo los numeros primos
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int[] vector = new int[dato];
        System.out.println("\nVector inicial hasta: " + dato);

        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta: " + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Metodo que se encarga de generar todos los numeros primso que hay hasta el numero indicado por el usuario
     * @param max valor entero que corresponde al numero maximo hasta los que hay que bsucar primos
     * @return array list de valores enteros con todos los nuemros primos
     */
    public static int[] generarPrimos (int max) {
        if (max >= 2) {
            int dim = max + 1;
            boolean[] esPrimo = generarArray(dim);
            esPrimo = quitarMultiplos(esPrimo, dim);
            int cuenta = contarPrimos(dim, esPrimo);

            return vectorPrimos(dim, esPrimo, cuenta);
        } else {
            return new int[0];
        }
    }

    /**
     * Metodo que genera todos los numeros primos
     * @param dim valor entero que corresponde al tamano maximo del array
     * @param esPrimo array de booleanos con valores true o false segun si son primos o no
     * @param cuenta valro entero que corresponde al numero de primos que hay
     * @return array de valores enteros con todos los valores primos
     * @since 1.1.2
     */
    private static int[] vectorPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    /**
     * Metodo que cuenta todos los numeros primos que hay
     * @param dim valor entero que corresponde al tamano maximo del array
     * @param esPrimo array de booleanos con los valores true o false segun si son primos o no
     * @return valor entero que indica todos los numeros primos encontrados
     * @since 1.1.2
     */

    private static int contarPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Metodo que genera un array de booleanos con el valor true en los posibles primos
     * @param dim valor entero que corresponde al tamano maximo del array
     * @return array de booleanos con todos los valores a true menos el 0 y el 1 porque no pueden ser primos
     * @since 1.1.2
     */

    public static boolean[] generarArray (int dim) {
        boolean[] esPrimo = new boolean[dim];
        for (int i = 0; i < dim; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = false;
        esPrimo[1] = false;

        return esPrimo;
    }

    /**
     * Metodo que pone a false los numeros que son multiplos, y por lo tanto no pueden ser primos
     * @param esPrimo array de booleanos que indican los posibles primos
     * @param dim valor entero que corresponde al tamano maximo del array
     * @return array de booleanos con los valores: <ul>
     *      *     <li>true si es posible que sea un primo</li>
     *      *     <li>false si no pueden ser primos</li>
     *      * </ul>
     * @since 1.1.2
     */

    public static boolean[] quitarMultiplos (boolean[] esPrimo, int dim) {
        for (int i = 2; i < Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
        return esPrimo;
    }
}