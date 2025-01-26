package tests;

import java.util.ArrayList;

public class AppPruebaInventario {

	public static void main(String[] args) {
		
		ArrayList<Objeto> objetosInventario = new ArrayList<>();
		
		objetosInventario.add(new Objeto("llave","llave.png", "Una llave metálica, demasiado pequeña para una puerta, quizá sea de algún candado"));
		objetosInventario.add(new Objeto("nota","note.png", "Una nota con un código escrito"));
		objetosInventario.add(new Objeto("destornillador","destornillador.png", "Un destornillador, siempre es útil tener herramientas"));
		objetosInventario.add(new Objeto("sandwich","sandwich.png", "El sandwich para comer en el recreo"));
		
		VentanaInicioInventario frame = new VentanaInicioInventario(objetosInventario);
		frame.setVisible(true);
		

	}

}
