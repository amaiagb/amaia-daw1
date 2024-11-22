package personas;

import model.Hablador;

public class Alumno extends Persona implements Hablador{
	
	public String carrera;
	public int curso;

	public Alumno(String nombre, int edad, String carrera, int curso) {
		super(nombre, edad);
		this.carrera = carrera;
		this.curso = curso;
	}
	@Override
	public void hablar() {
		System.out.println("Hola, soy un "+this.getClass().getSimpleName()+" y sé hablar");
		System.out.print("Nombre: "+nombre);
		System.out.print(". Edad: "+edad);
		System.out.print(". Carrera: "+carrera);
		System.out.print(". Curso: "+curso);
		System.out.println();
	}
	
}
