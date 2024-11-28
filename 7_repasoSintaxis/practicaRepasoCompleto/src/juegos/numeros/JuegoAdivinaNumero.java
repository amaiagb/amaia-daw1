package juegos.numeros;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import juegos.Juego;
import juegos.interfaces.Jugable;

public class JuegoAdivinaNumero extends Juego implements Jugable{
	
	public int numeroAAdivinar;
	Random rand = new Random(new Date().getTime());
	
	public JuegoAdivinaNumero(int vidas) {
		super(vidas);
	}


	@Override
	public void juega() {
		this.reiniciaPartida();
		int numeroIntroducido = -1;
		do {
			System.out.println("Introduce un número: ");
			Scanner entrada = new Scanner(System.in);
			numeroIntroducido = entrada.nextInt();
			
			if(validaNumero(numeroIntroducido)) {
				if(numeroIntroducido == numeroAAdivinar) {
					System.out.println("¡Acertaste!");
					actualizaRecord();
				} else {
					boolean vidasRestantes = quitaVida();
					if(vidasRestantes && numeroAAdivinar > numeroIntroducido) {
						System.out.println("Mayor");
					} else if(vidasRestantes && numeroAAdivinar < numeroIntroducido) {
						System.out.println("Menor");
					}
					System.out.println("Vidas restantes: "+this.getVidas());
				}
			}			
			
		} while (this.getVidas()>=0 && numeroAAdivinar != numeroIntroducido);
	}
	
	public boolean validaNumero(int numeroIntroducido) {
		if(numeroIntroducido >= 0 && numeroIntroducido <=10) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void muestraNombre() {
		System.out.println("*** Adivina un número ***");
		
	}

	@Override
	public void muestraInfo() {
		System.out.println("Intenta adivinar el número oculto entre 0 y 10 (incluidos)");
		System.out.println("[Te quedan "+this.getVidas()+" vidas]");
		
	}

	@Override
	public void reiniciaPartida() {
		super.reiniciaPartida();
		this.numeroAAdivinar = rand.nextInt(11);
	}

}
