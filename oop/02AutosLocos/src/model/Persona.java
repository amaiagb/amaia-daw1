package model;

public class Persona {
	public String nombre;
	public int edad;
	public float altura;
	public Coche coche;
	
	
	
	//(Generar constructor: right click > source > generate using fields)
	public Persona(String nombre, int edad, float altura, Coche coche) {
		//super();
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.coche = coche;
	}

	//metodos: arrancar, repostar, chocar 
	public void arrancar() {
		System.out.println(this.nombre+" está intentando arrancar");
		this.coche.arrancar();
	}
	
	public void repostar() {
		System.out.println("Repostando");
	}
	/**
	 * 
	 * @param p Recibe la persona cuyo coche quiere chocar
	 * @return devuelve ... 
	 */
	public void chocar(Persona otraPersona) {
		this.coche.vida = this.coche.vida-otraPersona.coche.fuerza;
		otraPersona.coche.vida -= this.coche.fuerza;
		
		//TODO COMPROBAR MUERTES
	}
	
}
