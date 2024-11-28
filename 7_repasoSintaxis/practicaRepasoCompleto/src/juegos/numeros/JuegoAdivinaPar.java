package juegos.numeros;

import juegos.interfaces.Jugable;

public class JuegoAdivinaPar extends JuegoAdivinaNumero implements Jugable{

	public JuegoAdivinaPar(int vidas) {
		super(vidas);
	}
	
	@Override
	public boolean validaNumero(int numeroIntroducido) {
		if(numeroIntroducido%2 == 0) {
			return true;
		}  else {
			System.out.println("Error: numero impar");
			return false;
		}
	}
	@Override
	public void muestraNombre() {
		System.out.println("*** Adivina un número par ***");
	}
	
	@Override
	public void muestraInfo() {
		System.out.println("Intenta adivinar el número PAR oculto entre 0 y 10 (incluidos)");
		System.out.println("[Te quedan "+this.getVidas()+" vidas]");
	}
	@Override
	public void reiniciaPartida() {
		super.reiniciaPartida();
		if(this.numeroAAdivinar%2!=0) this.numeroAAdivinar++;
	}
}
