package factorial;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero:");
		int num = entrada.nextInt();
		int factorial = 1;
		String calculo = ""; 
				
		for(int i=1;i<=num;i++) {
			factorial = factorial*i; 

			calculo = calculo.concat(Integer.toString(i)); //añade el numero i(0,1,2...) a la cadena de texto
			
			if(i!=num) { //si no es el ultimo numero se añade una x a la cadena para representar la multiplicacion
				calculo = calculo.concat("x");
			}
		}
		System.out.println(calculo.concat("="+factorial)); 


	}

}
