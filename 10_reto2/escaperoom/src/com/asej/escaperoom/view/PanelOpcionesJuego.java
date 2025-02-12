package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Audio;

public class PanelOpcionesJuego extends JPanel {
	
	private final ButtonGroup buttonGroupEfectos = new ButtonGroup();
	private final ButtonGroup buttonGroupMusica = new ButtonGroup();
	
	private String idioma = "ES";
	public static Locale locale = getDefaultLocale();
	private ResourceBundle mensajes;
	
	public PanelOpcionesJuego(Ventana ventana) {

		//this.mensajes = ventana.getMensajes();		
		
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel(Ventana.mensajes.getString("opciones"));
		lblTitulo.setForeground(Color.WHITE);
        //lblTitulo.setBackground(Color.LIGHT_GRAY);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(392, 66, 300, 100);
        add(lblTitulo);
        
        //JLabel lblEfectos = new JLabel(Ventana.mensajes.getString("efectos"));
        JLabel lblEfectos = new JLabel("Efectos de sonido");
        lblEfectos.setHorizontalAlignment(SwingConstants.CENTER);
        lblEfectos.setForeground(Color.WHITE);
        lblEfectos.setFont(new Font("Segoe UI", Font.BOLD, 20));
        //lblIdioma.setBackground(Color.LIGHT_GRAY);
        lblEfectos.setBounds(392, 192, 300, 50);
        add(lblEfectos);
        
        JToggleButton btnEfectosON = new JToggleButton("Con Efectos");
        btnEfectosON.setBackground(Color.DARK_GRAY);
        btnEfectosON.setForeground(Color.WHITE);
        buttonGroupEfectos.add(btnEfectosON);
        btnEfectosON.setBounds(421, 279, 121, 41);
        add(btnEfectosON);
        
        JToggleButton btnEfectosOFF = new JToggleButton("Sin Efectos");
        buttonGroupEfectos.add(btnEfectosOFF);
        btnEfectosOFF.setBounds(552, 279, 121, 41);
        btnEfectosOFF.setBackground(Color.DARK_GRAY);
        btnEfectosOFF.setForeground(Color.WHITE);
        add(btnEfectosOFF);
        
        btnEfectosON.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(Audio.efectosON);
        		System.out.println(Audio.musicaON);
        		if(btnEfectosON.isSelected()) {
        			Audio.efectosON = true;
        			btnEfectosON.setContentAreaFilled(false);
        			btnEfectosON.setOpaque(true);
        			btnEfectosON.setBackground(Color.BLACK);
        			btnEfectosON.setBackground(Color.DARK_GRAY);
        			Audio.reproducirMusica(Audio.obtenerCancionActual());
        		}
        	}
        });
        
        btnEfectosOFF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(btnEfectosOFF.isSelected()) {
        			Audio.efectosON = false;
        			btnEfectosOFF.setContentAreaFilled(false);
        			btnEfectosOFF.setOpaque(true);
        			btnEfectosOFF.setBackground(Color.BLACK);
        			btnEfectosOFF.setBackground(Color.DARK_GRAY);
        			Audio.detenerMusica();
        		}
        	}
        });
        
        //JLabel lblSonido = new JLabel(Ventana.mensajes.getString("sonido"));
        JLabel lblMusica = new JLabel("Música");
        lblMusica.setHorizontalAlignment(SwingConstants.CENTER);
        lblMusica.setForeground(Color.WHITE);
        lblMusica.setFont(new Font("Segoe UI", Font.BOLD, 20));
        //lblSonido.setBackground(Color.LIGHT_GRAY);
        lblMusica.setBounds(392, 403, 300, 50);
        add(lblMusica);
        
        JToggleButton btnMusicaON = new JToggleButton("Con Música");
        btnMusicaON.setBackground(Color.DARK_GRAY);
        btnMusicaON.setForeground(Color.WHITE);
        buttonGroupMusica.add(btnMusicaON);
        btnMusicaON.setBounds(421, 503, 121, 41);
        add(btnMusicaON);
        
        JToggleButton btnMusicaOFF = new JToggleButton("Sin Música");
        buttonGroupMusica.add(btnMusicaOFF);
        btnMusicaOFF.setBounds(552, 503, 121, 41);
        btnMusicaOFF.setBackground(Color.DARK_GRAY);
        btnMusicaOFF.setForeground(Color.WHITE);
        add(btnMusicaOFF);
        
        btnMusicaON.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(btnMusicaON.isSelected()) {
        			Audio.musicaON = true;
        			btnMusicaON.setContentAreaFilled(false);
        			btnMusicaON.setOpaque(true);
        			btnMusicaON.setBackground(Color.BLACK);
        			btnMusicaOFF.setBackground(Color.DARK_GRAY);
        			Audio.reproducirMusica(Audio.obtenerCancionActual());
        		}
        	}
        });
        
        btnMusicaOFF.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(btnMusicaOFF.isSelected()) {
        			Audio.musicaON = false;
        			btnMusicaOFF.setContentAreaFilled(false);
        			btnMusicaOFF.setOpaque(true);
        			btnMusicaOFF.setBackground(Color.BLACK);
        			btnMusicaON.setBackground(Color.DARK_GRAY);
        			Audio.detenerMusica();
        		}
        	}
        });
        
        JButton btnCerrarOpciones = new JButton("Volver");
        btnCerrarOpciones.setBounds(25, 28, 167, 57);
        btnCerrarOpciones.setBackground(Color.WHITE);
        btnCerrarOpciones.setForeground(Color.DARK_GRAY);
        add(btnCerrarOpciones);
        
        JLabel lblPanelOpcionesFondo = new JLabel("");
        lblPanelOpcionesFondo.setIcon(new ImageIcon("resources\\images\\portada_blurred.png"));
        lblPanelOpcionesFondo.setBounds(0, 0, 1084, 711);
		add(lblPanelOpcionesFondo);
		
		btnCerrarOpciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		/*
        		if(idioma.equalsIgnoreCase("ES")) {
        			Ventana v = new Ventana(getDefaultLocale());
        			v.setVisible(true);
        		} else if(idioma.equalsIgnoreCase("EN")) {
        			Ventana v = new Ventana(Locale.ENGLISH);
        			v.setVisible(true);
        		}
        		//ventana.dispose();
        		setVisible(false);
        		*/
        	}
        });
	}
}
