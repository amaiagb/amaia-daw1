package repaso08;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Contar palabras en una frase
		//Pide al usuario que introduzca una frase. Usa un array de cadenas para almacenar las
		//palabras de la frase y cuenta cuántas veces aparece cada palabra. Imprime cada palabra
		//junto con su frecuencia
		
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una frase");
		String frase = entrada.nextLine();
		
		String[] fraseArray = frase.split(" ");

		ArrayList<String> palabras = new ArrayList<>();
		ArrayList<Integer> frecuencias = new ArrayList<>();
		
		for(String palabra : fraseArray) {
			if(!palabras.contains(palabra)) {
				palabras.add(palabra);
				frecuencias.add(1);
			} else {
				int indice = palabras.indexOf(palabra);
				int frecuencia = frecuencias.get(indice);
				frecuencia++;
				frecuencias.set(indice, frecuencia);
			}
		}
		for(int i=0; i<palabras.size(); i++) {
			System.out.println(palabras.get(i)+": "+frecuencias.get(i));
		}
		
	}

}
