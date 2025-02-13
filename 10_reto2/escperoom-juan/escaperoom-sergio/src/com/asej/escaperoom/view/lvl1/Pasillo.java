package com.asej.escaperoom.view.lvl1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pasillo extends JPanel {
	
	//private static final long serialVersionUID = 1L;
	//private JPanel contentPane;
	//private JTextField tiempo_textField;
	//private JTextPane textPane;
	//private int contador = 0;
	//private int segundos=3600;
	//private Clip clipBoton;
	//private Clip clipClick;
	
	public Pasillo(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrHabitacion = new JButton();
		btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnIrHabitacion.setBounds(1000, 350, 70, 65);
		btnIrHabitacion.setContentAreaFilled(false); 
		btnIrHabitacion.setBorderPainted(false); 
		btnIrHabitacion.setFocusable(false);
		add(btnIrHabitacion);
		
		JButton btnIrTerraza = new JButton();
		btnIrTerraza.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrTerraza.setBounds(10, 350, 70, 65);
		btnIrTerraza.setContentAreaFilled(false); 
		btnIrTerraza.setBorderPainted(false); 
		btnIrTerraza.setFocusable(false);
		add(btnIrTerraza);
		
		JButton btnIrSalon = new JButton();
		btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
		btnIrSalon.setBounds(510, 550, 70, 65);
		btnIrSalon.setContentAreaFilled(false); 
		btnIrSalon.setBorderPainted(false); 
		btnIrSalon.setFocusable(false);
		add(btnIrSalon);
		
		JLabel lblPuertaSalir = new JLabel("");
		lblPuertaSalir.setBounds(405, 143, 281, 396);
		add(lblPuertaSalir);
		
		JLabel lblIrCalle = new JLabel("");
		lblIrCalle.setBounds(540, 156, 124, 383);
		lblIrCalle.setVisible(false);
		add(lblIrCalle);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\pasillo.jpg"));
		lblFondo.setBounds(0, 0, 1084, 723);
		add(lblFondo);
	

		btnIrHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				ventana.showEscena("Habitacion");
			}
		});
		
		btnIrTerraza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				ventana.showEscena("Terraza");
			}
		});		

		btnIrSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				ventana.showEscena("Salon");
			}
		});

		lblPuertaSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Cocina.misionesCompletadas == Cocina.OBJETIVO_MISIONES) {
					lblFondo.setIcon(new ImageIcon("resources\\images\\puerta_abierta.jpg"));
					lblPuertaSalir.setVisible(false);
					lblIrCalle.setVisible(true);
				} else {
					Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("pasillo1"));
					
				}
			}
		});

		lblIrCalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Calle");
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("pasillo2"));
			}
		});
		
		btnIrSalon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaAbajoPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
			}
		});
		
		btnIrTerraza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrTerraza.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrTerraza.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
		btnIrHabitacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrHabitacion.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});
		
		setVisible(true);
	}
	


}