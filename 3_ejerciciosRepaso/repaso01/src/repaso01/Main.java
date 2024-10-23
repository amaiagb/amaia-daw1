package repaso01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Ejercicio 1
		//Crear un programa que pida al usuario de cuantas posiciones quiere crear un array (de enteros) e inicializarlo a 0.
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("De cuantas posiciones quieres crear tu array?");
		
		int dimensionArray = entrada.nextInt();
		int[] nuevoArray = new int[dimensionArray];
		
		System.out.print("Se ha creado tu array [");
		
		for(int i=0; i<dimensionArray;i++) {
			 
			System.out.print(nuevoArray[i]);
			if(i != dimensionArray-1) { //añadir coma si no es el ultimo elemento
				System.out.print(",");
			}
		}
		System.out.print("]");
		entrada.close();
	}

}
