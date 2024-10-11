package arrays8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Escribe un programa que genere una matriz de 4x4 con números aleatorios entre 1 y 100. 
		// Encuentra y muestra el número más grande en la matriz.
		
		int[][] matriz = new int[4][4];
		
		//Rellena la matriz de 4x4 con numeros alatorios de 1-100
		for(int fila=0; fila <matriz.length; fila++) {
			for(int col=0; col<matriz[fila].length; col++) {
				matriz[fila][col] = (int) ((Math.random()*100)+1);
			}
		}
		
		//Muestra la matriz en consola
		for(int fila=0; fila <matriz.length; fila++) {
			for(int col=0; col<matriz[fila].length; col++) {
				System.out.print(matriz[fila][col]+" ");
			}
			System.out.println();
		}
		
		//Recorre la matriz y encuentra el numero mas grande
		int max = matriz[0][0];
		
		for(int fila=0; fila <matriz.length; fila++) {
			for(int col=0; col<matriz[fila].length; col++) {
				if(matriz[fila][col] > max) {
					max = matriz[fila][col];
				}
	
			}
		}
		System.out.println("El mayor numero de la matriz es: "+max);

	}

}
