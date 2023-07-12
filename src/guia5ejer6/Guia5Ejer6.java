/*
 Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9 donde la suma
de sus filas, sus columnas y sus diagonales son idénticas. Crear un programa que permita introducir
un cuadrado por teclado y determine si este cuadrado es mágico o no. El programa deberá
comprobar que los números introducidos son correctos, es decir, están entre el 1 y el 9.

Modele e implemente las clases Java con los métodos necesarios para poder resolver este
problema. Luego realice las pruebas necesarias desde el método main de la clase principal del
proyecto.
 */
package guia5ejer6;

import java.util.Scanner;


public class Guia5Ejer6 {

   public static void main(String[] args) {
        int[][] cuadrado = leerCuadrado();

        if (esCuadradoMagico(cuadrado)) {
            System.out.println("El cuadrado es mágico.");
        } else {
            System.out.println("El cuadrado no es mágico.");
        }
    }

    public static int[][] leerCuadrado() {
     int[][] cuadrado = new int[3][3];
    Scanner scanner = new Scanner(System.in);

    System.out.println("Introduce los números del cuadrado (del 1 al 9):");

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cuadrado[i][j] = scanner.nextInt();
        }
    }

    System.out.println("Cuadrado ingresado:");

   for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(cuadrado[i][j] + "\t");
        }
        System.out.println();
    }

    return cuadrado;

    }

    public static boolean esCuadradoMagico(int[][] cuadrado) {
        // Comprobar que los números estén entre 1 y 9
        if (!numerosValidos(cuadrado)) {
            return false;
        }

        // Calcular la suma mágica esperada
        int sumaMagica = cuadrado[0][0] + cuadrado[0][1] + cuadrado[0][2];

        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            int sumaFila = cuadrado[i][0] + cuadrado[i][1] + cuadrado[i][2];
            if (sumaFila != sumaMagica) {
                return false;
            }
        }

        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            int sumaColumna = cuadrado[0][j] + cuadrado[1][j] + cuadrado[2][j];
            if (sumaColumna != sumaMagica) {
                return false;
            }
        }

        // Comprobar diagonales
        int sumaDiagonal1 = cuadrado[0][0] + cuadrado[1][1] + cuadrado[2][2];
        int sumaDiagonal2 = cuadrado[0][2] + cuadrado[1][1] + cuadrado[2][0];
        if (sumaDiagonal1 != sumaMagica || sumaDiagonal2 != sumaMagica) {
            return false;
        }

        return true;
    }

    public static boolean numerosValidos(int[][] cuadrado) {
        boolean[] numeros = new boolean[10]; // Usamos el índice 0 como marcador

        // Comprobar que los números estén entre 1 y 9 y no se repitan
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int numero = cuadrado[i][j];
                if (numero < 1 || numero > 9 || numeros[numero]) {
                    return false;
                }
                numeros[numero] = true;
            }
        }

        return true;
    }

}