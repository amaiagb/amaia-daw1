package mayornumeroarray;

import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		Crear programa que lea 5 numeros enteros y los almacene en un array. 
		Encontrar el numero mas alto del array.
		*/
		
		Scanner entrada = new Scanner(System.in);
		int enteros[] = new int[5];
		
		//1. GUARDAR NUMEROS EN ARRAY
		for(int i=0; i<5; i++) {
			System.out.println("Introduce un numero entero");
			enteros[i] = entrada.nextInt();
		}
		
		//2. ENCONTRAR EL NUMERO MAS ALTO
		
		int mayorNum  = enteros[0]; //Guardar el primer valor del array en la variable mayorNum
		
		for(int i=1; i<enteros.length; i++) { //Recorrer todos los valores del array
			
			if(enteros[i] > mayorNum) { //Comparar cada numero del array con el mayor numero guardado anteriormente
				mayorNum = enteros[i];  //Si es mayor actualizar el valor
			}
		}
		
		System.out.println("Mayor número del array: "+mayorNum);
		
		entrada.close();
	}

}
