package repasoExtra;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		final int TOTAL_NUMEROS = 20;
		ArrayList<Integer> numerosAleatorios = new ArrayList<>();
		
		for(int i=0; i<TOTAL_NUMEROS; i++) {
			Random random = new Random();
			numerosAleatorios.add(random.nextInt(11));
		}
		
		ArrayList<Integer> numerosPares = new ArrayList<>();
		ArrayList<Integer> numerosImpares = new ArrayList<>();
		
		for(int numero : numerosAleatorios) {
			if(numero % 2 == 0) {
				numerosPares.add(numero);
			} else {
				numerosImpares.add(numero);
			}
		}
		for(int numero : numerosAleatorios) System.out.print(numero+" ");
		System.out.println("\nPares:");
		for(int numero : numerosPares) System.out.print(numero+" ");
		System.out.println("\nImpares:");
		for(int numero : numerosImpares) System.out.print(numero+" ");
		
	}

}
