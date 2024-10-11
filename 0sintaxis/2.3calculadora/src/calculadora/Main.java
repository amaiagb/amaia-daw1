package calculadora;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un numero"); 
		int n1 = entrada.nextInt(); //recoge el numero introducido en consola
		System.out.println("Introduce otro numero");
		int n2 = entrada.nextInt();
		System.out.println("Elige operacion: (+, -, *, /)");
		String operacion = entrada.next();
		
		/*
		System.out.println("Suma: "+(n1+n2));
		System.out.println("Resta: "+(n1-n2));
		System.out.println("Multiplicacion: "+(n1*n2));
		System.out.println("Division: "+(n1/n2));
		*/
		
		switch(operacion) {
		case "+":
			System.out.println(n1+"+"+n2+"="+(n1+n2));
			break;
		case "-":
			System.out.println(n1+"-"+n2+"="+(n1-n2));
			break;
		case "*":
			System.out.println(n1+"*"+n2+"="+(n1*n2));
			break;
		case "/":
			System.out.println(n1+"/"+n2+"="+(n1/n2));
			break;
		default:
			System.out.println("error");
		}
				
		entrada.close();
		
	}
}
