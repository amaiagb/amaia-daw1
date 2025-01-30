package parejas.view;

import java.util.ArrayList;

import model.Carta;
import parejas.ui.tablero;

public class App {

	public static void main(String[] args) {
		
		
		ArrayList<Carta> cartas = new ArrayList<>();
		cartas.add(new Carta(1, "verde", "resources\\img1.jpg", false, false));
		cartas.add(new Carta(2, "rojo", "resources\\img2.jpg", false, false));
		cartas.add(new Carta(3, "amarillo", "resources\\img3.jpg", false, false));
		cartas.add(new Carta(4, "rojo", "resources\\img4.jpg", false, false));
		
		tablero frame = new tablero(cartas);
		frame.setVisible(true);

	}

}
