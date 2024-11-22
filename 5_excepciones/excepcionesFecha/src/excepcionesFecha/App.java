package excepcionesFecha;

import java.util.Scanner;

public class App {
	
	public static final int MAX_FECHAS = 100;
	
	public static void main(String[] args) {
		
		for (int i = 0; i < MAX_FECHAS; i++) {
			try {
				Fecha f = new Fecha(random(1600, 2024), random(1, Fecha.MESES_ANIO),random(1, 31));
				System.out.println("Fecha correcta: "+f.toString());
			}catch(FechaException e) {
				System.out.println("EXCEPCION: "+e.getMessage());
			}
		}		
	}
	
	public static int random(int min, int max){
		return (int)(Math.random() * (max - min + 1)) + min;
	}

}
