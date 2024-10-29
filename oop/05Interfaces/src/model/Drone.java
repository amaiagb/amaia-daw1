package model;

public class Drone implements IAeronave,IEspacial{

	public void volar() {
		System.out.println("Volando");
		
	}

	public void orbitar() {
		System.out.println("Orbitando");
	}

}
