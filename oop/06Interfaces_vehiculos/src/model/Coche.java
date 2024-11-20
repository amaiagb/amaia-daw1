package model;

public class Coche extends Terrestre implements ITerrestre{
	
	public Coche(int velocidad, String modelo, int ruedas) {
		super(velocidad, modelo, ruedas);
	}

	public void conducir() {
		System.out.println("Conduciendo");
		
		
	}
	
}
