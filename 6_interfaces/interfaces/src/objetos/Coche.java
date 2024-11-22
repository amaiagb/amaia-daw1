package objetos;

import interfaces.Movible;

public class Coche implements Movible{

	@Override
	public void mover(int distancia) {
		System.out.println("El coche se mueve " + distancia + " metros");
		
	}

}
