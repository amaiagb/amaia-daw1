package escaperoom_prueba.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//import java.util.Timer;
//import java.util.TimerTask;
import javax.swing.*;

import db.AccesoDBEscaperoom;
import escaperoom_prueba.model.TimerEjemplo;
import escaperoom_prueba.ui.Ventana1;
import escaperoom_prueba.ui.VentanaInicio;
import tests.TestTxt;

public class App {
	private static int segundos = 0;
	private static Timer timer;

	public static void main(String[] args) {
		
		/*
		VentanaInicio frame = new VentanaInicio();
		frame.setVisible(true);
		*/
		
		try {
			AccesoDBEscaperoom bd = new AccesoDBEscaperoom();
			TestTxt ventanaTexto = new TestTxt(bd);
			ventanaTexto.setVisible(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		



	}

}
