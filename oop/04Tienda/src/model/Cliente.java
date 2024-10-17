package model;

public class Cliente extends Persona{
	
	public float saldo;
	
	public Cliente(String nombre, float saldo) {
		super(nombre);
		this.saldo = saldo;
	}

	public void comprar(String producto, Vendedor vendedor, float precio, int unidad) {
		
		float total = precio*unidad; 
		if(this.saldo > total) {
			vendedor.vender(total);
		}
	}
	
	
}
