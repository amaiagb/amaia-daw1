package model;

public class Anfibio extends Vehiculo implements ITerrestre,IAcuatico{
	
	public Anfibio(int velocidad, String modelo, int ruedas, double eslora) {
		super(velocidad, modelo);
		this.ruedas = ruedas;
		this.eslora = eslora;
	}

	public void navegar() {
		System.out.println("Navegando");
	}

	public void conducir() {
		System.out.println("Conduciendo");
		
	}

}
