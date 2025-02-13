package com.asej.escaperoom.view.lvl1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;

public class Terraza extends JPanel {
/*
	private JTextField tiempo_textField;
	private JTextPane textPane;
	
	private int segundos=3600;
	private Clip clipBoton;
	private Clip clipClick;
	*/
	private int contador = 0;
	
	public Terraza(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrPasillo = new JButton();
		btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnIrPasillo.setBounds(1000, 350, 70, 65);
		btnIrPasillo.setContentAreaFilled(false); 
		btnIrPasillo.setBorderPainted(false); 
		btnIrPasillo.setFocusable(false);
		add(btnIrPasillo);
		
		JButton btnPerro = new JButton("");
		btnPerro.setBounds(395, 499, 89, 82);
		btnPerro.setOpaque(true); 
		btnPerro.setContentAreaFilled(false); 
		btnPerro.setBorderPainted(false);
		add(btnPerro);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\terraza.jpg"));
		lblFondo.setBounds(0, 0, 1084, 700);
		add(lblFondo);
		

		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Pasillo");
			}
		});

		btnPerro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ladrar();
				
			}
		});
		
		btnIrPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});
		
	setVisible(true);	
	}
	public void ladrar(){
		contador++;
		if (contador % 3 == 0) {
			Audio.reproducirEfectoSonido(Audio.GATO);
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("maullido"));
			contador = 0;
		} else {
			Audio.reproducirEfectoSonido(Audio.PERRO);
			Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("ladrido"));
			}
	}
}
