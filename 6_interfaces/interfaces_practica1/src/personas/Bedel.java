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
		System.out.println("Hola, soy un "+this.getClass().getSimpleName()+" y s� hablar");
		System.out.print("Nombre: "+nombre);
		System.out.print(". Edad: "+edad);
		System.out.print(". Turno: "+turno);
		System.out.print(". Antig�edad: "+antiguedad);
		System.out.println();
	}
	
}
