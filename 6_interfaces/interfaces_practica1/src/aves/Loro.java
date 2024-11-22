package aves;

import model.Hablador;

public class Loro extends Ave implements Hablador{

	public String region;
	public String color;
	
	public Loro(String sexo, int edad, String region, String color) {
		super(sexo, edad);
		this.region = region;
		this.color = color;
	}

	@Override
	public void hablar() {
		System.out.println("Hola, soy un "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.print("Sexo: "+sexo);
		System.out.print(". Edad: "+edad);
		System.out.print(". Región: "+region);
		System.out.print(". Color: "+color);
		System.out.println();
	}
	
	
}
