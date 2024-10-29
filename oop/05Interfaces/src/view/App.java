package view;

import model.Drone;
import model.IAeronave;
import model.IEspacial;

public class App {
	
	/*
	 * INTERFACES
	 * Pueden ser public o package
	 * Se usa implements en lugar de extends
	 * Las interfaces, entre ellas sí que hacen extends 
	 * Todos sus metodos son public abstract y los atributos son final static
	 *   
	 * */
	
	public static void main(String[] args) {
		Drone d = new Drone();
		d.volar();
		d.orbitar();
		
		IEspacial dEspacial =  d; 
		//es el mismo drone, d y dEspacial son el mismo, pero en dEspacial solo tiene los comportamientos de IEspacial
		//dEspacial.volar(); No puede volar. Solo puede orbitar
		dEspacial.orbitar();
		
		//Comportamiento de vehiculo aeronave
		IAeronave dAeronave = d;
		dAeronave.volar();
		
		//Ahora si ambas interfaces tienen la variable (final static) velocidad no sería ambiguo
		System.out.println(dEspacial.velocidad);
		System.out.println(dAeronave.velocidad);
	}

}



