package arraysPares;

import java.util.Scanner;

public class Main {
	
	// EJERCICIO 3

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int enteros[] = new int[10];
		int pares = 0;
		int nones = 0;
		
		for(int i = 0; i<enteros.length; i++) {
			System.out.println("Introduce un numero");
			enteros[i] = entrada.nextInt();
			if(enteros[i]%2 == 0) {
				pares++;
			} else {
				nones++;
			}
		}
		System.out.println("pares: "+pares);
		System.out.println("nones: "+nones);
		
		entrada.close();
	}
	

}
