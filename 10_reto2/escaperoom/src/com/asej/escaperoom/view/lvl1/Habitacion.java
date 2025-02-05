package com.asej.escaperoom.view.lvl1;

import java.awt.Color;
import java.awt.Image;
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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.view.Ventana;
import java.awt.Font;
import java.awt.Component;

public class Habitacion extends JPanel {

	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
    private JTextPane txtDialogo;
    private Clip clipBoton;
	private Clip clipClick;
	private Ventana ventana;
	
	public Habitacion(Ventana ventana) {
		
		this.ventana = ventana;
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrPasillo = new JButton("<");
		btnIrPasillo.setBounds(10, 344, 46, 64);
		add(btnIrPasillo);
		
		JButton btnMochila = new JButton("");
		btnMochila.setOpaque(true); 
		btnMochila.setContentAreaFilled(false); 
		btnMochila.setBorderPainted(false); 
		btnMochila.setBounds(430, 440, 40, 40);
		add(btnMochila);
		
		JButton btnCajon = new JButton("");
		btnCajon.setOpaque(true); 
		btnCajon.setContentAreaFilled(false); 
		btnCajon.setBorderPainted(false);
		btnCajon.setBounds(221, 534, 53, 50);
		add(btnCajon);
		
		JButton btnReloj = new JButton("");
		btnReloj.setOpaque(true); 
		btnReloj.setContentAreaFilled(false); 
		btnReloj.setBorderPainted(false); 
		btnReloj.setBounds(860, 85, 111, 196);
		add(btnReloj);
		
		JButton btnOrdenador = new JButton("");
		btnOrdenador.setBounds(739, 289, 219, 289);
		btnOrdenador.setOpaque(true); 
		btnOrdenador.setContentAreaFilled(false); 
		btnOrdenador.setBorderPainted(false); 
		add(btnOrdenador);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\habitacion.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.reproducirMusicaBoton();
				Ventana.mostrarTextoPantalla("");
				ventana.showEscena("Pasillo");
			}
		});

		btnCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("No hurges en la ropa que la ensucias");
			}
		});

		btnReloj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("¡Oh no! Son las 07:25. Debes darte prisa si no quieres llegar tarde.");
			}
		});

		btnOrdenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("Ahora no es momento de jugar al LOL");
			}
		});

		btnMochila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("¡Bien! ¡Has encontrado la mochila!");
			}
		});
		
		setVisible(true);

	}


}
