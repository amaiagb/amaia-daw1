package panelsTest.app;

import java.util.ArrayList;

import panelTest.model.Objeto;
import panelsTest.view.Ventana;

public class App {

	
	public static void main(String[] args) {
		
		ArrayList<Objeto> objetosInventario = new ArrayList<>();

		objetosInventario.add(new Objeto("llave","llave.png", "Una llave met�lica, demasiado peque�a para una puerta, quiz� sea de alg�n candado"));
		objetosInventario.add(new Objeto("nota","note.png", "Una nota con un c�digo escrito"));
		objetosInventario.add(new Objeto("destornillador","destornillador.png", "Un destornillador, siempre es �til tener herramientas"));
		objetosInventario.add(new Objeto("sandwich","sandwich.png", "El sandwich para comer en el recreo"));
		
		Ventana frame = new Ventana(objetosInventario);
		frame.setVisible(true);
	}

}
