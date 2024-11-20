package view;

import model.Anfibio;
import model.Barco;
import model.Coche;

public class App {

	public static void main(String[] args) {
		
		Coche c = new Coche(120, "Ford", 4);
		//c.eslora = 7.5;
		System.out.println("Modelo: "+c.modelo+". Ruedas: "+ c.ruedas);
		c.arrancar();
		c.conducir();
		
		Anfibio a = new Anfibio(80, "Amphicar", 6, 2.5);
		System.out.println("Modelo: "+a.modelo+". Ruedas: "+ a.ruedas+". Eslora: "+a.eslora);
		a.arrancar();
		a.conducir();
		a.navegar();
		
		Barco b = new Barco(200, "Crucero", 11.5);
		//b.ruedas = 0;
		System.out.println("Modelo: "+b.modelo+". Eslora: "+b.eslora);
		b.arrancar();
		b.navegar();
		

	}

}
