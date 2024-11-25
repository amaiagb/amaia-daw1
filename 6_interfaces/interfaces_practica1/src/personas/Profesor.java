package personas;

import model.Hablador;

public class Profesor extends Persona implements Hablador{
	public String despacho;
	public String email;
	
	public Profesor(String nombre, int edad, String despacho, String email) {
		super(nombre, edad);
		this.despacho = despacho;
		this.email = email;
	}
	
	@Override
	public void hablar() {
		System.out.println("Hola, soy un "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Edad: " + edad + ", Despacho: " + despacho + ", Email: " + email + "";
	}
	
}
