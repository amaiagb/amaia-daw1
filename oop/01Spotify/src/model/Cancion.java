package model;

public class Cancion {
	
	//Atributos / Variables
	//TipoDato NombreVariable [= Valor]; (el valor es opcional)
	
	public String nombre;
	public String letra;
	public int duracion; //en segundos
	
	//Constructores (NombreClase(args...)
	//sirve para inicializar los atributos al generar el objeto
	
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
	
	
	//Comportamientos / Metodos
	//visibilidad retorno NombreMetodo ([argumentos])
	
	public void mostrarLetra() {
		System.out.println(this.letra);
	}
	
}
