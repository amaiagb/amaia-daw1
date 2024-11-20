package model;

public class Acuatico extends Vehiculo{
	
	private int ruedas;
	
	public Acuatico(int velocidad, String modelo, double eslora) {
		super(velocidad, modelo);
		this.eslora = eslora;
	}

}
