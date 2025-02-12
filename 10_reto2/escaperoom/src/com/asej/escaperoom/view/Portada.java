package com.asej.escaperoom.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Audio;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Portada extends JPanel {

	private Ventana ventana;
	private JLabel btnOpciones;
	private JLabel btnInstrucciones;
	private JLabel btnJugar;
	private Timer timer;
	private boolean sonido = true;
	private String idioma = "ES";
	private JPanel panelTextos;
	private boolean logoClickado = false;
	
	public Portada(Ventana ventana) {
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		this.ventana = ventana;

        btnJugar = new JLabel();
        btnJugar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setBounds(335, 440, 430, 80);
        btnJugar.setIcon(new ImageIcon(Ventana.mensajes.getString("btnJugar")));
        add(btnJugar);
        
        btnInstrucciones = new JLabel();
        btnInstrucciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnInstrucciones.setBackground(Color.WHITE);
        btnInstrucciones.setBounds(335, 524, 430, 80);
        btnInstrucciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnInstrucciones")));
        add(btnInstrucciones);
        
        btnOpciones = new JLabel();
		btnOpciones.setBackground(Color.WHITE);
		btnOpciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnOpciones.setBounds(335, 608, 430, 80);
		btnOpciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnOpciones")));
		add(btnOpciones);
        
        JLabel lblPortadaFondo = new JLabel("");
		lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen.jpg"));
		lblPortadaFondo.setBounds(0, 0, 1084, 711);
		add(lblPortadaFondo);
		
		//Cambiar cursor en hover
		btnJugar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        		btnJugar.setIcon(new ImageIcon(Ventana.mensajes.getString("btnJugarHover")));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnJugar.setIcon(new ImageIcon(Ventana.mensajes.getString("btnJugar")));
        	}
        });
		btnInstrucciones.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnInstrucciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnInstrucciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnInstruccionesHover")));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnInstrucciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnInstrucciones")));
        	}
        });
		btnOpciones.addMouseListener(new MouseAdapter() {
			@Override
        	public void mouseEntered(MouseEvent e) {
				btnOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnOpciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnOpcionesHover")));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		btnOpciones.setIcon(new ImageIcon(Ventana.mensajes.getString("btnOpciones")));
        	}
        });
		
		lblPortadaFondo.addMouseListener(new MouseAdapter() {	// Abrir panel instrucciones de juego
        	public void mouseClicked(MouseEvent e) {
        		if(!logoClickado) {
        			lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen-keys.jpg"));
        			logoClickado = true;
        		} else {
        			lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen.jpg"));
        			logoClickado = false;
        		}
        	}
        });
		//NAVEGACIÓN BOTONES
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
        		ventana.getTimer().start();
        		ventana.showEscena("Conversacion 2");
        		Ventana.quitarTextoPantalla();
        		//Ventana.mostrarTextoPantalla("Igual en la sala de informática encuentro algo que me ayude");
        		//ventana.getPanelTextos().setVisible(true);
        		//Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("intro"));
        		Audio.reproducirEfectoSonido(Audio.BOTON);
			}
        });
		btnInstrucciones.addMouseListener(new MouseAdapter() {	// Abrir panel instrucciones de juego
        	public void mouseClicked(MouseEvent e) {
        		ventana.getPanelInstrucciones().setVisible(true);
        	}
        });
		btnOpciones.addMouseListener(new MouseAdapter() {	// Abrir panel opciones
        	public void mouseClicked(MouseEvent e) {
        		ventana.getPanelOpciones().setVisible(true);  
        	}
        });
	}
/*
	public JButton getBtnOpciones() {
		return btnOpciones;
		
	}
	*/
}
