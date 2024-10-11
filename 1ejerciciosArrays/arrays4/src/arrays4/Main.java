package arrays4;

import java.util.Scanner;

public class Main {
	// EJERCICIO 4
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int enteros[] = new int[8];
		
		//Introducidos por consola:
		/*
		for(int i = 0; i<enteros.length; i++) {
			System.out.println("Introduce un numero:");
			enteros[i] = entrada.nextInt();
		}
		*/
		
		//Numeros aleatorios
		for(int i = 0; i<enteros.length; i++) {
			enteros[i] = (int) ((Math.random()*10)+1);
			System.out.println(enteros[i]);
		}
		
		System.out.println("Introduce numero a buscar:");
		int numero = entrada.nextInt();
		boolean encontrado = false;
		int posicion = 0;
		
		for(int i=0; i<enteros.length; i++) {
			if(enteros[i] == numero) {
				posicion = i;
				encontrado = true;
				break;
			}
		}
		if(encontrado) {
			System.out.println("El numero esta en la posicion: "+posicion);
		} else {
			System.out.println("El numero no esta en el array");
		}
		entrada.close();
	}

}
