package repasoExtraDados;

import java.util.Random;

public class Main {
	// JUEGO DE DADOS
	// Simula el lanzamiento de dos dados y muestra el resultado de cada dado y la suma de ambos.

	public static void main(String[] args) {
		Random random = new Random();
		int num1 = (random.nextInt(6))+1;
		int num2 = (random.nextInt(6))+1;
				
		System.out.println("Dado 1: ");
		pintarDado(crearDado(num1));
		System.out.println("Dado 2: ");
		pintarDado(crearDado(num2));
		System.out.println("Suma: "+(num1+num2));
	}

	static void pintarDado(String[][] matrizDado) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(matrizDado[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static String[][] crearDado(int numero){
		
		String[] array = new String[9];
		String[] graf1 = {" "," "," "," ","•"," "," "," "," "};
		String[] graf2 = {"•"," "," "," "," "," "," "," ","•"};
		String[] graf3 = {"•"," "," "," ","•"," "," "," ","•"};
		String[] graf4 = {"•"," ","•"," "," "," ","•"," ","•"};
		String[] graf5 = {"•"," ","•"," ","•"," ","•"," ","•"};
		String[] graf6 = {"•"," ","•","•"," ","•","•"," ","•"};
		
		switch(numero) {
		case 1: 
			array = graf1;
			break;
		case 2: 
			array = graf2;
			break;
		case 3: 
			array = graf3;
			break;
		case 4: 
			array = graf4;
			break;
		case 5: 
			array = graf5;
			break;
		case 6: 
			array = graf6;
			break;
		}

		String[][] matrizDado = new String[3][3];
		int contador = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				matrizDado[i][j] = array[contador];
				contador++;
			}
		}
		return matrizDado;
		
	}
}
