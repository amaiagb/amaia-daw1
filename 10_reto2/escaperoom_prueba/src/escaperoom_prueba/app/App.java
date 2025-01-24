package escaperoom_prueba.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

//import java.util.Timer;
//import java.util.TimerTask;
import javax.swing.*;

import db.AccesoDBEscaperoom;
import escaperoom_prueba.model.TimerEjemplo;
import escaperoom_prueba.ui.Ventana1;
import escaperoom_prueba.ui.VentanaInicio;
import tests.Objeto;
import tests.TestTxt;
import tests.VentanaInventario;

public class App {
	private static int segundos = 0;
	private static Timer timer;

	public static void main(String[] args) {
		
		/*
		VentanaInicio frame = new VentanaInicio();
		frame.setVisible(true);
		*/
		
		/*
		//PROBAR ACCESO DB
		try {
			AccesoDBEscaperoom bd = new AccesoDBEscaperoom();
			TestTxt ventanaTexto = new TestTxt(bd);
			ventanaTexto.setVisible(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		*/
		//PROBAR GESTI�N INVENTARIO
		ArrayList<Objeto> objetosInventario = new ArrayList<>();
		
		objetosInventario.add(new Objeto("llave","llave.png", "Una llave met�lica, demasiado peque�a para una puerta, quiz� sea de alg�n candado"));
		objetosInventario.add(new Objeto("nota","note.png", "Una nota con un c�digo escrito"));
		objetosInventario.add(new Objeto("destornillador","destornillador.png", "Un destornillador, siempre es �til tener herramientas"));
		
		VentanaInventario frame = new VentanaInventario(objetosInventario);
		frame.setVisible(true);
		
		
		


	}

}
