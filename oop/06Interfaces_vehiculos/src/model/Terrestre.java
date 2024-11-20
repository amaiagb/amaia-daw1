package model;

public class Terrestre extends Vehiculo{
	
	private double eslora;
	
	public Terrestre(int velocidad, String modelo, int ruedas) {
		super(velocidad, modelo);
		this.ruedas = ruedas;
	}
	
}
