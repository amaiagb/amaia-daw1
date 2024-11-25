package aparatos;

import model.Hablador;

public class Radio extends Aparato implements Hablador{
	
	public boolean casette;
	public double potencia;
	
	public Radio(int consumo, double precio, boolean casette, double potencia) {
		super(consumo, precio);
		this.casette = casette;
		this.potencia = potencia;
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy una "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Consumo: " + consumo + ", Precio: " + precio + ", Casette: " + casette + ", Potencia: " + potencia + "";
	}
}
