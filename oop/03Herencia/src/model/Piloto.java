package model;

public class Piloto extends Persona{
	
	public String coche;
	
	public void pilotar() {
		System.out.println("pilotando");
	}
	
	@Override
	public void saludar() {
		super.saludar(); //el equivalente al this pero de la clase padre
	}
	/*
	//Sobrecarga (varios metodos con el mismo nombre)
	public void saludar("te fundo") {
		System.out.println();
	}
	*/
}
