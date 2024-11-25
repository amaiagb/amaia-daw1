package aves;

import model.Hablador;

public class Piolin extends Canario implements Hablador{

	public int numPeliculas;

	public Piolin(String sexo, int edad, String canta, int numPeliculas) {
		super(sexo, edad, canta);
		this.numPeliculas = numPeliculas;
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Sexo: " + sexo + ", Edad: " + edad + ", Canta: " + canta + ", Películas: " + numPeliculas + "";
	}
}
