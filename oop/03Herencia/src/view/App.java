package view;

import model.Futbolista;
import model.Persona;
import model.Piloto;

public class App {

	public static void main(String[] args) {
		
		Persona p = new Persona();
		Futbolista f = new Futbolista();
		Piloto pi = new Piloto();
		
		f.saludar(); //Polimorfismo (mismo metodo diferentes clases)
		pi.saludar();
		
		Persona personita = new Futbolista(); //cualquier padre puede albergar a cualquiera de sus hijos
		
	}

}
