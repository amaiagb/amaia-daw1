package arrays9;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Crea un array de 10 elementos y pide al usuario que introduzca sus valores. 
		// Luego, realiza una rotación hacia la derecha de los elementos del array.
		// El último valor pasa a ser el primero, y los demás se desplazan una posición

		int[] numeros = new int[10];
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce 10 numeros: ");
		
		//Guardar elementos en array
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = entrada.nextInt();
		}
		
		// Mover los elementos del array una posicion a la derecha
		int aux = 0; 
		
		for(int i=numeros.length-1; i>0; i--) {
			aux = numeros[i];
			numeros[i] = numeros[i-1];
			numeros[i-1] = aux;
		}
		
		//Mostrar nuevo array
		for(int i=0; i<numeros.length; i++) {
			System.out.print(numeros[i]+"- ");
		}
		
	}

}
