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

public class PanelOpciones extends JPanel {
	
	private final ButtonGroup buttonGroupIdioma = new ButtonGroup();
	private final ButtonGroup buttonGroupSonido = new ButtonGroup();
	private boolean sonido = true;
	private String idioma = "ES";
	public static Locale locale = getDefaultLocale();
	private ResourceBundle mensajes;
	
	public PanelOpciones(Ventana ventana) {

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
        
        JLabel lblIdioma = new JLabel(Ventana.mensajes.getString("idioma"));
        lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
        lblIdioma.setForeground(Color.WHITE);
        lblIdioma.setFont(new Font("Segoe UI", Font.BOLD, 20));
        //lblIdioma.setBackground(Color.LIGHT_GRAY);
        lblIdioma.setBounds(392, 192, 300, 50);
        add(lblIdioma);
        
        JToggleButton btnES = new JToggleButton("Castellano");
        buttonGroupIdioma.add(btnES);
        btnES.setBounds(421, 290, 121, 41);
        btnES.setBackground(Color.DARK_GRAY);
        btnES.setForeground(Color.WHITE);
        add(btnES);
        
        JToggleButton btnEN = new JToggleButton("Ingl\u00E9s");
        buttonGroupIdioma.add(btnEN);
        btnEN.setBounds(552, 290, 121, 41);
        btnEN.setBackground(Color.DARK_GRAY);
        btnEN.setForeground(Color.WHITE);
        add(btnEN);
        
        btnES.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(btnES.isSelected()) {
        			idioma = "ES";
        			btnES.setContentAreaFilled(false);
        			btnES.setOpaque(true);
        			btnES.setBackground(Color.BLACK);
        			btnEN.setBackground(Color.DARK_GRAY);
        		}
        	}
        });
        
        btnEN.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(btnEN.isSelected()) {
        			idioma = "EN";
        			btnEN.setContentAreaFilled(false);
        			btnEN.setOpaque(true);
        			btnEN.setBackground(Color.BLACK);
        			btnES.setBackground(Color.DARK_GRAY);
        		}
        	}
        });
        
        JLabel lblSonido = new JLabel(Ventana.mensajes.getString("sonido"));
        lblSonido.setHorizontalAlignment(SwingConstants.CENTER);
        lblSonido.setForeground(Color.WHITE);
        lblSonido.setFont(new Font("Segoe UI", Font.BOLD, 20));
        //lblSonido.setBackground(Color.LIGHT_GRAY);
        lblSonido.setBounds(392, 403, 300, 50);
        add(lblSonido);
        
        JToggleButton tglbtnSonido = new JToggleButton("Con Sonido");
        tglbtnSonido.setBackground(Color.DARK_GRAY);
        tglbtnSonido.setForeground(Color.WHITE);
        buttonGroupSonido.add(tglbtnSonido);
        tglbtnSonido.setBounds(421, 503, 121, 41);
        add(tglbtnSonido);
        
        JToggleButton tglbtnSilenciado = new JToggleButton("Silenciado");
        buttonGroupSonido.add(tglbtnSilenciado);
        tglbtnSilenciado.setBounds(552, 503, 121, 41);
        tglbtnSilenciado.setBackground(Color.DARK_GRAY);
        tglbtnSilenciado.setForeground(Color.WHITE);
        add(tglbtnSilenciado);
        
        tglbtnSonido.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tglbtnSonido.isSelected()) {
        			sonido = true;
        			tglbtnSonido.setContentAreaFilled(false);
        			tglbtnSonido.setOpaque(true);
        			tglbtnSonido.setBackground(Color.BLACK);
        			tglbtnSilenciado.setBackground(Color.DARK_GRAY);
        			Audio.reproducirMusica("op");
        		}
        	}
        });
        
        tglbtnSilenciado.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(tglbtnSilenciado.isSelected()) {
        			sonido = false;
        			tglbtnSilenciado.setContentAreaFilled(false);
        			tglbtnSilenciado.setOpaque(true);
        			tglbtnSilenciado.setBackground(Color.BLACK);
        			tglbtnSonido.setBackground(Color.DARK_GRAY);
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
        		
        		if(idioma.equalsIgnoreCase("ES")) {
        			Ventana v = new Ventana(getDefaultLocale());
        			v.setVisible(true);
        		} else if(idioma.equalsIgnoreCase("EN")) {
        			Ventana v = new Ventana(Locale.ENGLISH);
        			v.setVisible(true);
        		}
        		ventana.dispose();
        		setVisible(false);
        	}
        });
	}
}
