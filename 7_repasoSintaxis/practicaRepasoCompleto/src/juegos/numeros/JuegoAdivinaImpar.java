package juegos.numeros;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero{

	public JuegoAdivinaImpar(int vidas) {
		super(vidas);
	}
	
	@Override
	public boolean validaNumero(int numeroIntroducido) {
		if(numeroIntroducido%2 != 0) {
			return true;
		}  else {
			System.out.println("Error: numero par");
			return false;
		}
	}
	
	@Override
	public void muestraNombre() {
		System.out.println("*** Adivina un número impar ***");
	}
	
	@Override
	public void muestraInfo() {
		System.out.println("Intenta adivinar el número IMPAR oculto entre 0 y 10 (incluidos)");
		System.out.println("[Te quedan "+this.getVidas()+" vidas]");
		
	}
	@Override
	public void reiniciaPartida() {
		super.reiniciaPartida();
		if(this.numeroAAdivinar != 10) {
			if(this.numeroAAdivinar%2==0) this.numeroAAdivinar++;
		} else {
			this.numeroAAdivinar = 9;
		}
	}
}
