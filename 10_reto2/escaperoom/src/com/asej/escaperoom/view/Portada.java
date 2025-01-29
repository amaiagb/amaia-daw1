package com.asej.escaperoom.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
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

	public Portada() {
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("DigiDoor");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 80));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(0, 0, 435, 220);
        add(lblTitulo);
        
        JButton btnJugar = new JButton("Jugar");
        btnJugar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnJugar.setBackground(Color.WHITE);
        btnJugar.setBounds(100, 200, 200, 60);
        add(btnJugar);
        
        JButton btnGuia = new JButton("Instrucciones");
        btnGuia.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnGuia.setBackground(Color.WHITE);
        btnGuia.setBounds(100, 300, 200, 60);
        add(btnGuia);
        
        JButton btnOpciones = new JButton("Opciones");
		btnOpciones.setBackground(Color.WHITE);
		btnOpciones.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnOpciones.setBounds(100, 400, 200, 60);
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
		btnGuia.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		btnGuia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        	}
        });
		btnGuia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//abrir panel instrucciones de juego
        	}
        });
		btnOpciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//Abrir panel opciones
        	}
        });
	}
}
