package aparatos;

import model.Hablador;

public class TV extends Aparato implements Hablador{
	
	public boolean teletexto;
	public int pulgadas;
	
	public TV(int consumo, double precio, boolean teletexto, int pulgadas) {
		super(consumo, precio);
		this.teletexto = teletexto;
		this.pulgadas = pulgadas;
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy una "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Consumo: " + consumo + ", Precio: " + precio + ", Teletexto: " + teletexto + ", Pulgadas: " + pulgadas + "";
	}
}
	
