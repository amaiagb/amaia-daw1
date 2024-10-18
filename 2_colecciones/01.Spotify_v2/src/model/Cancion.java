package model;

public class Cancion {
	
	private String nombre;
	private String letra;
	private int duracion; //en segundos
	
	public Cancion() { //Constructor por defecto
	}
	
	public Cancion(String letra, int duracion, String nombre) {
		
		//0. Validar datos
		if(duracion<=0) {
			duracion = 100;
		}
		
		//1. Asignar datos
		this.nombre = nombre;
		this.letra = letra;
		this.duracion = duracion;
	}
	
	public void mostrarLetra() {
		System.out.println(this.letra);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String toString() //Sobreescribir el metodo toString
    { 
        return "*** " +this.nombre+ " (" +this.duracion+ "s) - "+this.letra+" ***"; 
    } 
	
	
}
