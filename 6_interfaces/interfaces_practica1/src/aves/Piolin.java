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
		System.out.print("Sexo: "+sexo);
		System.out.print(". Edad: "+edad);
		System.out.print(". Canta: "+canta);
		System.out.print(". Películas: "+numPeliculas);
		System.out.println();
	}
	
}
