package repasoExtraCollatz;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Secuencia de Collatz
		// Si el n�mero es par, se divide entre 2
		// Si el n�mero es impar, se multiplica por 3 y se suma 1
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int numero = entrada.nextInt();
		int paso = 0;
		
		System.out.println("Paso "+paso+": "+numero);
		
		while(numero>1) {

			if(numero%2 == 0) {
				numero /=2;
			} else {
				numero = numero*3 +1;
			}
			paso++;		
			System.out.println("Paso "+paso+": "+numero);
		}

	}

}
