package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.asej.escaperoom.view.Ventana;

public class Conversacion extends JPanel {

	public Conversacion(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrColegio = new JButton("New button");
		btnIrColegio.setBounds(969, 660, 89, 23);
		add(btnIrColegio);
		
		Ventana.mostrarTextoPantalla("Bruno, necesito encontrar el cromo como sea, empezaremos buscando por la clase de  informática y si no encontramos nada, tendremos que ir a mirar en las taquillas.¡Vamos!");
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\manuell.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		btnIrColegio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Exterior");
			}
		});
	}
}
