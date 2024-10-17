package model;

public class Vendedor extends Persona{
	
	public Vendedor(String nombre) {
		super(nombre);
	}

	public float acumuladoVentas;
	
	public void vender(float total) {
		acumuladoVentas += total;
	}

}
