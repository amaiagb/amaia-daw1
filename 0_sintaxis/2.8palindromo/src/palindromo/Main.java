package palindromo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una palabra");
		
		//************ EJERCICIO PALINDROMO: PALABRA ****************
		
		/*
		String palabra = entrada.next();
		String palabraReves = "";
		Boolean palindromo = false; 
		
		for(int i=palabra.length()-1; i>=0;i--) {
			palabraReves += palabra.charAt(i);	
		}
		
		
		System.out.println(palabra);
		System.out.println(palabraReves);
		
		if(palabra.equalsIgnoreCase(palabraReves)) {
			palindromo = true;
		}else {
			palindromo = false;
		}
		
		if(palindromo) {
			System.out.println("Es palindromo");
		}else {
			System.out.println("No es palindromo");
		}
		*/
		
		//**************** EJERCICIO PALINDROMO: FRASE **************
		
		String texto = entrada.nextLine();
		String textoSeguido = "";
		String textoReves = "";
		Boolean palindromo = false;
		
		for(int i=0; i<texto.length();i++) { //Bucle para quitar los espacios
		
			if(texto.charAt(i) != ' ' && texto.charAt(i) != ',' && texto.charAt(i) != '.') {
				textoSeguido += texto.charAt(i);
			}
		}
		
		for(int i=textoSeguido.length()-1; i>=0;i--) { //Bucle para conseguir texto al reves
			textoReves += textoSeguido.charAt(i);	
		}
		
		if(textoSeguido.toLowerCase().equals(textoReves.toLowerCase())) { //Comparar texto al derecho y texto al reves
			palindromo = true;
		}else {
			palindromo = false;
		}
		
		if(palindromo) {
			System.out.println("Es palindromo");
		}else {
			System.out.println("No es palindromo");
		}
		
		entrada.close();
	}

}
