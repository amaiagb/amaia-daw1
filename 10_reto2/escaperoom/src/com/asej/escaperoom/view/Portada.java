package com.asej.escaperoom.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
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
	private JButton btnOpciones;
	private JButton btnInstrucciones;
	private JButton btnJugar;
	private Timer timer;
	private boolean sonido = true;
	private String idioma = "ES";
	private JPanel panelTextos;
	
	public Portada(Ventana ventana) {
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		this.ventana = ventana;

		JLabel lblTitulo = new JLabel();
		lblTitulo.setIcon(new ImageIcon("resources\\images\\titulo.png"));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 80));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(-10, 50, 450, 220);
        add(lblTitulo);
        
        btnJugar = new JButton("Jugar");
        btnJugar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setBounds(100, 300, 200, 60);
        add(btnJugar);
        
        btnInstrucciones = new JButton("Instrucciones");
        btnInstrucciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnInstrucciones.setBackground(Color.WHITE);
        btnInstrucciones.setBounds(100, 400, 200, 60);
        add(btnInstrucciones);
        
        btnOpciones = new JButton("Opciones");
		btnOpciones.setBackground(Color.WHITE);
		btnOpciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnOpciones.setBounds(100, 500, 200, 60);
		add(btnOpciones);
        
        JLabel lblPortadaFondo = new JLabel("");
		lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\portada.jpg"));
		lblPortadaFondo.setBounds(0, 0, 1084, 711);
		add(lblPortadaFondo);
		
		//Cambiar cursor en hover
		btnJugar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        });
		btnInstrucciones.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnInstrucciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        });
		btnOpciones.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnOpciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        });
		
		//NAVEGACIÓN BOTONES
		btnJugar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		ventana.getTimer().start();
        		ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Habitacion");
        		ventana.getPanelTextos().setVisible(true);
        	}
        });
		btnInstrucciones.addActionListener(new ActionListener() {	// Abrir panel instrucciones de juego
        	public void actionPerformed(ActionEvent e) {
        		ventana.getPanelInstrucciones().setVisible(true);
        	}
        });
		btnOpciones.addActionListener(new ActionListener() {	// Abrir panel opciones
        	public void actionPerformed(ActionEvent e) {
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
