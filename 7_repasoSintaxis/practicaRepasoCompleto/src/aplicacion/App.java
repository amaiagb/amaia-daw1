package aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import juegos.interfaces.Jugable;
import numeros.JuegoAdivinaImpar;
import numeros.JuegoAdivinaNumero;
import numeros.JuegoAdivinaPar;

public class App {
	
	public static void main(String[] args) {
		
		String volverAJugar;
		System.out.println(new Date().getTime());
		do {
			Jugable j = eligeJuego();
			j.muestraNombre();
			j.muestraInfo();
			j.juega();
			System.out.println("¿Quieres jugar otra vez? (s/n)");
			Scanner entrada = new Scanner(System.in);
			volverAJugar = entrada.nextLine();
		} while("s".equalsIgnoreCase(volverAJugar));
		

	}
	
	public static Jugable eligeJuego() {
		Object juegoNumero = new JuegoAdivinaNumero(3);
		Object juegoPar = new JuegoAdivinaPar(3);
		Object juegoImpar = new JuegoAdivinaImpar(3);
		
		ArrayList<Jugable> juegos = new ArrayList<Jugable>(3);
		juegos.add((Jugable) juegoNumero);
		juegos.add((Jugable) juegoPar);
		juegos.add((Jugable) juegoImpar);
		
		int seleccionJuego = 0;
		do {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Elige un juego: (1-3)");
			System.out.println("1.- Adivinar Numero");
			System.out.println("2.- Adivinar Numero Par");
			System.out.println("3.- Adivinar Numero Impar");
			
			seleccionJuego = entrada.nextInt();
			
		}while(seleccionJuego<1 || seleccionJuego>3);
		
		return juegos.get(seleccionJuego-1);
		
	}
}
