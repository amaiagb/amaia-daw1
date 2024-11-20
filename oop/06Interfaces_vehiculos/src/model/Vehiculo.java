package model;

public class Vehiculo {
	public int velocidad;
	public String modelo;
	
	public int ruedas;
	public double eslora;
	
	public Vehiculo(int velocidad, String modelo) {
		this.velocidad = velocidad;
		this.modelo = modelo;
	}

	public void arrancar() {
		System.out.println("Arrancando");
	}
}
