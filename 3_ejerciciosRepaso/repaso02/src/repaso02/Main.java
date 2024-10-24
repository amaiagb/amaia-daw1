package repaso02;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 2
		// Modificar el programa anterior para preguntar después de insertar el número de posiciones 
		// si quiere inicializar el array a ceros (esta sería la funcionalidad anterior)
		// con números aleatorios del 1 al 100 o insertar todos los números.
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("De cuantas posiciones quieres crear tu array?");
		int dimensionArray = entrada.nextInt();
		int[] nuevoArray = new int[dimensionArray];
		System.out.println("Como quieres inicializar tu array:");
		System.out.println("1.- Con ceros");
		System.out.println("2.- Con números aleatorios del 1 al 100");
		System.out.println("3.- Insertando los números manualmente");
		
		int modoInicializacion = entrada.nextInt();
		
		switch(modoInicializacion) {
		case 2: //Valores aleatorios
			for(int i=0; i<dimensionArray;i++) {
				Random rand = new Random();
				nuevoArray[i] = rand.nextInt(100)+1;
			}
			break;
		
		case 3: //Valores manuales
			for(int i=0; i<dimensionArray; i++) {
				System.out.println("Introduce el número para la posición "+(i+1)+":");
				nuevoArray[i] = entrada.nextInt();
			}			
			break;
		default:
			System.out.println("Elegir un numero entre 1 - 3");
			break;
		}
		mostrarArray(nuevoArray);
		
	}
	public static void mostrarArray(int[] array) {
		System.out.print("Valores del array [");
		
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			
			if(i != array.length-1) { //si no es el ultimo elemento del array añade una coma
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

}
