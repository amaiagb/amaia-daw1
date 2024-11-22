package view;

import model.Hablador;
import aves.*;
import aparatos.*;
import personas.*;

public class App {

	public static void main(String[] args) {

		Object[] objetos = new Object[12];
		
		objetos[0]=new Persona("Juan",26);
		objetos[1]=new Ave("hembra",3);
		objetos[2]=new Aparato(100,10000);
		objetos[3]=new Buitre("macho",6,122,30);
		objetos[4]=new Canario("hembra",4,"a veces");
		objetos[5]=new Loro("macho", 2, "Europa", "azul");
		objetos[6]=new Piolin("macho", 6, "En la ducha", 10);
		objetos[7]=new Alumno("Marta", 22, "Informática", 3);
		objetos[8]=new Profesor("Jesús", 35, "555-D", "info@email.com");
		objetos[9]=new Bedel("Dani", 40, "Tarde", 10); 
		objetos[10]=new TV(100, 300000, true, 28);
		objetos[11]=new Radio(50, 150000, false, 25);
		
		for (int i = 0; i < objetos.length; i++) {
			if(objetos[i] instanceof Hablador) {
				((Hablador) objetos[i]).hablar();
				System.out.println();
			}
		}
	}

	
}
