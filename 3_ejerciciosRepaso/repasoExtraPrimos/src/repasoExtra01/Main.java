package repasoExtra01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// NUMEROS PRIMOS
		// Escribe un programa que permita al usuario elegir entre:
		// 1. Imprimir todos los números primos hasta un límite ingresado por el usuario.
		// 2. Devolver el primo numero n ingresado por el usuario
		// 3. Devolver los numeros primos en un rango especificado por el usuario
		// 4. Sumar los numeros primos hasta un numero n ingresado por el usuario
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1 - Obtener todos los nº primos de 0 a x");
		System.out.println("2 - Obtener el enésimo número primo número");
		System.out.println("3 - Obtener todos los primos de un rango");
		System.out.println("4 - Sumar los primos hasta x numero");
		
		int numLimit;
		
		switch(entrada.nextInt()) {
		case 1: 
			System.out.println("¿Hasta qué número?");
			numLimit = entrada.nextInt();
			
			System.out.println("Numeros primos hasta el "+numLimit+": ");
			
			for(int numeroActual=2; numeroActual<numLimit; numeroActual++) {
				if(esPrimo(numeroActual)) System.out.println(numeroActual);
			}
			break;
			
		case 2:
			System.out.println("¿Para qué valor de n?");
			numLimit = entrada.nextInt();
			int ultimoPrimo = obtenerEnesimoPrimo(numLimit);
			System.out.println("El primo nº"+numLimit+" es: "+ultimoPrimo);
			break;
			
		case 3:
			System.out.println("¿Desde qué número?");
			int numMin = entrada.nextInt();
			System.out.println("¿Hasta qué número?");
			int numMax = entrada.nextInt();
			
			for(int i=numMin; i <= numMax; i++) {
				if(esPrimo(i)){
					System.out.println(i);
				}
			}
			break;
			
		case 4:
			System.out.println("¿Hasta qué número?");
			numLimit = entrada.nextInt();
			System.out.println("La suma de los primos hasta "+numLimit+" es: "+sumarPrimos(numLimit));
			break;
			
		default: 
			System.out.println("Número no válido");
			break;
		}
		entrada.close();
	}

	private static int obtenerEnesimoPrimo(int numLimit) {
		int posicionActual = 0;
		int primos = 0;
		
		do {
			if(esPrimo(posicionActual)){
				primos++;
			}
			posicionActual++;
		}while(primos != numLimit);
		int ultimoPrimo = posicionActual-1;
		return ultimoPrimo;
	}

	private static int sumarPrimos(int numLimit) {
		int sumaPrimos = 0;
		for(int i=2; i <= numLimit; i++) {
			if(esPrimo(i)){
				sumaPrimos += i;
			}
		}
		return sumaPrimos;
	}
	
	static boolean esPrimo(int numero) {
		boolean numeroPrimo = false;
		int divisores = 0;
		
		for(int i=1; i<=numero; i++) {
			if(numero%i == 0) {
				divisores++;
			}
		}
		if(divisores == 2) {
			numeroPrimo = true;
		}
		return numeroPrimo;
	}

}
