package aplicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import juegos.excepciones.JuegoException;
import juegos.interfaces.Jugable;
import juegos.letras.JuegoAhorcado;
import juegos.numeros.JuegoAdivinaImpar;
import juegos.numeros.JuegoAdivinaNumero;
import juegos.numeros.JuegoAdivinaPar;

public class App {
	
	public static void main(String[] args) {
		
		String volverAJugar = "n";
		
		do {
			try {
				Jugable j = eligeJuego();
				System.out.println();
				j.muestraNombre();
				j.muestraInfo();
				j.juega();
				System.out.println("¿Quieres jugar otra vez? (s/n)");
				Scanner entrada = new Scanner(System.in);
				volverAJugar = entrada.nextLine();
			}catch(JuegoException e) {
				System.out.println(e.getMessage());
			}finally {
				System.out.println("Fin del programa");
			}
			
		} while("s".equalsIgnoreCase(volverAJugar));
		
	}
	
	public static Jugable eligeJuego() throws JuegoException{
		
		Object juegoNumero = new JuegoAdivinaNumero(3);
		Object juegoPar = new JuegoAdivinaPar(3);
		Object juegoImpar = new JuegoAdivinaImpar(3);
		Object juegoAhorcado = new JuegoAhorcado(3,"calabaza");
		
		ArrayList<Jugable> juegos = new ArrayList<Jugable>(4);
		juegos.add((Jugable) juegoNumero);
		juegos.add((Jugable) juegoPar);
		juegos.add((Jugable) juegoImpar);
		juegos.add((Jugable) juegoAhorcado);

		int seleccionJuego = 0;
		do {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Elige un juego: (1-3)");
			System.out.println("1.- Adivinar Numero");
			System.out.println("2.- Adivinar Numero Par");
			System.out.println("3.- Adivinar Numero Impar");
			System.out.println("4.- Ahorcado");
			System.out.print("Opción: ");
			
			seleccionJuego = entrada.nextInt();
			
		}while(seleccionJuego<1 || seleccionJuego>4);
		
		return juegos.get(seleccionJuego-1);
		
	}
}
