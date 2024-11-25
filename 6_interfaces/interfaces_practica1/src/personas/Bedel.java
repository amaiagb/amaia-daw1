package personas;

import model.Hablador;

public class Bedel extends Persona implements Hablador{
	public String turno;
	public int antiguedad;
	
	public Bedel(String nombre, int edad, String turno, int antiguedad) {
		super(nombre, edad);
		this.turno = turno;
		this.antiguedad = antiguedad;
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy un "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Edad: " + edad + ", Turno: " + turno + ", Antiguedad: " + antiguedad + "";
	}
	
}
