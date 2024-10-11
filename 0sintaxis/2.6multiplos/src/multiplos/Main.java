package multiplos;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero:");
		int numero = entrada.nextInt();
		System.out.println("los multiplos son:");
		
		for(int i=1; i<=numero; i++) {
			if(numero%i == 0) { //si al dividir el resto es 0 ES MULTIPLO
				System.out.println(i);
			}
		}

	}

}
