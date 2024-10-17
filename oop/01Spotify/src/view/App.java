package view;

import model.Cancion;
//import model.*; importa todas las clases del paquete

public class App {

	
	public static void main(String[] args) {
		
		//Crear un objeto: NombreClase nombreObjeto = new NombreClase();
		Cancion c1 = new Cancion();
		c1.nombre = "Alehop";
		c1.letra = "Ale hop hop ... (letra de canción)";
		c1.duracion = 150;
		
		Cancion c3 = new Cancion("dale a tu...", -180, "Macarena");
		
		c3.mostrarLetra();
		c1.mostrarLetra();
		System.out.println(c3.duracion);
		
	}

}
