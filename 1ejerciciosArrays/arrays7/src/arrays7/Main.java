package arrays7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//EJERCICIO 7
		//Crea una matriz bidimensional de 3x3 y pide al usuario que introduzca los valores
		//Calcula la suma de cada fila y de cada columna
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce el numero de filas para la matriz");
		int filas = entrada.nextInt();
		System.out.println("Introduce el numero de columnas para la matriz");
		int columnas = entrada.nextInt();
		
		int[][] matriz = new int[filas][columnas];
		
		System.out.println("Introduce los numeros para la matriz");
		
		for(int fila = 0; fila<filas; fila++) {
			for(int col = 0; col<columnas; col++) {
				matriz[fila][col] = entrada.nextInt();
			}
		}
		
		// Mostrar la matriz por consola
		for(int fila = 0; fila<filas; fila++) {
			for(int col = 0; col<columnas; col++) {
				System.out.print(matriz[fila][col] + " ");
			}
			System.out.println(); //imprimir salto de linea despues de cada fila
		}
		
		// Sumar las filas
		
		for(int fila=0; fila<filas; fila++) {
			int sumaFila=0;
			
			for(int col=0; col<columnas; col++) {
				sumaFila+=matriz[fila][col];
			}
			System.out.println("La suma de la fila " + fila+ " es: "+ sumaFila);
		}
		
		// Sumar las columnas
		
		for(int col=0; col<columnas; col++) {
			int sumaColumna=0;
			
			for(int fila=0; fila<filas; fila++) {
				sumaColumna+=matriz[fila][col];
			}
			System.out.println("La suma de la fila " + col+ " es: "+ sumaColumna);
		}

	}

}
