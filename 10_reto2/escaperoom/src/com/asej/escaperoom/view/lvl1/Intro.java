package com.asej.escaperoom.view.lvl1;

import javax.swing.JPanel;

import com.asej.escaperoom.view.Ventana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Intro extends JPanel {


	public Intro(Ventana ventana) {
		setBackground(Color.BLACK);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Habitacion");
				Ventana.quitarTextoPantalla();
			}
		});
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		//ventana.getPanelTextos().setVisible(true);
		Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("intro"));
		//Ventana.mostrarTextoPantalla("*riiiiing riiiiiing*\n¡Hora de despertarse, hijo! Que sino vas a llegar tarde a clase" );
		
		
		
		
	}

}
