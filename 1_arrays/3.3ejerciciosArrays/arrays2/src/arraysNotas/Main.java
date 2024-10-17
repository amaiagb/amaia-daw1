package arraysNotas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// EJERCICIO 2
		// GUARDAR 10 NOTAS EN UN ARRAY Y HACER LA MEDIA
		
		Scanner entrada = new Scanner(System.in);
		float notas[] = new float[10];
		float total = 0;
		
		//1. GUARDAR NUMEROS EN ARRAY
		
		for(int i=0; i<notas.length; i++) {
			
			float nota = 0f;
			do{
				System.out.println("Introduce una nota");
				nota = entrada.nextFloat();
				notas[i] = nota;
				total += notas[i];
				
			}while(nota <0 || nota >10);
		}
		
		//2. HACER MEDIA
		float media = 0;
		
		media = total/notas.length;
		System.out.println("Nota media: "+media);
	}

}
