package repaso05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Calcular la media de los números positivos y negativos en un array
		// Escribe un programa que reciba un array de enteros (positivos y negativos) y calcule la
		// media de los números positivos y la media de los negativos por separado
		
		Scanner entrada = new Scanner(System.in);
		int[] numeros = new int[10];
		int positivosSuma = 0;
		int positivosContador = 0;
		int negativosSuma = 0;
		int negativosContador = 0;
		
		for(int i=0; i<numeros.length; i++) {
			System.out.println("Introduce un numero entero");
			numeros[i] = entrada.nextInt();
		}
		
		for(int i=0; i<numeros.length; i++) {
			if(numeros[i] > 0) {
				positivosSuma += numeros[i];
				positivosContador++;
			} else if(numeros[i] < 0) {
				negativosSuma += numeros[i];
				negativosContador++;
			}
		}
		float negativosMedia = (float) negativosSuma/negativosContador;
		float positivosMedia = (float) positivosSuma/positivosContador;
		
		System.out.println("La media de positivos es: "+positivosMedia);
		System.out.println("La media de negativos es: "+negativosMedia);

				
		entrada.close();
		
	}

}
