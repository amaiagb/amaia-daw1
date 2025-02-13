package com.asej.escaperoom.view.lvl1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cama extends JPanel {

	public static boolean mochilaEncontrada = false;
	public Cama(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrHabitacion = new JButton();
		btnIrHabitacion.setBounds(10, 350, 70, 65);
		btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrHabitacion.setContentAreaFilled(false); 
		btnIrHabitacion.setBorderPainted(false); 
		btnIrHabitacion.setFocusable(false);
		add(btnIrHabitacion);
		
		JLabel lblMochila = new JLabel("");
		lblMochila.setBounds(316, 315, 442, 286);
		add(lblMochila);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon("resources\\images\\cama.jpg"));
		lblFondo.setBounds(0, 0, 1084, 723);
		add(lblFondo);

		lblMochila.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mochilaEncontrada = true;
				Audio.reproducirEfectoSonido(Audio.COIN);
				Habitacion.btnCama.setVisible(false);
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("mochila"));
			}
		});
		
		btnIrHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Habitacion");
			}
		});
		
		btnIrHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));

			}
		});
		
	}

}
