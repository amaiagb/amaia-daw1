package com.asej.escaperoom.view.lvl1;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;

public class Salon extends JPanel {

	
	public Salon(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnIrPasillo = new JButton();
		btnIrPasillo.setBounds(510, 550, 70, 65);
		btnIrPasillo.setContentAreaFilled(false); 
		btnIrPasillo.setBorderPainted(false); 
		btnIrPasillo.setFocusable(false);
		btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
		add(btnIrPasillo);
		
		JButton btnIrCocina = new JButton();
		btnIrCocina.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnIrCocina.setBounds(1000, 350, 70, 65);
		btnIrCocina.setContentAreaFilled(false); 
		btnIrCocina.setBorderPainted(false); 
		btnIrCocina.setFocusable(false);
		add(btnIrCocina);
		
		JButton btnIrGaraje = new JButton();
		btnIrGaraje.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrGaraje.setBounds(10, 350, 70, 65);
		btnIrGaraje.setContentAreaFilled(false); 
		btnIrGaraje.setBorderPainted(false); 
		btnIrGaraje.setFocusable(false);
		add(btnIrGaraje);
		
		JButton btnSopaLetras = new JButton("");
		btnSopaLetras.setBounds(412, 563, 63, 15);
		btnSopaLetras.setOpaque(true); 
		btnSopaLetras.setContentAreaFilled(false); 
		btnSopaLetras.setBorderPainted(false); 
		add(btnSopaLetras);
		
		JButton btnTerraza = new JButton("");
		btnTerraza.setBounds(458, 211, 151, 329);
		btnTerraza.setOpaque(true); 
		btnTerraza.setContentAreaFilled(false); 
		btnTerraza.setBorderPainted(false); 
		add(btnTerraza);
		
		JButton btnCuadro = new JButton("");
		btnCuadro.setBounds(107, 188, 39, 212);
		btnCuadro.setOpaque(true); 
		btnCuadro.setContentAreaFilled(false); 
		btnCuadro.setBorderPainted(false); 
		add(btnCuadro);
		
		JButton btnSillon = new JButton("");
		btnSillon.setBounds(607, 440, 116, 142);
		btnSillon.setOpaque(true); 
		btnSillon.setContentAreaFilled(false); 
		btnSillon.setBorderPainted(false); 
		add(btnSillon);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\salon.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		

		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Pasillo");
			}
		});

		btnIrCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Cocina");
			}
		});

		btnIrGaraje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Garaje");
			}
		});

		btnSopaLetras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Sopa de letras");
			}
		});

		btnTerraza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("salon1"));
				}
		});

		btnCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("salon2"));
				}
		});

		btnSillon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("salon3"));
				}
		});
		
		btnIrCocina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrCocina.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrCocina.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});
		btnIrGaraje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrGaraje.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrGaraje.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
		btnIrPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaAbajoPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
			}
		});
		
		setVisible(true);
		
	}
	
}
