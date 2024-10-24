package repaso03;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Ejercicio 3
		// Modificar el programa anterior para que una vez inicializado el array te aparezca un men� 
		// donde se pida lo siguiente:
		
		// 1.Cambiar valores de todo el array
		// 2.Cambiar un valor del array
		// 3.Reiniciar el array
		// 4.Mostrar Array
		// 0.Salir
		
		// El primero debe pedir n�meros para todas las posiciones del array. 
		// El segundo pide una posici�n y un n�mero y se modifica por el anterior. 
		// En el tercer caso se ponen todos los valores del array a 0, antes de reiniciar se tiene que avisar al usuario que va a borrar todos los datos y si dice que no quiere borrar volver al men�. 
		// La cuarta opci�n muestra los valores del array. Despu�s de cada una de estas opciones debe mostrarse el mismo men� otra vez. 
		// Por �ltimo para finalizar el programa tenemos la opci�n 5.
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("De cuantas posiciones quieres crear tu array?");
		int dimensionArray = entrada.nextInt();
		int[] nuevoArray = new int[dimensionArray];
		System.out.println("Como quieres inicializar tu array:");
		System.out.println("1.- Con ceros");
		System.out.println("2.- Con n�meros aleatorios del 1 al 100");
		System.out.println("3.- Insertando los n�meros manualmente");
		
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
			System.out.println("�Qu� quieres hacer con tu array?");
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
	
	// **************** M�TODOS ***************
	
	private static void gestionarMenu(Scanner entrada, int dimensionArray, int[] nuevoArray, int seleccionMenu) {
		switch(seleccionMenu) {
		case 1:
			rellenarArrayManualmente(entrada, dimensionArray, nuevoArray);
			break;
		case 2:
			System.out.println("Introduce la posici�n que quieres cambiar:");
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
			System.out.println("�Est� seguro que quiere eliminar todos los n�meros del array? (S/N)");
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
		System.out.println("�Qu� quieres hacer con tu array?");
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
			System.out.println("Introduce el n�mero para la posici�n "+i+":");
			nuevoArray[i] = entrada.nextInt();
		}
	}
	
	public static void mostrarArray(int[] array) {
		System.out.print("Valores del array [");
		
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			
			if(i != array.length-1) { //si no es el ultimo elemento del array a�ade una coma
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}

}
