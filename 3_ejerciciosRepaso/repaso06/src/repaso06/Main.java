package repaso06;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Suma de elementos en una diagonal de una matriz
		// Crea una matriz cuadrada de tamaño NxN (donde N es ingresado por el usuario) y llena la
		// matriz con valores aleatorios entre 1 y 100. Luego, calcula y muestra la suma de los
		// elementos en la diagonal principal
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el numero de filas de la matriz: ");
		final int FILAS = entrada.nextInt();
		
		int[][] matriz = new int[FILAS][FILAS];
		
		for(int i=0; i<FILAS; i++) {
			
			for(int j=0; j<FILAS; j++) {
				
				Random random = new Random();
				int numero = (random.nextInt(100))+1;
				
				matriz[i][j] = numero; 
				
			}
		}
		
		for(int i=0; i<FILAS; i++) {
			for(int j=0; j<FILAS; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
		int sumaDiagonal = 0;
		for(int i=0; i<FILAS; i++) {
			sumaDiagonal += matriz[i][i];
		}
		System.out.println("La suma de la diagonal principal es: "+sumaDiagonal);

	}

}
