package aves;

public class Buitre extends Ave{

	public double velocidadVuelo;
	public double peso;
	
	public Buitre(String sexo, int edad, double velocidadVuelo, double peso) {
		super(sexo, edad);
		this.velocidadVuelo = velocidadVuelo;
		this.peso = peso;
	}
	
	
}
