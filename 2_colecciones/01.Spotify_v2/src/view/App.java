package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import model.Cancion;

public class App {
	
	public static void main(String[] args) {
		
		ArrayList<Cancion> listaCanciones = new ArrayList<>();
		
		//1. CREAR 10 CANCIONES Y GUARDARLAS EN UNA LISTA
		
		//Opción 1: Crear instancias de cancion + Añadirlas al arrayList
		
		Cancion c1 = new Cancion("Letra de canción 1", 180, "Título 1");
		Cancion c2 = new Cancion("Letra de canción 2", 201, "Título 2");
		Cancion c3 = new Cancion("Letra de canción 3", 253, "Título 3");
		Cancion c4 = new Cancion("Letra de canción 4", 248, "Título 4");
		Cancion c5 = new Cancion("Letra de canción 5", 352, "Título 5");
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		listaCanciones.add(c4);
		listaCanciones.add(c5);
		
		//Opción 2: Añadir las canciones al arrayList directamente al crearlas
		
		listaCanciones.add(new Cancion("Letra de canción 6", 412, "Título 6"));
		listaCanciones.add(new Cancion("Letra de canción 7", 238, "Título 7"));
		listaCanciones.add(new Cancion("Letra de canción 8", 196, "Título 8"));
		listaCanciones.add(new Cancion("Letra de canción 9", 275, "Título 9"));
		listaCanciones.add(new Cancion("Letra de canción 10", 246, "Título 10"));
		
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
		
		//2.3 MEJORAR EL CÓDIGO SOBREESRIBIENDO EL MÉTODO toString
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
		
		//EL MÉTODO SHUFFLE() REORDENA AUTOMATICAMENTE LOS ELEMENTOS DE LA LISTA
		//Collections.shuffle(listaCanciones);
		
	}

}