package escaperoom_prueba.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;
//import java.util.TimerTask;
import javax.swing.*;

import escaperoom_prueba.model.TimerEjemplo;
import escaperoom_prueba.ui.Ventana1;
import escaperoom_prueba.ui.VentanaInicio;

public class App {
	private static int segundos = 0;
	private static Timer timer;

	public static void main(String[] args) {
		
		VentanaInicio frame = new VentanaInicio();
		frame.setVisible(true);
		
		
		
		/*
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		    int i = 100;
		    public void run(){
		        if (i >= 0) {
		        	i--;
		            String time = String.format("%02d:%02d", i / 60, i % 60);
		            System.out.println(time); 
		        }
		    }
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
*/

	}

}
