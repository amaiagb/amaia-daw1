package model;

public class Barco extends Acuatico implements IAcuatico{

	public Barco(int velocidad, String modelo, double eslora) {
		super(velocidad, modelo, eslora);
		
	}

	public void navegar() {
		System.out.println("Navegando");
		
	}
	
}
