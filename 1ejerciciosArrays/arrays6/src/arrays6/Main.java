package arrays6;

import java.util.Scanner;

public class Main {
	// EJERCICIO 6
	//Pide al usuario que introduzca 10 números y los almacene en un array
	//Luego, ordena esos números de forma ascendente utilizando el algoritmo de burbuja
	public static void main(String[] args) {
		
		//int numeros[] = {-5,80,20,40,30,70,10,50,60,-3}; //Array de prueba
		Scanner entrada = new Scanner(System.in);
		int numeros[] = new int[5];
		
		System.out.println("Introduce "+numeros.length+" numeros: ");
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = entrada.nextInt();
		}
				
		//ir comparando los numeros de 2 en 2, y moviendo el mayor hacia la derecha
		//hasta que el mayor sea el ultimo del array
		//cada vuelta llegará hasta un numero menos, porque el ultimo estará ya correcto
		
		/*
		for(int j=numeros.length-1; j>0; j--) {
			for(int i=0; i<numeros.length-1; i++) {
				
				if(numeros[i] > numeros[i+1]) {
					int max = numeros[i];
					numeros[i] = numeros[i+1];
					numeros[i+1] = max;
				}
			}
		}
		*/
		for(int j=0; j<numeros.length-1; j++) {
			for(int i=0; i<numeros.length-1-j; i++) {
				
				if(numeros[i] > numeros[i+1]) {
					int max = numeros[i];
					numeros[i] = numeros[i+1];
					numeros[i+1] = max;
				}
			}
		}
		
		for(int i=0; i<numeros.length; i++) {
			//System.out.println("i: "+i+", valor: "+numeros[i]);
			System.out.println(numeros[i]);
		}
		
	}

}
