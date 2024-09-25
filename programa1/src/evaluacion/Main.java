package evaluacion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* PROGRAMA 1
		 * - pedir por teclado un nombre de alumno
		 * - pedir por teclado 5 notas
		 * - mostrar la media
		 * - mostrar si el alumno aprueba el año (para ser apto tiene que aprobar todo)
		 * "El alumno X tiene una media de 5.5 y es apto."
		 */
			
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce nombre del alumno");
		String nombre = entrada.next();
		
		System.out.println("Nota de Programación:");
		float nota1 = entrada.nextFloat();
		System.out.println("Nota de BBDD:");
		float nota2 = entrada.nextFloat();
		System.out.println("Nota de Lenguaje de Marcas:");
		float nota3 = entrada.nextFloat();
		System.out.println("Nota de Entornos:");
		float nota4 = entrada.nextFloat();
		System.out.println("Nota de Inglés:");
		float nota5 = entrada.nextFloat();
				
		float media = (nota1+nota2+nota3+nota4+nota5)/5;
		System.out.println(media);
		
		if(nota1>=5 && nota2>=5 && nota3>=5 && nota4>=5 && nota5>=5) {
			System.out.println("El alumno "+nombre+ " tiene una nota media de "+media+", y es apto");
		} else {
			System.out.println("El alumno "+nombre+ " tiene una nota media de "+media+", y no es apto");
		}
		
	}

}
