package repaso04;

import java.util.Arrays;
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
		// 5.Suma
		// 6.Multiplicación
		// 7.Media
		// 8.Factorial de cada valor
		// 9.Ordenar de menor a mayor
		// 10.Ordenar de mayor 
		// 0.Salir
		
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
		//Valores aleatorios
		case 2: 
			for(int i=0; i<dimensionArray;i++) {
				Random rand = new Random();
				int aleatorio = rand.nextInt(100);
				nuevoArray[i] = aleatorio;
			}
			break;
		//Valores manuales
		case 3:
			
			rellenarArrayManualmente(entrada, dimensionArray, nuevoArray);
						
			break;
		default:
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
			System.out.println("5.- Suma");
			System.out.println("6.- Multiplicación");
			System.out.println("7.- Media");
			System.out.println("8.- Factorial");
			System.out.println("9.- Ordenar menor a mayor");
			System.out.println("10.- Ordenar mayor a menor");
			System.out.println("0.- Salir");
			seleccionMenu = entrada.nextInt();
			
			gestionarMenu(entrada, dimensionArray, nuevoArray, seleccionMenu);
			
		}while(seleccionMenu!=0); //ejecutar bucle mientras el usuario no indique "salir"
		
		
	}
	// *********** MÉTODOS ****************
	private static void gestionarMenu(Scanner entrada, int dimensionArray, int[] nuevoArray, int seleccionMenu) {
		switch(seleccionMenu) {
		case 1:
			rellenarArrayManualmente(entrada, dimensionArray, nuevoArray);
			mostrarArray(nuevoArray);
			break;
		case 2:
			System.out.println("Introduce la posición que quieres cambiar:");
			int posicion = entrada.nextInt();
			System.out.println("Introduce el valor para la posicion "+posicion+":");
			nuevoArray[posicion] = entrada.nextInt();
			mostrarArray(nuevoArray);
			break;
		case 3:
			entrada.nextLine();
			System.out.println("¿Está seguro que quiere eliminar todos los números del array? (S/N)");
			if("s".equalsIgnoreCase(entrada.nextLine())) {
				for(int i=0; i<dimensionArray; i++) {
					nuevoArray[i] = 0;
				}
			}
			mostrarArray(nuevoArray);
			break;
		case 4:
			mostrarArray(nuevoArray);
			break;
		case 5: 
			int suma = 0;
			for(int num : nuevoArray) {
				suma +=num;
			}
			System.out.println("La suma es: "+suma);
			break;
		case 6:
			int mult = 0;
			for(int num : nuevoArray) {
				mult *=num;
			}
			System.out.println("La multiplicación es: "+mult);
			break;
		case 7:
			double  media = 0;
			int total = 0;
			for(int num : nuevoArray) {
				total += num;
			}
			media = (double)total/(nuevoArray.length);
			System.out.println("La media es: "+media);
			break;
		case 8:
			for(int num : nuevoArray) {
				factorial(num);
			}
			break;
		case 9:
			//ordenarMenorMayor(nuevoArray);
			Arrays.sort(nuevoArray);
			mostrarArray(nuevoArray);
			break;
		case 10:
			ordenarMayorMenor(nuevoArray);
		default: 
			break;
			
		}
	}
	private static void ordenarMenorMayor(int[] array) {
		for(int j=0; j<array.length; j++) {
			for(int i=0; i<array.length-1; i++) {
				if(array[i] > array [i+1]) {
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
				}
			}
		}
		mostrarArray(array);
	}
	private static void ordenarMayorMenor(int[] array) {
		for(int j=0; j<array.length; j++) {
			for(int i=0; i<array.length-1; i++) {
				if(array[i] < array [i+1]) {
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
				}
			}
		}
		mostrarArray(array);
	}
	
	private static void factorial(int num) {
		int factorial = 1;
		for(int i=1; i<=num; i++) {
			factorial *=i;
		}
		System.out.println("Factorial de "+num+": "+factorial);
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
