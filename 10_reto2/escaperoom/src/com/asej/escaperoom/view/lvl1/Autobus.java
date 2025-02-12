package com.asej.escaperoom.view.lvl1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.asej.escaperoom.view.Ventana;

public class Autobus extends JPanel {

	static Timer timer;
	private int segundos = 0;
	
	public Autobus(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\bus.jpg"));
		lblFondo.setBounds(0, 0, 1084, 723);
		add(lblFondo);
		
		timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	segundos++;
            	Ventana.mostrarTextoPantalla("Ya hemos llegado al colegio");
            	
                if (segundos == 3) {
                	
                	ventana.showEscena("Movil");
                	Ventana.quitarTextoPantalla();
                    timer.stop();
                }
            }
        });
		
	}

}
