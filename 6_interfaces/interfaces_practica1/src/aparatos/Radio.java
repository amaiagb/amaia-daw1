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
		System.out.print("Consumo: "+consumo);
		System.out.print(". Precio: "+precio);
		System.out.print(". Casette: "+casette);
		System.out.print(". Potencia: "+potencia);
		System.out.println();
	}

}
