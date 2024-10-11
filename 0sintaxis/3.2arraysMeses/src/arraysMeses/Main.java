package arraysMeses;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String[] meses= {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un n�mero (1-12):");
		
		int numMes = entrada.nextInt(); //recoge el n�mero 
		
		if(numMes >=1 && numMes <=12) {
			System.out.println(meses[numMes-1]); //el indice del array tiene que ser 1 menos del n�mero introducido
		} else {
			System.out.println("Mes incorrecto");
		}
		
		
		entrada.close();
	}
}

