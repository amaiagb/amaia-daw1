package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Cancion;

public class App {
	
	public static void main(String[] args) {
		
		ArrayList<Cancion> listaCanciones = new ArrayList<>();
		
		//1. CREAR 10 CANCIONES Y GUARDARLAS EN UNA LISTA
		
		//Opci�n 1: Crear instancias de cancion + A�adirlas al arrayList
		
		Cancion c1 = new Cancion("Letra de canci�n 1", 180, "T�tulo 1");
		Cancion c2 = new Cancion("Letra de canci�n 2", 201, "T�tulo 2");
		Cancion c3 = new Cancion("Letra de canci�n 3", 253, "T�tulo 3");
		Cancion c4 = new Cancion("Letra de canci�n 4", 248, "T�tulo 4");
		Cancion c5 = new Cancion("Letra de canci�n 5", 352, "T�tulo 5");
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		listaCanciones.add(c4);
		listaCanciones.add(c5);
		
		//Opci�n 2: A�adir las canciones al arrayList directamente al crearlas
		
		listaCanciones.add(new Cancion("Letra de canci�n 6", 412, "T�tulo 6"));
		listaCanciones.add(new Cancion("Letra de canci�n 7", 238, "T�tulo 7"));
		listaCanciones.add(new Cancion("Letra de canci�n 8", 196, "T�tulo 8"));
		listaCanciones.add(new Cancion("Letra de canci�n 9", 275, "T�tulo 9"));
		listaCanciones.add(new Cancion("Letra de canci�n 10", 246, "T�tulo 10"));
		
		//2.1 MOSTRAR LAS CANCIONES EN ORDEN:
		System.out.println("Canciones en orden:");

		for(int i=0; i<listaCanciones.size(); i++) {
			
			String nombre = listaCanciones.get(i).getNombre();
			int duracion = listaCanciones.get(i).getDuracion();
			String letra = listaCanciones.get(i).getLetra();
			
			System.out.println("*** "+nombre+" ("+duracion+"s) - "+letra+" ***");
		}
		
		
		//2.2 MOSTRAR LAS CANCIONES ALEATORIAMENTE (sin repeticiones):
		System.out.println("\nCanciones aleatorias:");
		ArrayList<Integer> indices = new ArrayList<>();
		
		while(indices.size() != listaCanciones.size()) {

			Random rand = new Random();
			int aleatorio = rand.nextInt(listaCanciones.size());
			
			if(!indices.contains(aleatorio)) {
				
				indices.add(aleatorio);
				
				String nombre = listaCanciones.get(aleatorio).getNombre();
				int duracion = listaCanciones.get(aleatorio).getDuracion();
				String letra = listaCanciones.get(aleatorio).getLetra();
				
				System.out.println("*** "+nombre+" ("+duracion+"s) - "+letra+" ***");
			}
		}
		
		//2.3 MEJORAR EL C�DIGO SOBREESRIBIENDO EL M�TODO toString
		System.out.println("\nCanciones aleatorias:");
		ArrayList<Integer> indices2 = new ArrayList<>();
				
		while(indices2.size() != listaCanciones.size()) {

			Random rand = new Random();
			int aleatorio2 = rand.nextInt(10);
			
			if(indices2.contains(aleatorio2) == false) {
				
				indices2.add(aleatorio2);
				System.out.println(listaCanciones.get(aleatorio2));
			}
			
		}
		
		//EL M�TODO SHUFFLE() REORDENA AUTOMATICAMENTE LOS ELEMENTOS DE LA LISTA
		//Collections.shuffle(listaCanciones);
		
	}

}