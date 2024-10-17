package view;

import java.util.ArrayList;
import java.util.Random;

import model.Cancion;

public class App {
	
	public static void main(String[] args) {
		
		ArrayList<Cancion> listaCanciones = new ArrayList<>();
		
		//Crear instancias de cancion
		
		Cancion c1 = new Cancion("Letra de canción 1", 180, "Título 1");
		Cancion c2 = new Cancion("Letra de canción 2", 201, "Título 2");
		Cancion c3 = new Cancion("Letra de canción 3", 253, "Título 3");
		Cancion c4 = new Cancion("Letra de canción 4", 248, "Título 4");
		Cancion c5 = new Cancion("Letra de canción 5", 352, "Título 5");
		
		//Añadirlas al arrayList
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		listaCanciones.add(c4);
		listaCanciones.add(c5);
		
		//Añadir las canciones al arrayList al crearlas directamente
		
		listaCanciones.add(new Cancion("Letra de canción 6", 412, "Título 6"));
		listaCanciones.add(new Cancion("Letra de canción 7", 238, "Título 7"));
		listaCanciones.add(new Cancion("Letra de canción 8", 196, "Título 8"));
		listaCanciones.add(new Cancion("Letra de canción 9", 275, "Título 9"));
		listaCanciones.add(new Cancion("Letra de canción 10", 246, "Título 10"));
		
		//Recorrer el arrayList y mostrar los datos de cada canción en orden:
		System.out.println("Canciones en orden:");
		for(int i=0; i<listaCanciones.size()-1; i++) {
			
			String nombre = listaCanciones.get(i).getNombre();
			int duracion = listaCanciones.get(i).getDuracion();
			String letra = listaCanciones.get(i).getLetra();
			
			System.out.println("*** "+nombre+" ("+duracion+"s) - "+letra+" ***");
		}
		
		
		//Recorrer el arrayList y mostrar los datos de cada canción aleatoriamente sin repetirlas:
		System.out.println("\nCanciones aleatorias:");
		ArrayList indices = new ArrayList<>();
		
		while(indices.size() != listaCanciones.size()) {

			Random rand = new Random();
			int aleatorio = rand.nextInt(10);
			
			if(indices.contains(aleatorio) == false) {
				
				indices.add(aleatorio);
				
				String nombre = listaCanciones.get(aleatorio).getNombre();
				int duracion = listaCanciones.get(aleatorio).getDuracion();
				String letra = listaCanciones.get(aleatorio).getLetra();
				
				System.out.println("*** "+nombre+" ("+duracion+"s) - "+letra+" ***");
			}
			
		}
		
	}

}
