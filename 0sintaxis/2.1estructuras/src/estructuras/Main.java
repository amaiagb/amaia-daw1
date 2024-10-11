package estructuras;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// ESTRUCTURAS DE CONTROL DE FLUJO

		// Condicionales
		// IF
		/*
		 * Scanner entrada = new Scanner(System.in);
		 * System.out.println("Introduce tu edad:"); int edad = entrada.nextInt();
		 * 
		 * if(edad>=18) { System.out.println("Acceso permitido"); } else if (edad>=16){
		 * System.out.println("Acceso permitido con tutores"); } else {
		 * System.out.println("Acceso denegado"); } entrada.close();
		 */
		// SWITCH
		Scanner entrada = new Scanner(System.in);
		/*
		System.out.println("Introduce la inicial del dia de la semana:");
		String dia = entrada.next();
		
		switch (dia) {
		case "l":
			System.out.println("Lunes");
			break;
		case "m":
			System.out.println("Martes");
			break;
		case "x":
			System.out.println("Miercoles");
			break;
		case "j":
			System.out.println("Jueves");
			break;
		case "v":
			System.out.println("Viernes");
			break;
		default:
			System.out.println("Dia no valido");
		}
		*/

		// BUCLES
		//for(inicialización; condicion; loquequieroquepasecadavuelta)
		/*
		System.out.println("Introduce tu nombre:");
		String nombre = entrada.next();
		
		for(int i=nombre.length()-1;i>=0;i--) {
			System.out.println(nombre.charAt(i));
			
		}
		*/
		//while(condicion) 

		//int numeroOculto = 5;
		
		int numeroMax= 10;
		int numeroMin = 1;
		int rango = numeroMax-numeroMin +1;
		/*
		int numeroOculto = (int)(Math.random() * rango) + numeroMin;
				System.out.println(numeroOculto);
		*/
		int numeroOculto = (int)Math.ceil(Math.random()*10);
		
		while(true) {
			System.out.println("introduce un numero");
			int numeroUsuario = entrada.nextInt();
			if(numeroOculto == numeroUsuario) {
				System.out.println("Numero correcto");
				break;
			}
		}
		
		//DO WHILE
		int numeroUsuario = 0;
		do {
			System.out.println("introduce un numero");
			numeroUsuario = entrada.nextInt();
		}while(numeroOculto != numeroUsuario);
		
		System.out.println("Numero correcto");
		
		
		entrada.close();
	}

}
