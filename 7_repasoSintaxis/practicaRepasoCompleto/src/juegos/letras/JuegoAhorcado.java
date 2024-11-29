package juegos.letras;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import juegos.Juego;
import juegos.excepciones.JuegoException;
import juegos.interfaces.Jugable;

public class JuegoAhorcado extends Juego implements Jugable{
	
	public String cadenaAAdivinar;
	
	public JuegoAhorcado(int vidas, String cadenaAAdivinar) throws JuegoException {
		super(vidas);
		this.cadenaAAdivinar = cadenaAAdivinar;
		for (int i = 0; i < cadenaAAdivinar.length(); i++) {
			Character caracter = cadenaAAdivinar.charAt(i);			
			if(caracter.getType(caracter) == 9) {
				throw new JuegoException("Error: Se ha introducido un número");
			}
		}
	}

	@Override
	public void juega() {
		super.reiniciaPartida();
		boolean palabraResuelta = false;
		String cadena = new String();
		for(int i=0; i<cadenaAAdivinar.length(); i++) {
			cadena += "-";
		}
		do {	
			
			System.out.println("Introduce una letra");
			Scanner entrada = new Scanner(System.in);
			char letra = entrada.next().charAt(0);
			
			if(cadenaAAdivinar.indexOf(letra) != -1) {
				
				//Obtener posiciones
				ArrayList<Integer> posiciones = new ArrayList<Integer>();
				
				for(int i=0; i<cadenaAAdivinar.length(); i++) {				
					if(cadenaAAdivinar.charAt(i) == letra) {
						posiciones.add(i);
					}
				}
				
				//Sustituir cadena de juego
				for (int i = 0; i < posiciones.size(); i++) {
					
					int pos = posiciones.get(i);
					cadena = cadena.substring(0, pos)+letra+cadena.substring(pos+1);
				}
				System.out.println(cadena);
				
				if(cadena.compareToIgnoreCase(cadenaAAdivinar) == 0) {
					palabraResuelta = true;
					System.out.println("¡Enhorabuena!");
				}
				
				
			} else {
				System.out.println("Letra incorrecta");
				boolean vidasRestantes = quitaVida();
				if(vidasRestantes) {
					System.out.println("Vidas restantes: "+this.getVidas());
				}
			}
		}while(this.getVidas()>=0 && !palabraResuelta);
		
	}

	@Override
	public void muestraNombre() {
		System.out.println("*** Juego del ahorcado ***");
		
	}

	@Override
	public void muestraInfo() {
		System.out.println("Tienes varias oportunidades para acertar una palabra");
		
	}

}
