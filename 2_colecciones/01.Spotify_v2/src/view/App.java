package view;

import java.util.ArrayList;
import java.util.Random;

import model.Cancion;

public class App {
	
	public static void main(String[] args) {
		
		ArrayList<Cancion> listaCanciones = new ArrayList<>();
		
		//Crear instancias de cancion
		
		Cancion c1 = new Cancion("Letra de canci�n 1", 180, "T�tulo 1");
		Cancion c2 = new Cancion("Letra de canci�n 2", 201, "T�tulo 2");
		Cancion c3 = new Cancion("Letra de canci�n 3", 253, "T�tulo 3");
		Cancion c4 = new Cancion("Letra de canci�n 4", 248, "T�tulo 4");
		Cancion c5 = new Cancion("Letra de canci�n 5", 352, "T�tulo 5");
		
		//A�adirlas al arrayList
		
		listaCanciones.add(c1);
		listaCanciones.add(c2);
		listaCanciones.add(c3);
		listaCanciones.add(c4);
		listaCanciones.add(c5);
		
		//A�adir las canciones al arrayList al crearlas directamente
		
		listaCanciones.add(new Cancion("Letra de canci�n 6", 412, "T�tulo 6"));
		listaCanciones.add(new Cancion("Letra de canci�n 7", 238, "T�tulo 7"));
		listaCanciones.add(new Cancion("Letra de canci�n 8", 196, "T�tulo 8"));
		listaCanciones.add(new Cancion("Letra de canci�n 9", 275, "T�tulo 9"));
		listaCanciones.add(new Cancion("Letra de canci�n 10", 246, "T�tulo 10"));
		
		//Recorrer el arrayList y mostrar los datos de cada canci�n en orden:
		System.out.println("Canciones en orden:");
		for(int i=0; i<listaCanciones.size()-1; i++) {
			
			String nombre = listaCanciones.get(i).getNombre();
			int duracion = listaCanciones.get(i).getDuracion();
			String letra = listaCanciones.get(i).getLetra();
			
			System.out.println("*** "+nombre+" ("+duracion+"s) - "+letra+" ***");
		}
		
		
		//Recorrer el arrayList y mostrar los datos de cada canci�n aleatoriamente sin repetirlas:
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
