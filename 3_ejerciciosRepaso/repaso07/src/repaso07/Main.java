package repaso07;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		//  Buscar duplicados en un array
		// Escribe un programa que tome un array de números enteros y determine si hay números
		// duplicados en él. Imprime los números duplicados y cuántas veces se repiten.
		
		int[] numeros = {50,2,64,34,18,5,9,74,1,15,64,17,9,50,11};
		
		for(int i=0; i<numeros.length; i++) {
			int contador = 0;
			for(int j=0; j<numeros.length; j++) {
				
				if(numeros[i] == numeros[j]) {
					contador++;
				}
				
			}
			if(contador > 1) {
				System.out.println(numeros[i]+": "+contador+" veces");
			}
			
		}
		
		
		ArrayList<Integer> array = new ArrayList<>();
		Collections.addAll(array,50,2,64,34,18,5,9,74,1,15,9,64,17,9,50,11);
		
		array.sort(null);
		
		for(int i=0; i<array.size(); i++) {
			/*
			int num = array.get(i);
			int primeraPos = i;
			int ultimaPos = array.lastIndexOf(num);
			System.out.println(num + ": "+(ultimaPos-primeraPos));
			*/
			
			int contador = 0;
			for(int j=i+1; j<array.size(); j++) {
				if(array.get(i) != array.get(j)) {
					break;
					
				}else {
					contador++;
				}
			}
			System.out.println(array.get(i)+": "+(contador+1));
		}
		
		
	}

}
