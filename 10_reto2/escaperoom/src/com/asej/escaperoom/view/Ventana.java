package com.asej.escaperoom.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

public class Ventana extends JFrame {

	private JPanel contentPane;


	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1084, 711);
		contentPane.add(layeredPane);
		setLocationRelativeTo(null);
		
		Portada portada = new Portada();
		layeredPane.add(portada, JLayeredPane.POPUP_LAYER);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1084, 711);
		layeredPane.add(panelPrincipal, JLayeredPane.DEFAULT_LAYER);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		
		JPanel navBar = new JPanel();
		navBar.setBounds(0, 0, 1084, 60);
		navBar.setBackground(Color.DARK_GRAY);
		layeredPane.add(navBar, JLayeredPane.PALETTE_LAYER);
		
		JPanel textBar = new JPanel();
		textBar.setBounds(0, 570, 1084, 180);
		textBar.setBackground(Color.DARK_GRAY);
		layeredPane.add(textBar, JLayeredPane.PALETTE_LAYER);
	}

}
