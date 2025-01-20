package parejas.view;

import java.util.ArrayList;

import model.Carta;
import parejas.ui.tablero;

public class App {

	public static void main(String[] args) {
		
		
		ArrayList<Carta> cartas = new ArrayList<>();
		cartas.add(new Carta(1, "verde", "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img1.jpg", false, false));
		cartas.add(new Carta(2, "rojo", "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img2.jpg", false, false));
		cartas.add(new Carta(3, "amarillo", "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img3.jpg", false, false));
		cartas.add(new Carta(4, "rojo", "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img4.jpg", false, false));
		
		tablero frame = new tablero(cartas);
		frame.setVisible(true);

	}

}
