package repaso03;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 3
		// Modificar el programa anterior para que una vez inicializado el array te aparezca un menú 
		// donde se pida lo siguiente:
		
		// 1.Cambiar valores de todo el array
		// 2.Cambiar un valor del array
		// 3.Reiniciar el array
		// 4.Mostrar Array
		// 0.Salir
		
		// El primero debe pedir números para todas las posiciones del array. 
		// El segundo pide una posición y un número y se modifica por el anterior. 
		// En el tercer caso se ponen todos los valores del array a 0, antes de reiniciar se tiene que avisar al usuario que va a borrar todos los datos y si dice que no quiere borrar volver al menú. 
		// La cuarta opción muestra los valores del array. Después de cada una de estas opciones debe mostrarse el mismo menú otra vez. 
		// Por último para finalizar el programa tenemos la opción 5.
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("De cuantas posiciones quieres crear tu array?");
		int dimensionArray = entrada.nextInt();
		int[] nuevoArray = new int[dimensionArray];
		System.out.println("Como quieres inicializar tu array:");
		System.out.println("1.- Con ceros");
		System.out.println("2.- Con números aleatorios del 1 al 100");
		System.out.println("3.- Insertando los números manualmente");
		
		int modoInicializacion = entrada.nextInt();
		
		switch(modoInicializacion) {
		case 2: 
			for(int i=0; i<dimensionArray;i++) {
				Random rand = new Random();
				int aleatorio = rand.nextInt(100);
				nuevoArray[i] = aleatorio;
			}
			break;
		case 3:
			rellenarArrayManualmente(entrada, dimensionArray, nuevoArray);						
			break;
		default:
			System.out.println("Elegir un numero entre 1 - 3");
			break;
		}
		mostrarArray(nuevoArray);
		
		//********** MENU **********

		int seleccionMenu;
		
		do { 
			System.out.println("¿Qué quieres hacer con tu array?");
			System.out.println("1.- Cambiar valores de todo el array");
			System.out.println("2.- Cambiar un valor del array");
			System.out.println("3.- Reiniciar el array");
			System.out.println("4.- Mostrar Array");
			System.out.println("0.- Salir");
			seleccionMenu = entrada.nextInt();
			
			gestionarMenu(entrada, dimensionArray, nuevoArray, seleccionMenu);
			
			if(seleccionMenu != 0) {
				mostrarArray(nuevoArray);
			}
			
		}while(seleccionMenu!=0); //ejecutar bucle mientras el usuario no indique "salir"
		
	}
	
	// **************** MÉTODOS ***************
	
	private static void gestionarMenu(Scanner entrada, int dimensionArray, int[] nuevoArray, int seleccionMenu) {
		switch(seleccionMenu) {
		case 1:
			rellenarArrayManualmente(entrada, dimensionArray, nuevoArray);
			break;
		case 2:
			System.out.println("Introduce la posición que quieres cambiar:");
			int posicion = entrada.nextInt();
			
			if(posicion <= dimensionArray && posicion > 0 ) {
				System.out.println("Introduce el valor para la posicion "+(posicion)+":");
				nuevoArray[posicion-1] = entrada.nextInt();
			}   else {
				System.out.println("Introducir valor de 1 a "+(dimensionArray));
			}
			break;
		case 3:
			entrada.nextLine();
			System.out.println("¿Está seguro que quiere eliminar todos los números del array? (S/N)");
			if("s".equalsIgnoreCase(entrada.nextLine())) {
				for(int i=0; i<dimensionArray; i++) {
					nuevoArray[i] = 0;
				}
			}
			break;
		default: 
			if(seleccionMenu != 0 && seleccionMenu != 4) {
				System.out.println("Elegir un numero entre 0 - 4");
			}
			break;
			
		}
	}

	private static int seleccionarMenu(Scanner entrada) {
		System.out.println("¿Qué quieres hacer con tu array?");
		System.out.println("1.- Cambiar valores de todo el array");
		System.out.println("2.- Cambiar un valor del array");
		System.out.println("3.- Reiniciar el array");
		System.out.println("4.- Mostrar Array");
		System.out.println("0.- Salir");
		
		int seleccionMenu = entrada.nextInt();
		return seleccionMenu;
	}

	private static void rellenarArrayManualmente(Scanner entrada, int dimensionArray, int[] nuevoArray) {
		for(int i=0; i<dimensionArray; i++) {
			System.out.println("Introduce el número para la posición "+i+":");
			nuevoArray[i] = entrada.nextInt();
		}
	}
	
	public static void mostrarArray(int[] array) {
		System.out.print("Valores del array [");
		
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			
			if(i != array.length-1) { //si no es el ultimo elemento del array añade una coma
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}

}
